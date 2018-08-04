package com.ebank.bankingevaluation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Currency;
import java.util.List;

public class GridAdapter extends ArrayAdapter<Amortization> {

    public GridAdapter(Context context, List<Amortization> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Amortization table = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_view_items, parent, false);
        }
        TextView amount = convertView.findViewById(R.id.amountItems);
        TextView rate = convertView.findViewById(R.id.rateId);
        TextView time = convertView.findViewById(R.id.timeId);
        TextView currentCapital = convertView.findViewById(R.id.currentCapitalId);
        TextView interest = convertView.findViewById(R.id.interestId);
        TextView capitalPayment = convertView.findViewById(R.id.capitalPaymentId);
        TextView payment = convertView.findViewById(R.id.paymentId);

        amount.setText("Monto: RD$" + Double.toString(table.amount));
        rate.setText("Tasa:%" + Double.toString(table.rate));
        time.setText("Pago:" + Double.toString(table.time));
        payment.setText("Cuota: RD$" + Double.toString(table.payment));
        interest.setText("Interes: " + Double.toString(table.interest));
        capitalPayment.setText("Pago capital: RD$" + Double.toString(table.capitalPayment));
        currentCapital.setText("Capital restante: RD$" + Double.toString(table.currentCapital));
        return  convertView;
    }
}
