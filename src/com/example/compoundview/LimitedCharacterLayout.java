package com.example.compoundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LimitedCharacterLayout extends LinearLayout {
	EditText input;
	TextView display;
	Context context;
	LinearLayout.LayoutParams inpuTextParams;
	LinearLayout.LayoutParams displayTextParams;
	private final int DEFUALT_CHAR_LIMIT = 200;
	private final int MAX_LINES = 5;
	private final String TAG = getClass().getSimpleName();
	int maxCharLimit;

	public LimitedCharacterLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		// TODO Auto-generated constructor stub
		Log.v(TAG, "Constructor 3");
	}

	public LimitedCharacterLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		// TODO Auto-generated constructor stub
		Log.v(TAG, "Constructor 2");
		createDefaultLayout(attrs);
	}

	public LimitedCharacterLayout(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
		Log.v(TAG, "Constructor 1");
		createDefaultLayout(null);
	}

	private void createDefaultLayout(AttributeSet attrs) {
		input = new EditText(context);
		display = new TextView(context);

		if (attrs == null) {
			// Create Default Layout
			inpuTextParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			displayTextParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);

			input.setLayoutParams(inpuTextParams);
			display.setLayoutParams(displayTextParams);

			input.setGravity(Gravity.LEFT | Gravity.TOP);
			display.setGravity(Gravity.RIGHT);

			input.setLines(MAX_LINES);
			input.setTextColor(Color.BLACK);
			display.setTextColor(Color.BLACK);

			maxCharLimit = DEFUALT_CHAR_LIMIT;
		} else {
			TypedArray a = context.obtainStyledAttributes(attrs,
					R.styleable.LimitedCharacterLayout, 0, 0);

			inpuTextParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			displayTextParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);

			input.setLayoutParams(inpuTextParams);
			display.setLayoutParams(displayTextParams);

			input.setGravity(a.getInt(
					R.styleable.LimitedCharacterLayout_inputTextGravity,
					Gravity.LEFT | Gravity.TOP));
			display.setGravity(a.getInt(
					R.styleable.LimitedCharacterLayout_displayTextGravity,
					Gravity.RIGHT));

			maxCharLimit = a.getInt(
					R.styleable.LimitedCharacterLayout_maxInputLimit,
					DEFUALT_CHAR_LIMIT);

			input.setLines(a
					.getInt(R.styleable.LimitedCharacterLayout_numInputLines,
							MAX_LINES));
			input.setTextColor(a.getColor(
					R.styleable.LimitedCharacterLayout_inputTextcolor,
					R.color.black));
			display.setTextColor(a.getColor(
					R.styleable.LimitedCharacterLayout_displayTextColor,
					R.color.black));

			input.setTypeface(null, a.getInt(
					R.styleable.LimitedCharacterLayout_inputTextStyle,
					Typeface.NORMAL));
			display.setTypeface(null, a.getInt(
					R.styleable.LimitedCharacterLayout_displayTextStyle,
					Typeface.NORMAL));

			input.setBackgroundDrawable(a
					.getDrawable(R.styleable.LimitedCharacterLayout_inputTextBackground));
			display.setBackgroundDrawable(a
					.getDrawable(R.styleable.LimitedCharacterLayout_displayTextBackground));
		}

		input.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				display.setText(maxCharLimit
						- input.getText().toString().length() + " Left");
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

		InputFilter[] FilterArray = new InputFilter[1];
		FilterArray[0] = new InputFilter.LengthFilter(maxCharLimit);
		input.setFilters(FilterArray);
		display.setText(maxCharLimit + " Left");

		addView(input);
		addView(display);
		setOrientation(LinearLayout.VERTICAL);

	}
}
