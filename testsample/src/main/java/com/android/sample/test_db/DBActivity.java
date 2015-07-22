package com.android.sample.test_db;

import android.view.View;

import com.android.framework.R;
import com.android.libcore.Toast.T;
import com.android.libcore_ui.activity.BaseActivity;
import com.android.libcore_ui.permanentdbcache.PermanentCacheDBHelper;

/**
 * Description: 数据库测试类
 *
 * @author zzp(zhao_zepeng@hotmail.com)
 * @since 2015-07-22
 */
public class DBActivity extends BaseActivity implements View.OnClickListener{
    public Integer key = 0;
    public Integer value = 0;

    @Override
    protected void initView() {
        setContentViewSrc(R.layout.activity_test_db);
        findViewById(R.id.btn_test_add).setOnClickListener(this);
        findViewById(R.id.btn_test_delete).setOnClickListener(this);
        findViewById(R.id.btn_test_query).setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test_add:
                key++;
                value++;
                PermanentCacheDBHelper.getInstance().set(key+" key", value+" value");
                break;
            case R.id.btn_test_delete:
                PermanentCacheDBHelper.getInstance().del(key+" key");
                break;
            case R.id.btn_test_query:
                T.getInstance().showShort(PermanentCacheDBHelper.getInstance().get(key + " key"));
                break;
        }
    }
}