package za.ac.cput.gui.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.person.Patient;
import za.ac.cput.factory.person.PatientFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientHttp {

    @Autowired
    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String patientURL = "http://localhost:8080/patient";

    private String username = "user";
    private String password = "password";
    public void save(String name, String lastName, String contactNumber, String addressNumber){
        Patient patient = PatientFactory.build(name,lastName,contactNumber,addressNumber);
        String url = patientURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Patient> httpEntity = new HttpEntity<>(patient, httpHeaders);
        ResponseEntity<Patient> responseEntity = testRestTemplate.postForEntity(url, httpEntity, Patient.class);
        patient = responseEntity.getBody();
    }
    public String check(String patientNumber){
        String url = patientURL + "/read/" +patientNumber;
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Patient> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Patient> responseCreate = testRestTemplate.postForEntity(url, request, Patient.class);
        return responseCreate.getBody().getPatientNumber() + responseCreate.getBody().getFirstName()
                + responseCreate.getBody().getLastName();
    }
    public String getAll(){
        String url = patientURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = testRestTemplate.withBasicAuth(username, password).exchange(url, HttpMethod.GET, httpEntity, String.class);
         return responseGetAll.getBody();
    }
    public void Update(Patient patient, String name, String lastName,String contactNumber,String addressNumber){
        Patient updatedPatient = new Patient.Builder().copy(patient)
                .setFirstName(name).setLastName(lastName)
                .setContactNumber(contactNumber).setAddressNumber(addressNumber).build();
        String url = patientURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Patient> httpEntity = new HttpEntity<>(updatedPatient, httpHeaders);
        ResponseEntity<Patient> responseUpdate = testRestTemplate.exchange(url, HttpMethod.POST, httpEntity, Patient.class);
    }
    public void delete(String patientNumber){
        String url = patientURL + "/delete/" + patientNumber;
        testRestTemplate.delete(url);
    }

}
