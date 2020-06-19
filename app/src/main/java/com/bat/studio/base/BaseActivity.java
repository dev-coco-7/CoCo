package com.bat.studio.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bat.studio.R;
import com.bat.studio.common.EmptyView;
import com.bat.studio.common.LoadingView;
import com.bat.studio.http.ApiStore;
import com.bat.studio.http.RetrofitX;
import com.bat.studio.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public static List<BaseActivity> activities;
    private long firstClickTime = 0L;
    public static LoadingView loadingView;
    public static EmptyView emptyView;
    public static ApiStore apiStore;
    private Toolbar toolbar;
    private ImageView toolbar_icon;
    private TextView toolbar_text;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏6.0以上
        StatusBarUtils.activityStatusBar(this);
        setContentView(initLayout());
        loadingView = new LoadingView(this);
        emptyView = new EmptyView(this);
        apiStore=RetrofitX.getInstance().getRetrofit().create(ApiStore.class);
        toolbar = findViewById(R.id.toolbar);
        toolbar_icon = findViewById(R.id.toolbar_icon);
        toolbar_icon.setOnClickListener(this);
        toolbar_text = findViewById(R.id.toolbar_text);
        initWidget();
        initData();
    }

    //设置布局
    @LayoutRes
    protected abstract int initLayout();

    //初始化控件
    protected abstract void initWidget();

    //加载数据
    protected abstract void initData();

    // TODO: 仿微信支付宝优化为中部弹窗提示
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    //显示toolbar
    public void showToolbar() {
        toolbar.setVisibility(View.VISIBLE);
    }

    //隐藏toolbar
    public void hideToolbar() {
        toolbar.setVisibility(View.GONE);
    }

    public void setToolbarText(String textRes) {
        toolbar_text.setText(textRes);
    }

    //防止多次点击
    public boolean fastClick(long interval) {
        if (System.currentTimeMillis() - firstClickTime <= interval) {
            Toast.makeText(this, "点击太快了", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            firstClickTime = System.currentTimeMillis();
            return false;
        }

    }

    //普通跳转Activity
    public void gotoActivity(Context context, Class clazz, boolean needfinish) {
        Intent intent = new Intent(context, clazz);
        startActivity(intent);
        //是否关闭移除并且当前界面
        if (needfinish) {
            removeActivity(this);
            finish();
        }
    }


    //接收回参的跳转
    public void gotoActivityWithExtra(Context context, Class clazz, String bundleName, Bundle bundle, int code) {
        Intent intent = new Intent(context, clazz);
        intent.putExtra(bundleName, bundle);
        startActivityForResult(intent, code);
    }

    //带结果的跳转
    public void gotoActivityWithResult(Context context, Class clazz, String bundleName, Bundle bundle, int code) {
        Intent intent = new Intent(context, clazz);
        intent.putExtra(bundleName, bundle);
        setResult(code, intent);
        removeActivity(this);
        finish();
    }

    //添加Activity
    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new ArrayList<>();
        }
        activities.add((BaseActivity) activity);
    }

    //移除Activity
    public void removeActivity(Activity activity) {
        if (activities != null)
            activities.remove(activity);
    }

    //关闭所有Activity
    public void finishAllActivity() {
        try {
            for (BaseActivity activity : activities) {
                if (activity != null) {
                    activity.finish();
                }
            }
            // 退出进程
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            this.finish();
        }
    }

    //双击退出
    public void doubleClick(int interval) {
        if (System.currentTimeMillis() - firstClickTime > interval) {
            Toast.makeText(this, "再次点击退出程序", Toast.LENGTH_SHORT).show();
            firstClickTime = System.currentTimeMillis();
        } else {
            finishAllActivity();
        }
    }


    //点击软键盘外的空白处，隐藏软件盘
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.getCurrentFocus() != null) {
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            assert mInputMethodManager != null;
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_icon:
                removeActivity(this);
                finish();
                break;
        }
    }
}
