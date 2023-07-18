package main.java.others;

/**
 * Author: Group 5
 * Written on: within August/2022
 * Project: TeslaRentalInventory
 **/

public class Account {
    int accID;
    String cusName;
    String accName;
    int cusID;
    String paymethod;
    String user;

    public Account(int accID, String cusName, String accName, String paymethod) {
        this.accID = accID;
        this.cusName = cusName;
        this.accName = accName;
        this.paymethod = paymethod;
    }

    public Account(int accID, String accName, int cusID, String user, String paymethod) {
        this.accID = accID;
        this.accName = accName;
        this.cusID = cusID;
        this.user = user;
        this.paymethod = paymethod;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

}
