package com.ebank.bankingevaluation;


public class Amortization {
    public double amount;
    public double rate;
    public double time;
    public double currentCapital;
    public double interest;
    public double capitalPayment;
    public double payment;

    public Amortization(double amount, double rate, double time, double currentCapital, double interest, double capitalPayment, double payment){
        this.amount = amount;
        this.rate = rate;
        this.time = time;
        this.currentCapital = currentCapital;
        this.interest = interest;
        this.capitalPayment = capitalPayment;
        this.payment = payment;
    }
    public Amortization(){

    }
}
