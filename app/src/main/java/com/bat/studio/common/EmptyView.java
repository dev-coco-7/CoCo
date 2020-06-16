package com.bat.studio.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.bat.studio.R;

public class EmptyView extends LinearLayout {
    private ImageView icon;
    private TextView text;
    private LinearLayout empty_layout;

    public EmptyView(Context context) {
        this(context, null);
    }

    public EmptyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmptyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public EmptyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.layout_empty_view, this, true);
        icon = findViewById(R.id.empty_icon);
        text = findViewById(R.id.empty_text);
        empty_layout = findViewById(R.id.empty_layout);
    }

    public void setIcon(@DrawableRes int iconRes) {
        icon.setImageResource(iconRes);
    }

    public void setText(String textRes) {
        text.setText(textRes);
    }

    public void show() {
        empty_layout.setVisibility(VISIBLE);
    }

    public void hide() {
        empty_layout.setVisibility(GONE);
    }
}
