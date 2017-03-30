package com.example.ja010.silsemp330;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.ja010.silsemp330.R.id.textView;

/**
 * Created by ja010 on 2017-03-30.
 */

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //container 어디에 붙일지
        View fv = inflater.inflate(R.layout.fragment1,container,false);

        return fv;
    }
}
