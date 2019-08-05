package datamodels;

import java.util.ArrayList;
import java.io.Serializable;

public abstract class Person implements Serializable{
   private String name;
    private String address;
    private java.time.LocalDate dateOfBirth;
    
    public void setName(String p_name){
        name = p_name;
    }
    
    public void setAddress(String p_address){
        address = p_address;
    }
    
    public void setDateOfBirth(java.time.LocalDate p_dateOfBirth){
        dateOfBirth = p_dateOfBirth;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public java.time.LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
}
