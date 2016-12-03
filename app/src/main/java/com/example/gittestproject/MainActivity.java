package com.example.gittestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvHelloWorld;
    private Button btnTween,btnJni;//开启补间动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHelloWorld = (TextView) findViewById(R.id.hello_world);
        btnTween = (Button) findViewById(R.id.btn_tween_main);
        btnJni = (Button)findViewById(R.id.btn_jumpjni_main);

        tvHelloWorld.setText("你好，世界！");
        tvHelloWorld.setOnClickListener(clickListener);
        btnTween.setOnClickListener(clickListener);
        btnJni.setOnClickListener(clickListener);
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
            }
        }
    };
}
