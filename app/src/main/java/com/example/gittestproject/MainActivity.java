package com.example.gittestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.ActivitRetrofit;

public class MainActivity extends AppCompatActivity {
    private TextView tvHelloWorld;
    private Button btnTween,btnJni,btnRetrofit,btnRecyclerview;//开启补间动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHelloWorld = (TextView) findViewById(R.id.hello_world);
        btnTween = (Button) findViewById(R.id.btn_tween_main);
        btnJni = (Button)findViewById(R.id.btn_jumpjni_main);
        btnRetrofit = (Button)findViewById(R.id.btn_jumpRetrofit_main);
        btnRecyclerview = (Button)findViewById(R.id.btn_jumpRecyclerview_main);

        tvHelloWorld.setText("你好，世界！");
        tvHelloWorld.setOnClickListener(clickListener);
        btnTween.setOnClickListener(clickListener);
        btnJni.setOnClickListener(clickListener);
        btnRetrofit.setOnClickListener(clickListener);
        btnRecyclerview.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.hello_world:
                    Toast.makeText(MainActivity.this, "点击了Hello World！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_tween_main:
                    //开启补间动画
                    Intent intent = new Intent(MainActivity.this,AnimationActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_jumpjni_main:
                    Intent jniIntent = new Intent(MainActivity.this,JNIActivity.class);
                    startActivity(jniIntent);
                    break;
                case R.id.btn_jumpRetrofit_main:
                    Intent retrofitIntent = new Intent(MainActivity.this,ActivitRetrofit.class);
                    startActivity(retrofitIntent);
                    break;
                case R.id.btn_jumpRecyclerview_main:
                    Intent recyclerviewIntent = new Intent(MainActivity.this,RecyclerviewActivity.class);
                    startActivity(recyclerviewIntent);
                    break;
            }
        }
    };
}
