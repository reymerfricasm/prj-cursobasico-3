package com.ebank.bankingevaluation;

import java.util.ArrayList;
import java.util.List;

public class Financial {

    private static Financial mSingleton = null;
    private final double YEAR = 12;
    private final double CIEN = 100;

    private Financial(){
    }

    public static Financial getInstance() {
        if(mSingleton == null){
            mSingleton = new Financial();
        }
        return  mSingleton;
    }

    public List<Amortization> getAmortization(double amount, double rate, double time){
        double tempRate = (rate / CIEN) / YEAR;
        double r = amount * (tempRate * Math.pow((1 + tempRate), time)) / (Math.pow((1 + tempRate), time) - 1);
        List<Amortization> table = new ArrayList<>();
        Amortization model = new Amortization();
        for ( int i = 1; i <= time; i++ ){
            model.rate = rate;
            model.amount = amount;
            model.time = time;
            model.interest = amount * tempRate;
            model.capitalPayment = r - model.interest;
            amount = amount - model.capitalPayment;
            model.currentCapital = amount - model.capitalPayment;
            table.add(model);
        }
        return table;
    }
}
