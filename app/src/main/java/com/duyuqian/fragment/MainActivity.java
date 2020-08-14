package com.duyuqian.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.android_btn)
    Button skipToAndroid;
    @BindView(R.id.java_btn)
    Button skipToJava;
    @BindView(R.id.right_layout)
    FrameLayout rightLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.android_btn)
    public void onClickAndroidBtn() {
        replaceFragment(new RightFragmentOfAndroid());
    }

    @OnClick(R.id.java_btn)
    public void onClickJavaBtn() {
        replaceFragment(new RightFragmentOfJava());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.right_layout, fragment);
        transaction.commit();
    }
}