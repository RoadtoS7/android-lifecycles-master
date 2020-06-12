package com.example.android.lifecycles.practice;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

class ShareViewModel extends ViewModel {
    public MutableLiveData<Integer> seekBarValue = new MutableLiveData<>();
}
