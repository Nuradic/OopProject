
package ClassFiles;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID =1L;
    //field variables for the order class 
    private ArrayList<Food> foodList =new ArrayList<>();
    private  int id;
    public static int count;
    private Customer customer;
    private String whenOrdered;
    private Date whenWillDeliver;
    private int totalPrice;
    public Order(ArrayList<Food> foodList,Customer customer){
        this.foodList= foodList;
        this.customer = customer;
        whenOrdered =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        id=Order.count;
        Order.count++;
        setTotalPrice();
    }
    
    //setters for the field variables
    public void setWhenWillDeliver(Date whenWillDeliver) {
        this.whenWillDeliver = whenWillDeliver;
    };
    public void setTotalPrice() {
        for(int i=0;i<foodList.size();i++){
            totalPrice =totalPrice+foodList.get(i).getPrice();
        }
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
    
    public String getWhenOrdered() {
        return whenOrdered;
    };
    
    public Date getWhenWillDeliver() {
        return whenWillDeliver;
    }
    
    public int getTotalPrice() {
        return totalPrice;
    }
    
    
}
