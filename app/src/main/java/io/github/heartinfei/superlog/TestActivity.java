package io.github.heartinfei.superlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.github.heartinfei.slogger.Configuration;
import io.github.heartinfei.slogger.S;
/**
 * Demo
 * @author 王强 on 2017/12/22 249346528@qq.com
 */
public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Configuration c = new Configuration.Builder(this)
                .isPrintTrackInfo(true)
                .trackInfoDeep(10)
                .tag("Sugar")
                .build();
        S.addConfig(c);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_print:
                //使用当前Activity默认Tag
                nest();
                break;
            case R.id.btn_thread:
                new Thread(() -> S.i("Print message in background thread.")).start();
                break;
            case R.id.btn_tag:
                //使用自定义Tag
                S.log("My_Tag", "Customer test");
                break;
        }
    }

    private void nest() {
        method();
    }

    private void method() {
        test();
    }

    int j = 0;

    private void test() {
        for (; j % 10 < 9; j++) {
            S.i("测试" + j);
        }
        j++;
    }
}
