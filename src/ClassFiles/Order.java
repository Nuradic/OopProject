
package ClassFiles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID =1L;
    //field variables for the order class 
    private ArrayList<Food> foodList =new ArrayList<>();
    private  int id;
    public static int count=0;
    private Customer customer;
    private Date whenOrdered;
    private Date whenWillDeliver;
    private Boolean isPayed;
    public class Food{
        
    }
    public Order(ArrayList<Food> foodList,Customer customer,Date d){
        this.foodList= foodList;
        this.customer = customer;
        whenOrdered=d;
    }
    
    //setters for the field variables
    public void setWhenWillDeliver(Date whenWillDeliver) {
        this.whenWillDeliver = whenWillDeliver;
    };
    public void setIsPayed(Boolean isPayed) {
        this.isPayed = isPayed;
    }
    //getters of field variables
    public int getId(){
        return id;
    }
    public ArrayList<Food> getFoodNames() {
        return foodList;
    }
    public Customer getWhoOrdered() {
        return customer;
    }
    
    public Date getWhenOrdered() {
        return whenOrdered;
    };
    
    public Date getWhenWillDeliver() {
        return whenWillDeliver;
    }
    
    public Boolean getIsPayed() {
        return isPayed;
    }
    
    
}
