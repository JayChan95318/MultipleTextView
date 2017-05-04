package com.jaychan.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author JayChan
 * @description: 支持定义前后缀文字和文字颜色的TextView
 * @date 2017/5/4  9:57
 */
public class MultipleTextView extends TextView {

    private String prefixText;
    private String contentText;
    private String suffixText;

    private int prefixTextColor;
    private int contentTextColor;
    private int suffixTextColor;

    private SpannableStringBuilder builder;
    private ForegroundColorSpan colorSpan;

    public MultipleTextView(Context context) {
        this(context, null);
    }

    public MultipleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public MultipleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MultipleTextView);

        prefixText = ta.getString(R.styleable.MultipleTextView_prefixText);  //前缀文字
        contentText = ta.getString(R.styleable.MultipleTextView_contentText);    //内容文字
        suffixText = ta.getString(R.styleable.MultipleTextView_suffixText);  //后缀

        prefixTextColor = ta.getColor(R.styleable.MultipleTextView_prefixTextColor, getCurrentTextColor());  //前缀文字颜色,默认值为内容文字的颜色
        contentTextColor = ta.getColor(R.styleable.MultipleTextView_contentTextColor, getCurrentTextColor());  //内容文字颜色默认值为TextView默认的颜色
        suffixTextColor = ta.getColor(R.styleable.MultipleTextView_suffixTextColor, getCurrentTextColor()); //默认值为内容文字的颜色,默认值为内容文字的颜色

        ta.recycle();


        updateUI();
    }

    private void updateUI() {

        if (builder == null) {
            builder = new SpannableStringBuilder();
        }


        if (!TextUtils.isEmpty(prefixText)) {  //前缀不为空
            SpannableString prefixSpannableString = new SpannableString(prefixText);

            //设置前缀文字颜色
            colorSpan = new ForegroundColorSpan(prefixTextColor);
            prefixSpannableString.setSpan(colorSpan, 0, prefixText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            //添加到builder
            builder.append(prefixSpannableString);
        }


        if (!TextUtils.isEmpty(contentText)) {   //内容文字不为空
            SpannableString contentSpannableString = new SpannableString(contentText);

            //设置内容文字颜色
            colorSpan = new ForegroundColorSpan(contentTextColor);
            contentSpannableString.setSpan(colorSpan, 0, contentText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            //添加到builder
            builder.append(contentSpannableString);
        }

        if (!TextUtils.isEmpty(suffixText)) {  //后缀不为空
            SpannableString suffixSpannableString = new SpannableString(suffixText);

            //设置后缀文字颜色
            colorSpan = new ForegroundColorSpan(suffixTextColor);
            suffixSpannableString.setSpan(colorSpan, 0, suffixText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            //添加到builder
            builder.append(suffixSpannableString);
        }

        setText(builder);
        builder.clear();
    }

    public void setPrefixText(String text) {
        prefixText = text;
        updateUI();
    }

    public void setPrefixTextColor(int color) {
        prefixTextColor = color;
        updateUI();
    }

    public void setSuffixText(String text) {
        suffixText = text;
        updateUI();
    }

    public void setSuffixTextColor(int color) {
        suffixTextColor = color;
        updateUI();
    }

    public void setContentText(String text) {
        contentText = text;
        updateUI();
    }

    public void setContentTextColor(int color) {
        contentTextColor = color;
        updateUI();
    }

}
