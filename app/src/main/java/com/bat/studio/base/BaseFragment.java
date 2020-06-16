package com.bat.studio.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bat.studio.common.EmptyView;
import com.bat.studio.common.LoadingView;

public abstract class BaseFragment extends Fragment {
    public Context context;
    private Long firstClickTime = 0L;
    public static LoadingView loadingView;
    public static EmptyView emptyView;

    public BaseFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadingView = new LoadingView(context);
        emptyView = new EmptyView(context);
        initWidget();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected <T extends View> T findViewById(int resId) {
        return (T) getView().findViewById(resId);
    }

    //防止多次点击
    public boolean fastClick(long interval) {
        if (System.currentTimeMillis() - firstClickTime <= interval) {
            Toast.makeText(context, "点击太快了", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            firstClickTime = System.currentTimeMillis();
            return false;
        }
    }

    @LayoutRes
    public abstract int initLayout();

    public abstract void initWidget();

    public abstract void initData();
}
