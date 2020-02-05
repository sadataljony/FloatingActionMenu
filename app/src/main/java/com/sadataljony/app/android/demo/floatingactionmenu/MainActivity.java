package com.sadataljony.app.android.demo.floatingactionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton mFabMain, mFabOption01, mFabOption02, mFabOption03;
    private TextView mTextViewOption01, mTextViewOption02, mTextViewOption03;
    private Animation mAnimFabOpen, mAnimFabClose, mAnimFabRotateClockWise, mAnimFabRotateAntiClockWise;
    private Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();// initialize ui
    }

    private void initUi() {
        mFabMain = findViewById(R.id.fabMain);
        mFabOption01 = findViewById(R.id.fabOption01);
        mFabOption02 = findViewById(R.id.fabOption02);
        mFabOption03 = findViewById(R.id.fabOption03);

        mFabMain.setOnClickListener(this);// implement OnClick Event
        mFabOption01.setOnClickListener(this);
        mFabOption02.setOnClickListener(this);
        mFabOption03.setOnClickListener(this);

        mTextViewOption01 = findViewById(R.id.textViewOption01);
        mTextViewOption02 = findViewById(R.id.textViewOption02);
        mTextViewOption03 = findViewById(R.id.textViewOption03);

        mAnimFabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);// Animation
        mAnimFabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        mAnimFabRotateClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock_wise);
        mAnimFabRotateAntiClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anti_clock_wise);
    }

    @Override
    public void onClick(View v) {

        if (v == mFabMain) {

            if (isOpen) {
                mTextViewOption01.setVisibility(View.INVISIBLE);
                mTextViewOption02.setVisibility(View.INVISIBLE);
                mTextViewOption03.setVisibility(View.INVISIBLE);

                mFabOption03.startAnimation(mAnimFabClose);
                mFabOption02.startAnimation(mAnimFabClose);
                mFabOption01.startAnimation(mAnimFabClose);
                mFabMain.startAnimation(mAnimFabRotateAntiClockWise);

                mFabOption03.setClickable(false);
                mFabOption02.setClickable(false);
                mFabOption01.setClickable(false);

                isOpen = false;
            } else {
                mTextViewOption03.setVisibility(View.VISIBLE);
                mTextViewOption02.setVisibility(View.VISIBLE);
                mTextViewOption01.setVisibility(View.VISIBLE);

                mFabOption03.startAnimation(mAnimFabOpen);
                mFabOption02.startAnimation(mAnimFabOpen);
                mFabOption01.startAnimation(mAnimFabOpen);
                mFabMain.startAnimation(mAnimFabRotateClockWise);

                mFabOption03.setClickable(true);
                mFabOption02.setClickable(true);
                mFabOption01.setClickable(true);

                isOpen = true;
            }

        }

        if (v == mFabOption01) {
            Toast.makeText(getApplicationContext(), "Option 01 Selected", Toast.LENGTH_SHORT).show();
        }

        if (v == mFabOption02) {
            Toast.makeText(getApplicationContext(), "Option 02 Selected", Toast.LENGTH_SHORT).show();
        }

        if (v == mFabOption03) {
            Toast.makeText(getApplicationContext(), "Option 03 Selected", Toast.LENGTH_SHORT).show();
        }

    }
}
