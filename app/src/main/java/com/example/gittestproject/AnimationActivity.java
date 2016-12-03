package com.example.gittestproject;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 补间动画的演示Activity
 * 留一个问题，待日后解决：1.动画移动过程中，添加点击事件的时候，还是在控件的原位置起作用，怎么实现点击动画就能响应的点击事件呢？
 *                         2.帧动画播放然后停止，在继续播放，播放速度会加快。还有就是播放完了，停到第一张，或者最后一张。
 */
public class AnimationActivity extends AppCompatActivity {
    private ImageView ivTweenAnimation,ivFrameAnim;//显示动画图片
    private TextView tvAlpha,tvScale,tvTranslate,tvRotate;//控制动画的按钮
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        ivTweenAnimation = (ImageView) findViewById(R.id.iv_animation);
        ivFrameAnim = (ImageView) findViewById(R.id.iv_frameAnim);
        tvAlpha = (TextView) findViewById(R.id.tv_animation_tween_alpha);
        tvScale = (TextView) findViewById(R.id.tv_animation_tween_scale);
        tvTranslate = (TextView) findViewById(R.id.tv_animation_tween_translate);
        tvRotate = (TextView) findViewById(R.id.tv_animation_tween_rotate);

        ivTweenAnimation.setOnClickListener(clickListener);
        ivFrameAnim.setOnClickListener(clickListener);
        tvAlpha.setOnClickListener(clickListener);
        tvScale.setOnClickListener(clickListener);
        tvTranslate.setOnClickListener(clickListener);
        tvRotate.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_animation_tween_alpha:
                    //透明度
                    AlphaAnimation alphaAnim = new AlphaAnimation(0.0f,1.0f);
                    alphaAnim.setDuration(10*1000);
                    alphaAnim.setFillAfter(true);
                    ivTweenAnimation.startAnimation(alphaAnim);
                    break;
                case R.id.tv_animation_tween_scale:
                    //缩放
                    ScaleAnimation scaleAnim = new ScaleAnimation(0,0.5f,0,0.5f);
                    scaleAnim.setDuration(10*1000);
                    scaleAnim.setFillAfter(true);
                    ivTweenAnimation.startAnimation(scaleAnim);
                    break;
                case R.id.tv_animation_tween_translate:
                    //移动
                    TranslateAnimation translateAnim = new TranslateAnimation(ivTweenAnimation.getWidth(),0,ivTweenAnimation.getHeight(),0);
                    translateAnim.setDuration(10*1000);
                    translateAnim.setFillAfter(true);
                    ivTweenAnimation.startAnimation(translateAnim);
                    break;
                case R.id.tv_animation_tween_rotate:
                    //旋转
//                    RotateAnimation rotateAnim = new RotateAnimation(0,360,ivTweenAnimation.getWidth()/2,ivTweenAnimation.getHeight()/2);
//                    rotateAnim.setDuration(10*1000);
//                    rotateAnim.setFillAfter(true);
//                    rotateAnim.setRepeatCount(10);
//                    ivTweenAnimation.startAnimation(rotateAnim);

                    //以下代码是我想验证：当TextView处于跑马灯效果时，执行动画它是否受影响，结果是没有影响。
                    RotateAnimation rotateAnim = new RotateAnimation(0,360,tvRotate.getWidth()/2,tvRotate.getHeight()/2);
                    rotateAnim.setDuration(10*1000);
                    rotateAnim.setFillAfter(true);
                    rotateAnim.setRepeatCount(10);
                    tvRotate .startAnimation(rotateAnim);
                    break;
                case R.id.iv_animation:
                    Toast.makeText(AnimationActivity.this,"我就是你要找的ImageView",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.iv_frameAnim:
                    //开启帧动画
                    if(animationDrawable == null){
                        animationDrawable = (AnimationDrawable) ivFrameAnim.getDrawable();
                        animationDrawable.start();
                    }else{
                        if(animationDrawable.isRunning()){
                            animationDrawable.stop();
                        }else{
                            animationDrawable.run();
                        }
                    }
                    break;
            }
        }
    };
}