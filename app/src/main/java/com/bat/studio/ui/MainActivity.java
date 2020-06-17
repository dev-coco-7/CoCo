package com.bat.studio.ui;

import android.view.View;

import com.bat.studio.R;
import com.bat.studio.base.BaseActivity;
import com.bat.studio.common.CenterDialog;


public class MainActivity extends BaseActivity {

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        CenterDialog dialog = new CenterDialog(this);
        dialog.builder().setTitle("ces").setBody("jsdskdasofhasufsufuasf" +
                "kfasofhiaosfhdgf]hte-hie0ihetmbnephjerjhorhniprh" +
                "pfgijiagqhew0hgbjwbnmw]rpgwweruaufuos")
                .setLeftButton("去洗", null)
                .setRightButton("true", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("hehehehhe");
                    }
                }).setCancelable(false).show();
    }

    @Override
    protected void initData() {

    }

}
