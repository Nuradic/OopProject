package ClassFiles;

import java.io.Serializable;

public class Admin implements Serializable{
    private int id;
    private String name;
    private String password;
    public Admin(int id,String name,String password){
        this.id=id;
        this.name=name;
        this.password=password;
    }
    //setters for the class 
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    //Getters for the class 
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
}