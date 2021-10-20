package za.ac.cput.factory.general;

import za.ac.cput.entity.general.Address;

public class AddressFactory {
    public static Address build(String houseNumber, String streetName, String suburb, String postalCode) {
        if ( houseNumber.isEmpty()|| streetName.isEmpty() || suburb.isEmpty() || postalCode.isEmpty())

            return null;
        int rand = (int) (Math.random() * (1000 - 1 + 1) + 1);
        String addressNumber = "AN" + Integer.toString(rand) + streetName.charAt(0);


        return new Address.Builder()
                .setAddressNumber(addressNumber).setHouseNumber(houseNumber)
                .setStreetName(streetName).setSuburb(suburb).setPostalCode(postalCode).build();
    }
}
