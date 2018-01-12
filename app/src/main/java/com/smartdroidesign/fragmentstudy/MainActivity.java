package com.smartdroidesign.fragmentstudy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.fragmentBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(!status){

                    FragmentOne frag1 = new FragmentOne();
                    fragmentTransaction.add(R.id.fragment_container, frag1);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    btn.setText("LOAD SECOND FRAGMENT");
                    status = true;
                } else {

                    FragmentTwo frag2 = new FragmentTwo();
                    fragmentTransaction.add(R.id.fragment_container,frag2);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    btn.setText("LOAD FIRST FRAGMENT");
                    status = false;
                }

            }
        });


    }
}
