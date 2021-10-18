package za.ac.cput.gui.item;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        //PostForEntity
        ResponseEntity<Item> response = restTemplate.postForEntity(url, request, Item.class);

        if (response.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Item Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Item Not Saved");
        }

    }

    //Delete Method with ID parameter
    public void deleteItem(String id){
        String url = MainUrl+ "/delete/"+id;
        restTemplate.delete(url);
    }

    //Find Method with ID parameter
    public Item findItem(String id){
        Item i = null;
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Item> request = new HttpEntity<>(i, headers);

        //PostForEntity
        ResponseEntity<Item> response = restTemplate.postForEntity(url, request, Item.class);

        return response.getBody();
    }
}
