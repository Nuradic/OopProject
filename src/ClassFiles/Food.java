package ClassFiles;

import java.io.Serializable;

public class Food implements Serializable{
    private String name;
    private int amount;
    private int price;
    private int howMany;
    public void updateAmount(){
        this.amount=amount-1;
    }
    public int getHowMany() {
        return howMany;
    }
    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    //class Constructor : 
    public Food(String name,int amount,int price){
        this.name=name;
        this.price=price;
        this.amount=amount;
    }
    
}
