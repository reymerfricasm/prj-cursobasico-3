package com.ebank.bankingevaluation;

import android.content.Intent;
import android.os.strictmode.CleartextNetworkViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mAmountText, mRateText, mTimeText;

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
                if(validateNotNullValues()){ //just true
                    startActivity(new Intent(this, AmountPaymentsActivity.class));
                } else { //case false
                    sendExceptionMessage();
                }
                break;
        }
    }
    private void sendExceptionMessage() {
        Toast.makeText(this, R.string.nullValues, Toast.LENGTH_SHORT);
    }
    private boolean validateNotNullValues(){
        mAmountText = findViewById(R.id.amountEdit);
        mRateText = findViewById(R.id.rateEdit);
        mTimeText = findViewById(R.id.timeEdit);

        if(mAmountText.getText().equals(null) && mTimeText.getText() != null && mRateText.getText() != null){
            return true;
        } else{
            return false;
        }
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
        getSupportActionBar().setTitle(R.string.mainActivityMsg);
        getSupportActionBar().setSubtitle(R.string.subTitleMainActivityMsg);
    }
    private void setListeners(){
        findViewById(R.id.clear).setOnClickListener(this);
        findViewById(R.id.calculate).setOnClickListener(this);
    };
}
