package za.ac.cput.entity.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    private String patientNumber;
    private String  firstName, lastName, addressNumber, contactNumber;

    private Patient (){}

    public Patient(Builder builder){
        this.patientNumber = builder.patientNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contactNumber = builder.contactNumber;
        this.addressNumber = builder.addressNumber;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    //builder pattern
    public static class Builder{
        private String patientNumber,firstName, lastName,addressNumber , contactNumber;

        public Builder setPatientNumber(String patientNumber) {
            this.patientNumber = patientNumber;
            return this;
        }

        public Builder setAddressNumber(String patientNumber) {
            this.patientNumber = patientNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Patient build(){
            return new Patient(this);
        }

        public Builder copy(Patient patient){
            this.patientNumber = patient.patientNumber;
            this.firstName = patient.firstName;
            this.lastName = patient.lastName;
            this.addressNumber = patient.addressNumber;
            this.contactNumber = patient.contactNumber;
            return this;
        }


    }
    @Override
    public String toString() {
        return "Patient{" +
                "patientNumber='" + patientNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName+ '\''+
                "addressNumber='" + addressNumber + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
