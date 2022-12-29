package com.example.dragdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.behavior.SwipeDismissBehavior;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView show = findViewById(R.id.show);

        ll = findViewById(R.id.ll);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                showView(count % 2 == 1);
            }
        });
    }

    private void showView(boolean show) {
        ConstraintLayout parent = findViewById(R.id.parent);
        Transition transition = new Slide(Gravity.BOTTOM);
        transition.setDuration(200);
        transition.addTarget(ll);
        TransitionManager.beginDelayedTransition(parent, transition);
        ll.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}