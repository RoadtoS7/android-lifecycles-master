package com.example.android.lifecycles.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.TextView;

import com.example.android.codelabs.lifecycle.R;

public class LiveDataActivity extends AppCompatActivity {

    private LiveDataViewModel mLiveDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_live_data);


        subscribe();
    }

    private void subscribe(){
        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                String newText = LiveDataActivity.this.getResources().getString(
                        R.string.seconds, aLong
                );
                ((TextView)findViewById(R.id.timer_textview)).setText(newText);
            }
        };

        mLiveDataViewModel.getmElapsedTime().observe(this, observer);
    }
}