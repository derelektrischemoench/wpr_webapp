package models;
import java.io.Serializable;

public class Kunde implements Serializable {
    private String sName;
    private String sVorname;
    private String sEmail;
    private String sPassword;
    
    //this is an example of overloading; if the constructor receives arguments it takes the second one, if not it takes the first
    public Kunde(){};
    
    public Kunde(String sName, String sVorname, String sEmail) {
        super();
        this.sName = sName;
        this.sVorname = sVorname;
        this.sEmail = sEmail;
    }
    
    public String getsName() {
        return sName;
    }
    
    public void setsName(String sName) {
        this.sName = sName;
    }
    
    public String getsVorname() {
        return sVorname;
    }
    
    public void setsVorname(String sVorname) {
        this.sVorname = sVorname;
    }
    
    public String getsEmail() {
        return sEmail;
    }
    
    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }
    
    public String getsPassword() {
        return sPassword;
    }
    
    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
    
    //Get the customer Data as String:
    public String serializeKunde() {
        return "Kunde [sname=" + sName + ", sVorname=" + sVorname + ", sEmail=" + sEmail + "]";
    }
    
}
