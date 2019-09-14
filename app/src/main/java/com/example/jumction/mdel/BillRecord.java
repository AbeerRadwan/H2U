package com.example.jumction.mdel;

public class BillRecord {
    int ID;
    double Amount ;
    int Month;

    public BillRecord(int ID, double amount, int month) {
        this.ID = ID;
        Amount = amount;
        Month = month;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }
}
