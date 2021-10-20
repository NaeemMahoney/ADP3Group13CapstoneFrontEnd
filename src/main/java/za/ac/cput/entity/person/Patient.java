package za.ac.cput.entity.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    private String patientNumber;
    private String addressNumber, firstName, lastName, contactNumber;

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
        private String patientNumber,addressNumber ,firstName, lastName, contactNumber;

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
            this.contactNumber = patient.contactNumber;
            this.patientNumber = patient.patientNumber;
            this.addressNumber = patient.addressNumber;
            this.firstName = patient.firstName;
            this.lastName = patient.lastName;
            return this;
        }


    }
    @Override
    public String toString() {
        return "Patient{" +
                "patientNumber='" + patientNumber + '\'' +
                "addressNumber='" + addressNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
