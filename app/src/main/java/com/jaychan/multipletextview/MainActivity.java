package com.jaychan.multipletextview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jaychan.view.MultipleTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MultipleTextView multipleTextView = (MultipleTextView) findViewById(R.id.multiple_text_view);

        multipleTextView.setPrefixText("您消费了: "); //设置前缀文字
        multipleTextView.setPrefixTextColor(Color.parseColor("#424242")); //设置前缀文字颜色
        multipleTextView.setContentText("200");   //设置内容文字
        multipleTextView.setContentTextColor(Color.parseColor("#ff0000"));   //设置内容文字颜色
        multipleTextView.setSuffixText(" 元");  //设置后缀文字
        multipleTextView.setSuffixTextColor(Color.parseColor("#424242")); //设置后缀文字颜色
    }
}
