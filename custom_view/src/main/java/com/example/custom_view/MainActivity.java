package com.example.custom_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.custom_view.temp_control_view.activity.TempControlViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTempControlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        tvTempControlView = findViewById(R.id.tvTempControlView);
    }

    private void initListener() {
        tvTempControlView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvTempControlView:
                jumpToPage(TempControlViewActivity.class);
                break;
        }
    }

    public void jumpToPage(Class targetPage) {
        Intent intent = new Intent(this, targetPage);
        startActivity(intent);
    }
}