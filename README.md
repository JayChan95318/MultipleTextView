# MultipleTextView
支持定义前后缀文字和文字颜色的TextView 

 MultipleTextView是一个支持定义前后缀文字和文字颜色的TextView,效果图如下：

   ![](http://i.imgur.com/SV4zWGv.jpg)

   其中，数字200的左边文字是MultipleTextView的前缀,右边文字是PowerfulTextView的后缀,一般前缀后缀都是写死的,你可以在xml里面定义前缀和后缀,也可以在代码中修改前缀后缀


### 使用

   在布局文件中，PowerfulTextView，代码如下：

     <com.jaychan.view.MultipleTextView
        android:id="@+id/multiple_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        app:prefixText="您消费了 : "
        app:prefixTextColor="#424242"
        app:contentText="200"
        app:contentTextColor="#ff0000"
        app:suffixText=" 元"
        app:suffixTextColor="#424242"/>

   其中 
	
	prefixText:	前缀文字
	prefixTextColor: 前缀文字颜色(若没有设置,默认和内容的颜色一样)
	contentText： 内容文字
    contentTextColor: 内容文字颜色
	suffixText： 后缀文字
	suffixTextColor： 后缀文字颜色(若没有设置,默认和内容的颜色一样)

   在代码中

    MultipleTextView multipleTextView = (MultipleTextView) findViewById(R.id.multiple_text_view);

    multipleTextView.setPrefixText("您消费了: "); //设置前缀文字
    multipleTextView.setPrefixTextColor(Color.parseColor("#424242")); //设置前缀文字颜色
    multipleTextView.setContentText("200");   //设置内容文字
    multipleTextView.setContentTextColor(Color.parseColor("#ff0000"));   //设置内容文字颜色
    multipleTextView.setSuffixText(" 元");  //设置后缀文字
    multipleTextView.setSuffixTextColor(Color.parseColor("#424242")); //设置后缀文字颜色
