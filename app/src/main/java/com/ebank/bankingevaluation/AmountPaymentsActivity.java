package com.ebank.bankingevaluation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.List;

public class AmountPaymentsActivity extends AppCompatActivity{
    private EditText mAmount, mRate, mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_payments);
        setBasicView();
        GridView gridView = findViewById(R.id.gridViewComponent);

        Financial bank = Financial.getInstance();
        final List<Amortization> table = new ArrayList<>();

        table.addAll(bank.getAmortization(500,10.1, 120));
        GridAdapter adapter = new GridAdapter(this, table);
        gridView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            confirmBack();
        }
        return super.onOptionsItemSelected(item);
    }
    private void confirmBack(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.app_name));
            builder.setMessage(R.string.confirm);

            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onBackPressed();
                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    private void setBasicView(){
        getSupportActionBar().setTitle(R.string.amortizationView);
        getSupportActionBar().setSubtitle(R.string.paymentsDetails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
