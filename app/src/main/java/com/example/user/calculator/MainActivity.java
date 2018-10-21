package com.example.user.calculator;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;

    //Understand the basics of methods, as well as Method Inheritance via @Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //method Overriding
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        DisplayFragment displayFragment = DisplayFragment.newInstance();
        InputFragment inputFragment = InputFragment.newInstance();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.cont_fragment_display, displayFragment);
        transaction.add(R.id.cont_fragment_input, inputFragment);
        transaction.commit();

        Presenter presenter = new Presenter(displayFragment);
        displayFragment.setPresenter(presenter);
        inputFragment.setPresenter(presenter);
    }
}
