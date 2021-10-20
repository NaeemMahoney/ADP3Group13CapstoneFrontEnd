package za.ac.cput.entity.general;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
 public class Address
{
    @Id
    private String addressNumber; //Declaring strings
    private String houseNumber;
    private String streetName;
    private String suburb;
    private String postalCode;

    public Address(){

    }

    public Address(Builder builder)
    {

        this.addressNumber = builder.addressNumber;
        this.houseNumber = builder.houseNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.postalCode = builder.postalCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostalCode() {
        return postalCode;
    }

    //builder pattern
    public static class Builder   //Builder class
    {
        private String addressNumber;
        private String houseNumber;
        private String streetName;
        private String suburb;
        private String postalCode;

        public Builder setAddressNumber(String addressNumber)
        {
            this.addressNumber = addressNumber;
            return this;
        }

        public Builder setHouseNumber(String houseNumber)
        {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder setStreetName(String streetName)
        {
            this.streetName = streetName;
            return this;
        }

        public Builder setSuburb(String suburb)
        {
            this.suburb = suburb;
            return this;
        }

        public Builder setPostalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }

        public Builder copy(Address address){
            this.addressNumber = address.addressNumber;
            this.houseNumber = address.houseNumber;
            this.streetName = address.streetName;
            this.suburb = address.suburb;
            this.postalCode = address.postalCode;
            return this;
        }

    }



        @Override
    public String toString() {
        return "Address{" +
                "addressNumber='" + addressNumber + '\'' +
                ",houseNumber='" + houseNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
