package ClassFiles;
import java.io.Serializable;
import java.util.ArrayList;
public class Delivery implements Serializable{
    private String deliverier_name;
    private int id;
    private ArrayList<Order> orderList=new ArrayList<Order>();
    public static int count=0;
    public Delivery(String name,Order order){
        deliverier_name = name;
        id=Delivery.count;
        Delivery.count++;
        orderList.add(order);
    }
    public int getId() {
        return id;
    }
    public String getDeliverier_name() {
        return deliverier_name;
    }
    public ArrayList<Order> getOrder() {
        return orderList;
    }
    // public void setOrder(Order order) {
    //     this.order = order;
    // }
}
