package za.ac.cput.factory.person;

import za.ac.cput.entity.person.Patient;
import za.ac.cput.util.GenericHelper;

public class PatientFactory {
    public static Patient build(String firstName, String lastName, String contactNumber, String addressNumber){
        if(firstName.isEmpty() || lastName.isEmpty() || contactNumber.length() != 10 || firstName.length() < 2 || lastName.length() < 3)
            return null;
        //Address address = null;
        String patientNumber = GenericHelper.IDGenerator();
        //addressNumber = address.getAddressNumber();

        return new Patient.Builder()
                .setPatientNumber(patientNumber).setFirstName(firstName).setAddressNumber(addressNumber)
                .setLastName(lastName)
                .setContactNumber(contactNumber).build();
    }
}
