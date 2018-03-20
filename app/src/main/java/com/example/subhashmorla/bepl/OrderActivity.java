package com.example.subhashmorla.bepl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OrderActivity extends AppCompatActivity {
    EditText brick1_quantity;
    EditText brick2_quantity;
    EditText total_price;
    int b1_qty=0;
    int b2_qty=0;
    int price;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        brick1_quantity= findViewById(R.id.brick1_quantity);
        brick2_quantity=findViewById(R.id.brick2_quantity);
        total_price=findViewById(R.id.total_price);
        button=(Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "info@bondada.net", null));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Order");
                intent.putExtra(Intent.EXTRA_TEXT,"    ORDER DETAILS \nFirst quantity  "+b1_qty+"\n   Second quantity   "+b2_qty+"\n   total price  "+price );

                startActivity(Intent.createChooser(intent, "send email...."));


            }
        });


        brick1_quantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(String.valueOf(brick1_quantity.getText()).equals("")){
                    Log.e("if","yyyyyyyyyyyyyyyy");
                    b1_qty=0;
                   calculateprice();
                }
                else {
                    Log.e("else","XXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    b1_qty=Integer.parseInt(String.valueOf(brick1_quantity.getText()));

                    calculateprice();
                }

            }
        });

        brick2_quantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(String.valueOf(brick2_quantity.getText()).equals("")){
                   b2_qty=0;
                   calculateprice();
                }
                else{
                    b2_qty=Integer.parseInt(String.valueOf(brick2_quantity.getText()));
                    calculateprice();
                }

            }
        });



    }

    private void calculateprice() {

        price=b1_qty * 50 + b2_qty * 80;
        total_price.setText(String.valueOf(b1_qty * 50 + b2_qty * 80 ));

    }


}
