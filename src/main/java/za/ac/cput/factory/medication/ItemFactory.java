package za.ac.cput.factory.medication;

//Na'eem Mahoney
//218190751
//ADP3
//Capstone - Back-End
//Factory for Item Entity

import za.ac.cput.entity.medication.Item;
import za.ac.cput.util.GenericHelper;

public class ItemFactory {
    public static Item build(String itemName, String itemType, double itemPrice){

        //Generate ID
        String itemID = GenericHelper.IDGenerator();

        //Check if values are null
        if(itemName.isEmpty() || itemPrice < 0 || itemType.isEmpty()) {
            return null;
        }

        //Return Item
        return new Item.Builder().itemID(itemID).itemName(itemName).itemType(itemType).itemPrice(itemPrice).builder();
    }
}

