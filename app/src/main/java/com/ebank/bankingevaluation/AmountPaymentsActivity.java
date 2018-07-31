package com.ebank.bankingevaluation;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class AmountPaymentsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_payments);
        setBasicView();
        GridView gridView = findViewById(R.id.gridViewComponent);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            list.add(Integer.toString(i  + 1));
        }
        gridView.setAdapter(new ArrayAdapter<>(this, R.layout.activity_grid_view_item, list));
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
            builder.setMessage("Seguro que deseas ir atras");

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
