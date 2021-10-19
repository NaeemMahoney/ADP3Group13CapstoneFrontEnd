package za.ac.cput.gui.item;

//Na'eem Mahoney
//218190751
//ADP3
//Group 13
//Capstone - Front-End
//httpmethods

//Imports
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.medication.Item;
import za.ac.cput.factory.medication.ItemFactory;

import javax.swing.*;

public class httpmethods {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    //Main Controller Url
    private String MainUrl = "http://localhost:8080/item";

    //Save Method with parameters
    public void saveItem(String itemName, String itemType, double itemPrice, double itemStock){

        //Use parameters to build new Item
        Item item = ItemFactory.build(itemName, itemType, itemPrice, itemStock);

        //Url used to create new Item
        String url =MainUrl +"/create";

        //Applying Password and username to hearders
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Item> request = new HttpEntity<>(item, headers);

        //PostForEntity using url to create
        ResponseEntity<Item> response = restTemplate.postForEntity(url, request, Item.class);

        if (response.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Item Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Item Not Saved");
        }

    }

    //Delete Method with ID parameter
    public void deleteItem(String id){
        Item h = null;

        //Url used to delete Item
        String url = MainUrl+ "/delete/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //HTTpEntity with null
        HttpEntity<String> request = new HttpEntity<>(null, headers);

        //PostForEntity - exchange with Delete method
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);

    }

    //Find Method with ID parameter
    public Item findItem(String id){
        Item i = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Item> request = new HttpEntity<>(i, headers);

        //PostForEntity using url to read
        ResponseEntity<Item> response = restTemplate.postForEntity(url, request, Item.class);

        return response.getBody();
    }

    //Update method with Item Parameter
    public void updateItem(Item item){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Item> request = new HttpEntity<>(item, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Item> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, request, Item.class);
    }
}
