package za.ac.cput.factory.person;

import za.ac.cput.entity.person.Patient;
import za.ac.cput.util.GenericHelper;

public class PatientFactory {
    public static Patient build(String firstName, String lastName, String addressNumber,String contactNumber){
        if(firstName.isEmpty() || lastName.isEmpty())
            return null;

        String patientNumber = GenericHelper.IDGenerator();

        return new Patient.Builder()
                .setPatientNumber(patientNumber).setFirstName(firstName).setLastName(lastName)
                .setAddressNumber(addressNumber)
                .setContactNumber(contactNumber).build();
    }
}
