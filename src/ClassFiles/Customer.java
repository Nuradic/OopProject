package ClassFiles;
import java.io.Serializable;
public class Customer implements Serializable {
    //field variables for the customer class that
    //implementing serializable class is necesarry to write on file as an object
    private static final long serialVersionUID =1L;
    public static int count=0;
    private int id;
    private String username;
    private String fullName;
    private String phoneNumber;
    private String password="password is not set";
    private String address;
    private Boolean isBanned=false;
    private Boolean isVerified=false;
    
    //setters for the class field variabless
    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
    public void setIsBanned(Boolean isBanned) {
        this.isBanned = isBanned;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    //getters for the field variables
    public int getId() {
        return id;
    }
    public Boolean getIsVerified() {
        return isVerified;
    }
    public String getUsername() {
        return username;
    }
    public String getFullName() {
        return fullName;
    };
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPassword() {
        return password;
    }
    public String getAddress() {
        return address;
    };
    public Boolean getIsBanned() {
        return isBanned;
    }
    //classs constructor
    public Customer(String name, String username,String password) {
        fullName = name;
        this.username=username;
        this.password=password;
        id=Customer.count;
        Customer.count++;
        //Todo finish this    
       }
    //methods for the class object manupullation
    void placeOrder(){
     //Todo finish this
    }
    void makeComplaints(){
     //Todo finish this
    }
    void rateRest(){
     //Todo finish this
    }

}
