package com.example.android.lifecycles.practice;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

class PracticeViewModel extends ViewModel {
    @Nullable
    private Long mStartTime;

    @Nullable
    public Long getmStartTime(){
        return mStartTime;
    }

    public void setmStartTime(final Long startTime){
        mStartTime = startTime;
    }
}
