package com.bat.studio.common;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bat.studio.R;


public class CenterDialog {
    private Context context;
    private Dialog dialog;
    private TextView dialog_body;
    private TextView dialog_title;
    private Button left_button;
    private Button right_button;
    private Display display;
    private LinearLayout lLayout_bg;

    public CenterDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public CenterDialog builder() {
        View view = LayoutInflater.from(context).inflate(
                R.layout.layout_center_dialog, null);
        dialog_title = view.findViewById(R.id.dialog_title);
        dialog_body = view.findViewById(R.id.dialog_body);
        left_button = view.findViewById(R.id.left_button);
        right_button = view.findViewById(R.id.right_button);
        lLayout_bg = view.findViewById(R.id.lLayout_bg);
        dialog = new Dialog(context,R.style.AlertDialogStyle);
        dialog.setContentView(view);
        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.80), ViewGroup.LayoutParams.WRAP_CONTENT));
        return this;
    }


    public CenterDialog setTitle(String title) {
        dialog_title.setText(title);
        return this;
    }

    public CenterDialog setBody(String body) {
        dialog_body.setText(body);
        return this;
    }


    public CenterDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public CenterDialog setRightButton(String text,
                                       final View.OnClickListener listener) {
        return setPositiveButton(text, -1, listener);
    }

    public CenterDialog setPositiveButton(String text, int color,
                                          final View.OnClickListener listener) {
        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClick(v);
                dismiss();
            }
        });
        return this;
    }

    public CenterDialog setLeftButton(String text,
                                      final View.OnClickListener listener) {

        return setNegativeButton(text, -1, listener);
    }

    public CenterDialog setNegativeButton(String text, int color,
                                          final View.OnClickListener listener) {

        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClick(v);
                dismiss();
            }
        });
        return this;
    }


    public void show() {
        dialog.show();
    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

}

