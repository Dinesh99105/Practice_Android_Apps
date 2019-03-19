package com.syntaxcbpgec.tipcalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etBillAmount;
    TextView tvTipPercent;
    TextView tvTipAmount;
    TextView tvBillTotalAmount;
    ImageButton ibRegularService,ibGoodService,ibExcellentService;

    float percentage = 0;
    float tipTotal = 0;
    float finalBillAmount = 0;
    float totalBillAmount = 0;
    float REGULAR_TIP_PERCENTAGE = 10;
    float DEFAULT_TIP_PERCENTAGE = 15;
    float EXCELLENT_TIP_PERCENTAGE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etBillAmount=findViewById(R.id.etBillAmount);
        tvTipPercent=findViewById(R.id.tvTipPercent);
        tvTipAmount=findViewById(R.id.tvTipAmount);
        tvBillTotalAmount=findViewById(R.id.tvBillTotalAmount);
        ibExcellentService=findViewById(R.id.ibExcellentService);
        ibGoodService=findViewById(R.id.ibGoodService);
        ibRegularService=findViewById(R.id.ibRegularService);

        setTipValues();
        ibRegularService.setOnClickListener(this);
        ibGoodService.setOnClickListener(this);
        ibExcellentService.setOnClickListener(this);

    // this will chznge tip on real time basis
        etBillAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateFinalBill();
                setTipValues();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    //ignore this function if you have set the tip in xml
    @SuppressLint("StringFormatMatches")
    private void setTipValues() {

        tvTipPercent.setText(getString(R.string.msg_tipPercent, percentage));
        tvTipAmount.setText(getString(R.string.msg_tipTotal, tipTotal));
        tvBillTotalAmount.setText(getString(R.string.msg_bill_total_result, finalBillAmount));
    } 



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibRegularService:
                percentage = REGULAR_TIP_PERCENTAGE;
                break;
            case R.id.ibGoodService:
                percentage = DEFAULT_TIP_PERCENTAGE;
                break;
            case R.id.ibExcellentService:
                percentage = EXCELLENT_TIP_PERCENTAGE;
                break;
        }

        calculateFinalBill();
        setTipValues();
    }



    private void calculateFinalBill() {

        if (percentage == 0)
            percentage = DEFAULT_TIP_PERCENTAGE;

        if(!etBillAmount.getText().toString().equals("") && !etBillAmount.getText().toString().equals("."))
            totalBillAmount = Float.valueOf(etBillAmount.getText().toString());
        else
            totalBillAmount = 0;

        tipTotal = (totalBillAmount*percentage)/100;
        finalBillAmount = totalBillAmount + tipTotal;

    }

}
