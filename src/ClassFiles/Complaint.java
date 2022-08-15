package ClassFiles;

import java.io.Serializable;
import java.util.Date;

public class Complaint implements Serializable {
    // static final long serialVersionUID = 1L;
    private Customer customer;
    private Date date;
    private Order order;
    private int id;
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public static int count=0;
    //Constructor of the class constructor
    public Complaint(Customer customer,String description){
        this.customer=customer;
        this.description=description;
        // this.date=date;
        id=Complaint.count;
        Complaint.count++;
    }
    //setters for the class constructor
    void setOrder(Order order){
        this.order=order;
    }
    void setDate(Date date){
        this.date=date;
    }
    public Customer getCustomer(){
        return customer;
    }
    int getId(){
        return id;
    }
    Date getDate(){
        return date;
    }
    Order getOrder(){
        return order;
    }
    
}
