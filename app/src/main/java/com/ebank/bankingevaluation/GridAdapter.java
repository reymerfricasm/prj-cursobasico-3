package com.ebank.bankingevaluation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Currency;
import java.util.List;
import java.util.Objects;

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

            amount.setText(String.format("Monto: RD$%s", Double.toString(Objects.requireNonNull(table).amount)));
            rate.setText(String.format("Tasa:%%%s", Double.toString(table.rate)));
            time.setText(String.format("Pago:%s", Double.toString(table.time)));
            payment.setText(String.format("Cuota: RD$%s", Double.toString(table.payment)));
            interest.setText(String.format("Interes: %s", Double.toString(table.interest)));
            capitalPayment.setText(String.format("Pago capital: RD$%s", Double.toString(table.capitalPayment)));
            currentCapital.setText(String.format("Capital restante: RD$%s", Double.toString(table.currentCapital)));
        return  convertView;
    }
}
