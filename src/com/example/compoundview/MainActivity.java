package com.example.compoundview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView test;

	String textPrefix = "Hello";
	String separator = " : ";
	String text = "Hardik";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(new LimitedCharacterLayout(this));
		setContentView(R.layout.activity_main);

		/*
		 * test = (TextView) findViewById(R.id.test); String stringToset =
		 * textPrefix + separator + text;
		 * 
		 * SpannableString spanString = new SpannableString(stringToset);
		 * 
		 * spanString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0,
		 * textPrefix.length(), 0);
		 * 
		 * spanString.setSpan(new ForegroundColorSpan(Color.RED), 0,
		 * textPrefix.length() + separator.length(), 0); spanString.setSpan(new
		 * ForegroundColorSpan(Color.BLUE), textPrefix.length() +
		 * separator.length(), stringToset.length(), 0);
		 * 
		 * spanString.setSpan(new ForegroundColorSpan(R.color.btn_light_gray),
		 * textPrefix.length() + separator.length(), stringToset.length(),
		 * Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		 * 
		 * test.setText(spanString);
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
