package com.example.muhammadfaiq.layouts2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Adapters.SlideAdapter;
import com.example.muhammadfaiq.layouts2.R;
/**
 * Created by Muhammad Faiq on 10/27/2018.
 */

public class FragmentHome extends Fragment {
    View view;


    public FragmentHome()
    {

    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.home_fragment, container, false);

        return view;
    }
}