package com.example.subhashmorla.bepl;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextView call = (TextView) findViewById(R.id.call);
        TextView mail = (TextView) findViewById(R.id.mail);
        TextView web = (TextView) findViewById(R.id.web);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_DIAL);
                callintent.setData(Uri.parse("tel:+91 4065534662"));
                startActivity(callintent);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "info@bondada.net", null));
                startActivity(Intent.createChooser(intent, "send email...."));
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.beplsmartbrix.com/index.html"));
                startActivity(callintent);
            }
        });
    }
}
