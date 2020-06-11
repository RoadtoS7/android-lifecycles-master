package com.example.android.lifecycles.practice;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import android.widget.Chronometer;

import com.example.android.codelabs.lifecycle.R;
import com.example.android.lifecycles.step2.ChronometerViewModel;

public class PracticeChronoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_chrono);

        PracticeViewModel practiceViewModel = new ViewModelProvider(this).get(PracticeViewModel.class);

        Chronometer chronometer = findViewById(R.id.chronometer);

        if(practiceViewModel.getmStartTime() == null){
            long startTime = SystemClock.elapsedRealtime();
            practiceViewModel.setmStartTime(startTime);
            chronometer.setBase(startTime);
        }
        else{
            chronometer.setBase(practiceViewModel.getmStartTime());
        }
        chronometer.start();
    }
}