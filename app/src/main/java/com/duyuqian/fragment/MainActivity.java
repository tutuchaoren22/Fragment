package com.duyuqian.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private RightFragmentOfAndroid fragmentOfAndroid = new RightFragmentOfAndroid();
    private RightFragmentOfJava fragmentOfJava = new RightFragmentOfJava();
    private FragmentManager fragmentManager = getSupportFragmentManager();
    @BindView(R.id.android_btn)
    Button androidButton;
    @BindView(R.id.java_btn)
    Button javaButton;
    @BindDrawable(R.drawable.button_rounded_corners_checked)
    Drawable checkedBackground;
    @BindDrawable(R.drawable.button_rounded_corners_nochecked)
    Drawable noCheckedBackground;


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
                hasCheckedAndroid(true);
                replaceFragment(fragmentOfJava, fragmentOfAndroid);
                break;
            case R.id.java_btn:
                hasCheckedAndroid(false);
                replaceFragment(fragmentOfAndroid, fragmentOfJava);
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fromFragment, Fragment toFragment) {
        FragmentTransaction transaction;
        if (toFragment.isAdded()) {
            transaction = fragmentManager.beginTransaction();
            transaction.hide(fromFragment).show(toFragment).commit();
        } else {
            transaction = fragmentManager.beginTransaction();
            transaction.hide(fromFragment).add(R.id.right_layout, toFragment).show(toFragment).commit();
        }
    }

    private void hasCheckedAndroid(Boolean hasChecked) {
        if (hasChecked) {
            androidButton.setBackground(checkedBackground);
            javaButton.setBackground(noCheckedBackground);
        } else {
            androidButton.setBackground(noCheckedBackground);
            javaButton.setBackground(checkedBackground);
        }
    }
}