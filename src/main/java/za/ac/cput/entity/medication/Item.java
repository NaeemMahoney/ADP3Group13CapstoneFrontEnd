package za.ac.cput.entity.medication;

//Na'eem Mahoney
//218190751
//ADP3
//Capstone - Front-End
//Class for Item Entity

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    private String itemID;
    private String itemName, itemType;
    private double itemPrice;

    private Item(){}

    private Item(Builder builder){
        this.itemID=builder.itemID;
        this.itemName=builder.itemName;
        this.itemType=builder.itemType;
        this.itemPrice=builder.itemPrice;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public double getItemPrice() {
        return itemPrice;
    }
    //Builder for Item Entity
    public static class Builder{
        private String itemID;
        private String itemName, itemType;
        private double itemPrice;

        public Builder itemID(String itemID){
            this.itemID = itemID;
            return this;
        }

        public Builder itemName(String itemName){
            this.itemName = itemName;
            return this;
        }

        public Builder itemPrice(double itemPrice){
            this.itemPrice = itemPrice;
            return this;
        }

        public Builder itemType(String itemType){
            this.itemType = itemType;
            return this;
        }

        public Item builder(){
            return new Item(this);
        }

        public Builder copy(Item item) {
            this.itemID = item.itemID;
            this.itemName = item.itemName;
            this.itemPrice = item.itemPrice;
            this.itemType = item.itemType;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
