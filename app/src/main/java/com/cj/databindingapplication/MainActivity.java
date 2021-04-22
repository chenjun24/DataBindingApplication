package com.cj.databindingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cj.databindingapplication.databinding.ActivityMainBinding;
import com.cj.databindingapplication.model.EventListener;
import com.cj.databindingapplication.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("chen","jun");
        viewDataBinding.setUser(user);
        viewDataBinding.setListener(new EventListener());
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setFirstName(user.firstName+i);
                }
            }
        }).start();

    }
}