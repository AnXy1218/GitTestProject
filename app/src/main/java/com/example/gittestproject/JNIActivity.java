package com.example.gittestproject;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.utils.JNIUtils;

/**
 * jni注意我没有使用v7包提供的属性和类,因为会出现各种问题
 * 参考资料：http://www.cnblogs.com/xitang/p/4174619.html
 */
public class JNIActivity extends AppCompatActivity {

    private TextView tvHelloWorld,tvResult,tvInfoFromJNI;
    private EditText edNum1,edNum2;
    private Button btnAdd;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tvHelloWorld = (TextView) findViewById(R.id.tv_helloworld_jni);
        tvResult = (TextView) findViewById(R.id.tv_result_jni);
        tvResult = (TextView) findViewById(R.id.tv_printFromJNI_jni);
        edNum1 = (EditText) findViewById(R.id.ed_num1_jni);
        edNum2 = (EditText) findViewById(R.id.ed_num2_jni);
        btnAdd = (Button)findViewById(R.id.btn_add_jni);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHelloWorld.setText(JNIUtils.helloJni());
                int a = Integer.parseInt(edNum1.getEditableText().toString());
                int b = Integer.parseInt(edNum2.getEditableText().toString());
                tvResult.setText(JNIUtils.addCal(a,b)+"");
                JNIUtils.callJNI("jni");
            }
        });

        videoView = (VideoView) findViewById(R.id.videoview_jni);
        videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        videoView.start();
    }

}
