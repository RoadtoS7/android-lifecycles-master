package com.example.android.lifecycles.practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.android.codelabs.lifecycle.R;
import com.example.android.lifecycles.step5.SeekBarViewModel;

/**
 * A simple {@link Fragment} subclass.
 *
 * create an instance of this fragment.
 */
public class ShareViewModelFragment extends Fragment {
    private SeekBar mSeekBar;
    private ShareViewModel mShareViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share_view_model, container, false);
        mSeekBar = view.findViewById(R.id.seekBar);
        mShareViewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        subscribe();
        return view;
    }



    private void subscribe(){
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mShareViewModel.seekBarValue.setValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mShareViewModel.seekBarValue.observe(
                requireActivity(),
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        mSeekBar.setProgress(integer);
                    }
                }
        );
    }
}