package com.ebank.bankingevaluation;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.rtp.RtpStream;
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
    private TextView mAmount, mRate, mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_payments);
        setBasicView();

        GridView gridView = findViewById(R.id.gridViewComponent);
        mAmount = findViewById(R.id.amount2);
        mRate = findViewById(R.id.rate2);
        mTime = findViewById(R.id.time2);

        init();

        Financial bank = Financial.getInstance();
        final List<Amortization> table = new ArrayList<>();

        table.addAll(bank.getAmortization(Double.parseDouble(mAmount.getText().toString()),
                                          Double.parseDouble(mRate.getText().toString()),
                                          Double.parseDouble(mTime.getText().toString())));
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
    private void init(){
        Intent intent = getIntent();
        String[] data = new String[3];
        if(intent.hasExtra(MainActivity.INTENT_KEY) && !intent.getStringArrayExtra(MainActivity.INTENT_KEY).equals("")){
            data = intent.getStringArrayExtra(MainActivity.INTENT_KEY);
        }
        mAmount.setText(data[0]);
        mRate.setText(data[1]);
        mTime.setText(data[2]);
    }
}
