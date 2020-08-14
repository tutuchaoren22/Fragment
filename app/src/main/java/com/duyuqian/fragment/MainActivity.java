package com.duyuqian.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.android_btn, R.id.java_btn})
    public void onClick(Button button) {
        switch (button.getId()) {
            case R.id.android_btn:
                replaceFragment(new RightFragmentOfAndroid());
                break;
            case R.id.java_btn:
                replaceFragment(new RightFragmentOfJava());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.right_layout, fragment);
        transaction.commit();
    }
}