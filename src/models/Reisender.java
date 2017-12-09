package models;

public class Reisender {
    private String fName;
    private String lName;
    private String street;
    private String number;
    private String zip;
    
    //empty constructor....
    public Reisender(){};
    public Reisender(String fName, String lName, String street, String number, String zip) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.number = number;
        this.zip = zip;
    }
    
    public String getfName() {
        return fName;
    }
    
    public void setfName(String fName) {
        this.fName = fName;
    }
    
    public String getlName() {
        return lName;
    }
    
    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getZip() {
        return zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
}
