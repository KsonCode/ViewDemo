package com.bwie.viewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.viewdemo.widget.AddMinusView;

public class MainActivity extends AppCompatActivity {
    private AddMinusView addMinusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addMinusView = findViewById(R.id.addview);

        addMinusView.setNumOnclick(new AddMinusView.NumOnclick() {
            @Override
            public void addOnclick(View view) {
                Toast.makeText(MainActivity.this, addMinusView.getNumViewValue(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void minusOnclick(View view) {
                Toast.makeText(MainActivity.this, addMinusView.getNumViewValue(), Toast.LENGTH_SHORT).show();


            }
        });

    }


}
