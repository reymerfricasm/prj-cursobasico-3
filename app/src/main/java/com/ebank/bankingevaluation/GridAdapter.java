package com.ebank.bankingevaluation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        amount.setText("RD$50,000.00");
        rate.setText("16.95%");
        time.setText("120");
        currentCapital.setText("RD$48,000.00");
        interest.setText("RD$169.95");
        capitalPayment.setText("RD$1,755.02");
        return  convertView;
    }
}
