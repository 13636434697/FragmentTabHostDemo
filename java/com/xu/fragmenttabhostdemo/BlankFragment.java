package com.xu.fragmenttabhostdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/*
* 给fragment传参数，这里就简单的设置一个textview
*
* */
public class BlankFragment extends Fragment{
	private String text;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//在上面界面传，这里接收就可以了
		Bundle bundle = getArguments();
		//在这里赋值一下
		text = bundle.getString("text");
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		TextView textView = new TextView(getActivity());
		textView.setTextSize(90);
		textView.setTextColor(Color.BLACK);
		//设置文本
		textView.setText(text);
		
		return textView;
	}
}
