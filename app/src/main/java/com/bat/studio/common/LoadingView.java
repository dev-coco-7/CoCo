package com.bat.studio.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.bat.studio.R;
import com.bat.studio.utils.DeviceUtils;
import com.bat.studio.utils.FilletViewUtils;

public class LoadingView extends AlertDialog {
   private TextView loading_text;
   private ProgressBar loadingDialog;

    public LoadingView(@NonNull Context context) {
        super(context);
    }

    protected LoadingView(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingView(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    public void setLoadingText(String loadingText){
        if (loading_text!=null){
            loading_text.setText(loadingText);
        }
    }

    @Override
    public void show() {
        super.show();
        setContentView(R.layout.layout_loading_view);
        loading_text = findViewById(R.id.loading_text);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.WRAP_CONTENT;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        attributes.gravity = Gravity.CENTER;
        attributes.dimAmount = 0.5f;
        //这个背景必须设置哦，否则 会出现对话框 宽度很宽
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //给转菊花的loading对话框来一个圆角
        FilletViewUtils.setViewOutline(findViewById(R.id.loading_layout), DeviceUtils.dp2px(10), FilletViewUtils.RADIUS_ALL);
        window.setAttributes(attributes);
    }

}
