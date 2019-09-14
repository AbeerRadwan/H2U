package com.example.jumction.mdel;

public class report {
    String date ;
    int budget;
    int Actual;

    public report(String date, int budget, int actual) {
        this.date = date;
        this.budget = budget;
        this.Actual = actual;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getActual() {
        return Actual;
    }

    public void setActual(int actual) {
        Actual = actual;
    }
}
