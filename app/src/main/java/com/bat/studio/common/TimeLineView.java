package com.bat.studio.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.bat.studio.R;
import com.bat.studio.utils.DeviceUtils;


public class TimeLineView extends LinearLayout {
    private ImageView top;
    private ImageView icon;
    private ImageView bottom;

    public TimeLineView(Context context) {
        this(context, null);
    }

    public TimeLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TimeLineView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.layout_time_line, this, true);
        top = findViewById(R.id.time_line_top);
        icon = findViewById(R.id.time_line_icon);
        bottom = findViewById(R.id.time_line_bottom);
    }

    public TimeLineView setLineWidth(int width) {
        LayoutParams params_top = (LayoutParams) top.getLayoutParams();
        params_top.width = DeviceUtils.dp2px(width);
        top.setLayoutParams(params_top);

        LayoutParams params_bottom = (LayoutParams) bottom.getLayoutParams();
        params_bottom.width = DeviceUtils.dp2px(width);
        bottom.setLayoutParams(params_bottom);
        return this;
    }

    public TimeLineView setIconSize(int iconSize) {
        LayoutParams params_icon = (LayoutParams) icon.getLayoutParams();
        params_icon.width = DeviceUtils.dp2px(iconSize);
        icon.setLayoutParams(params_icon);
        return this;
    }

    public TimeLineView setIcon(@DrawableRes int iconRes) {
        icon.setImageResource(iconRes);
        return this;
    }

  /*
  暂不支持该功能
   public TimeLineView setIconTint(@ColorRes int color) {
        icon.setColorFilter(color);
        return this;
    }*/

    public TimeLineView hideTop() {
        top.setVisibility(GONE);
        return this;
    }

    public TimeLineView hideBottom() {
        bottom.setVisibility(GONE);
        return this;
    }
}
