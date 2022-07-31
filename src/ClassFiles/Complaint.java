package ClassFiles;

import java.util.Date;

public class Complaint {
    private Customer customer;
    private Date date;
    private Order order;
    private int id;
    public static int count=0;
    //Constructor of the class constructor
    Complaint(Customer customer,Date date){
        this.customer=customer;
        this.date=date;
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
    Customer getCustomer(){
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
