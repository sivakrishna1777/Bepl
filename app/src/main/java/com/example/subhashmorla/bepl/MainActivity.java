package com.example.subhashmorla.bepl;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity   {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()== null){
            finish();
            startActivity(new Intent(getApplicationContext(),login2Activity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        ViewPager viewPager=findViewById(R.id.viewpager);

        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout=findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId())
        {
            case R.id.nav_account:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                return true;
            case R.id.nav_logout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, login2Activity.class));
                return true;
            case R.id.nav_settings:
                startActivity(new Intent(this, contact.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
