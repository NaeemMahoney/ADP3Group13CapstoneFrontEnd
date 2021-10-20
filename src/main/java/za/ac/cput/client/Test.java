package za.ac.cput.client;

public class Test {

    public static void main(String[] args) {
        post();
    }

    public static void get(){
        RestClient client = new RestClient();
        Address add = client.get("http://localhost:8080/address/read/AN651s", Address.class);
        System.out.println(add.toString());
    }

    public static void post() {
            RestClient client = new RestClient();
            Address address = new Address();
            address.setHouseNumber("88");
            address.setPostalCode("7800");
            address.setSuburb("Rondebosch");
            address.setStreetName("MiddelRoad");
            Address add = client.post("http://localhost:8080/address/create", address, Address.class);
            System.out.println(add.toString());
    }
}
