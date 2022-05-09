package com.example.truthordareassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private int lastdir,currdir;
    private ImageView imageView;
    private Random random=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastdir=0;
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button.setEnabled(false);
                spin();
                //button.setEnabled(true);
            }

        });
    }

    private void spin(){
        currdir=random.nextInt(3600)+360;
        int pivotX= imageView.getWidth()/2;
        int pivotY= imageView.getHeight()/2;
        Animation rotate= new RotateAnimation(lastdir,currdir,pivotX,pivotY);
        rotate.setDuration(3000);
        rotate.setFillAfter(true);
        imageView.startAnimation(rotate);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastdir=currdir;
    }
}
