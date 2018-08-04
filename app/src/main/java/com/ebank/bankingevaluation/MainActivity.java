package com.ebank.bankingevaluation;

import android.content.Intent;
import android.os.strictmode.CleartextNetworkViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mAmountText, mRateText, mTimeText;
    private String[] data = new String[3];
    public static final String INTENT_KEY = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBasicView();
        setListeners();
    }

    @Override
    public void onClick(View vi){
        switch (vi.getId()){
            case R.id.clear:
                CleanText();
                break;
            case R.id.calculate:
                if(validateNotNullValues()){
                    data[0] = mAmountText.getText().toString();
                    data[1] = mRateText.getText().toString();
                    data[2] = mTimeText.getText().toString();
                    Intent intent = new Intent(MainActivity.this, AmountPaymentsActivity.class);
                    intent.putExtra(INTENT_KEY, data);
                    startActivity(intent);
                } else {
                    sendExceptionMessage();
                }
                break;
        }
    }
    private void sendExceptionMessage() {
        Toast.makeText(this, R.string.nullValues, Toast.LENGTH_SHORT).show();
    }
    private boolean validateNotNullValues(){
        mAmountText = findViewById(R.id.amountEdit);
        mRateText = findViewById(R.id.rateEdit);
        mTimeText = findViewById(R.id.timeEdit);
        String amount = mAmountText.getText().toString();
        String rate = mRateText.getText().toString();
        String time = mTimeText.getText().toString();

        return amount.isEmpty() || rate.isEmpty() || time.isEmpty() ? false : true;
    }
    private void CleanText(){
        mAmountText = findViewById(R.id.amountEdit);
        mRateText = findViewById(R.id.rateEdit);
        mTimeText = findViewById(R.id.timeEdit);

        mAmountText.setText("");
        mRateText.setText("");
        mTimeText.setText("");
    }
    private void setBasicView(){
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.mainActivityMsg);
        getSupportActionBar().setSubtitle(R.string.subTitleMainActivityMsg);
    }
    private void setListeners(){
        findViewById(R.id.clear).setOnClickListener(this);
        findViewById(R.id.calculate).setOnClickListener(this);
    }
}
