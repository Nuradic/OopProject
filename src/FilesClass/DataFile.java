package FilesClass;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import ClassFiles.*;

public final class DataFile implements Serializable {
    static final long serialVersionUID = 1L;
      public ArrayList<Customer>customerCollection=new ArrayList<Customer>();
      public ArrayList<Order>orderList=new ArrayList<Order>();
      public ArrayList<Admin>adminList=new ArrayList<Admin>();
      public ArrayList<Food>foodList=new ArrayList<Food>();
      public ArrayList<Delivery>deliverierList=new ArrayList<Delivery>();
      public ArrayList<Complaint>complaintList=new ArrayList<Complaint>();
    //making the class singleton class :instanciate only once
    private static DataFile instance;
    public static DataFile getInstance() {
        if(instance==null){
        instance=new DataFile();
        return instance;
        }
        return instance;
    }
    //the constructor for the class Collection of Customer class
    private DataFile(){
        readFromFile();
        try{
            Customer.count=customerCollection.size()!=0?customerCollection.get(customerCollection.size()-1).getId():0;
            Delivery.count=deliverierList.size()!=0?deliverierList.get(deliverierList.size()-1).getId():0;
            Order.count=orderList.size()!=0?orderList.get(orderList.size()-1).getId():0;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    //differnt methods to manupulate the class
    public Boolean addToCollection(Customer customer){
        if(search(customer.getUsername())==null){
            customerCollection.add(customer);
            return writeToFile();
        }
        return false;
    }
    public Boolean addToCollection(Order order){
        orderList.add(order);
        return writeToFile();
    }
    public void addToCollection(Admin admin){
        if(search(admin.getId())==-1){
            adminList.add(admin);
            writeToFile();
        }
    }
    public Boolean addToCollection(Food food){
        if(search(food)==-1){
            foodList.add(food);
            return writeToFile();
        }
        return false;
    }
    public Boolean addToCollection(Delivery del){
        if(search(del)==-1){
            deliverierList.add(del);
            return writeToFile();
        }
        return false;
    }
    public Boolean addToCollection(Complaint comp){
        complaintList.add(comp);
        System.out.println("Added Succees");
        return writeToFile();

    }
    //sequential search through the collection of customers by id 
    //Search for Customer 
    public int search(Customer customer){
        int len=customerCollection.size();
        for(int i=0;i<len;i++){
            if(customerCollection.get(i).getUsername().equals(customer.getUsername())){
                return i;
            }
        }
        return -1;

    }
    public int search(Order order){
        int len=orderList.size();
        for(int i=0;i<len;i++){
            if(orderList.get(i).getId()==order.getId()){
                return i;
            }
        }
        return -1;
    }
    public Customer search(String  username){
        int len=customerCollection.size();
        for(int i=0;i<len;i++){
            if(customerCollection.get(i).getUsername().equals(username)){
                return customerCollection.get(i);
            }
        }
        Customer customer=null;
        return customer;
    }
    //Search for Admin
    public int search(Admin admin){
        int len=adminList.size();
        for(int i=0;i<len;i++){
            if(adminList.get(i).getId()==admin.getId()){
                return i;
            }
        }
        return -1;
    }
    public int search(int id){
        int len=adminList.size();
        for(int i=0;i<len;i++){
            if(adminList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    public int search(Food food){
        int len=foodList.size();
        for(int i=0;i<len;i++){
            if(foodList.get(i).getName().equals(food.getName())){
                return i;

            }
        }
        return -1;

    }
    //Search for the Deliverier 
    public int search(Delivery del){
        int len=deliverierList.size();
        for(int i=0;i<len;i++){
            if(deliverierList.get(i).getId()==del.getId()){
                return i;
            }
        }
        return -1;
    }
    //Delete customer 
    public void delete(Customer customer){
        int index=search( customer);
        if(index!=-1){
            customerCollection.remove(index);
            writeToFile();
        }

    }
    public void delete(Admin admin){
        int index=search(admin);
        if(index!=-1){
            adminList.remove(index);
            writeToFile();
        }
        
    }
    void delete(Delivery del){
        int index=search(del);
        if(index!=-1){
            deliverierList.remove(index);
            writeToFile();
        }
    }
    public void delete(Food food){
        int index=search(food);
        if(index!=-1){
            foodList.remove(index);
            writeToFile();
        }
    }
    public void delete(Order order){
       System.out.println("problem");
        int index=search(order);
        if(index!=-1){
            orderList.remove(index);
            writeToFile();

        }
    }

    //file related methods are below
    public  Boolean writeToFile(){
           try{
           FileOutputStream fileOutputStream= new FileOutputStream("src/FilesClass/data");
           ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();	
            return true;
        }
        catch(FileNotFoundException e){
            return false;
            //Todo
        }
        catch(IOException e){
            return false;
            //Todo
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            
        }
        return false;
    };
    public  void readFromFile(){
        try{
        FileInputStream myObjInCustomer = new FileInputStream("src/FilesClass/data");
        ObjectInputStream obInCustomer=new ObjectInputStream(myObjInCustomer);
        Object obj=null;
        while((obj=obInCustomer.readObject())!=null){
            if(obj instanceof DataFile){
                int len=((DataFile)obj).customerCollection.size();
                int len2=((DataFile)obj).adminList.size();
                int len3=((DataFile)obj).foodList.size();
                int len4=((DataFile)obj).orderList.size();
                int len5=((DataFile)obj).deliverierList.size();((DataFile)obj).deliverierList.size();
                int len6=((DataFile)obj).complaintList.size();
                for(int i=0;i<len;i++){
                    customerCollection.add(((DataFile)obj).customerCollection.get(i));
                }
                for(int i=0;i<len2;i++){
                    adminList.add(((DataFile)obj).adminList.get(i));
                }
                for(int i=0;i<len3;i++){
                    foodList.add(((DataFile)obj).foodList.get(i));
                }
                for(int i=0;i<len4;i++){
                    orderList.add(((DataFile)obj).orderList.get(i));
                }
                for(int i=0;i<len5;i++){
                    deliverierList.add(((DataFile)obj).deliverierList.get(i));
                }
                for(int i=0;i<len6;i++){
                    complaintList.add(((DataFile)obj).complaintList.get(i));
                }
            }
        }
        obInCustomer.close();}
        catch(FileNotFoundException e){
            
            e.printStackTrace();
            //Todo thiss....
        }catch(IOException e){
            //Todo this
    
        }catch(ClassNotFoundException e){
    
        }catch(Exception e){
            e.printStackTrace();
        }
        //Todo finish me...
    }  
    

}
