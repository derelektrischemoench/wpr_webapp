package models;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.io.Serializable;
import java.util.Date;

public class Rechnung implements Serializable{
    private int total;
    private int numPeople;
    private Date invoiceDate;
    
    
    /*TODO! !important the empty costructor needs to be present @ all models*/
    public Rechnung() {};
    public Rechnung(int total, int numPeople) {
        this.total = total;
        this.numPeople = numPeople;
        this.invoiceDate = new Date();
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public int getNumPeople() {
        return numPeople;
    }
    
    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }
    
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
