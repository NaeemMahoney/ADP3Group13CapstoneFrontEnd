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
import java.util.HashSet;
import java.util.Set;

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
        HttpEntity<Item> httpEntityCreate = new HttpEntity<>(item, headers);

        //PostForEntity using url to create
        ResponseEntity<Item> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Item.class);

        if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
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
        HttpEntity<String> httpEntityDelete = new HttpEntity<>(null, headers);

        //PostForEntity - exchange with Delete method
        ResponseEntity<String> responseDelete = restTemplate.exchange(url, HttpMethod.DELETE, httpEntityDelete, String.class);

    }

    //Find Method with ID parameter
    public Item findItem(String id){
        Item i = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Item> httpEntityRead = new HttpEntity<>(i, headers);

        //PostForEntity using url to read
        ResponseEntity<Item> responseRead = restTemplate.postForEntity(url, httpEntityRead, Item.class);

        return responseRead.getBody();
    }

    //Update method with Item Parameter
    public void updateItem(Item item){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Item> httpEntityUpdate = new HttpEntity<>(item, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Item> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Item.class);
    }

    //Get All method with Set Parameter
    public Set<Item> getItems(){

        //Create new Set
        Set<Item> itemsSet = new HashSet<>();

        //Create Array
        Item[] items;

        //Url used to get All Items
        String url = MainUrl+"/getall";

        //Applying Password and username to headers
        headers.setBasicAuth("user","password");

        //HttpEntity
        HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

        //ResponseEntity - exchange
        ResponseEntity<Item[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Item[].class);

        //Store response body in array
        items = responseGetAll.getBody();

        //loop through array and add each item into the set
        for (Item item : items){
            itemsSet.add(item);
        }
        return itemsSet;
    }
}
