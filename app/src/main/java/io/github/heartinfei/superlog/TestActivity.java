package io.github.heartinfei.superlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.github.heartinfei.slogger.Configuration;
import io.github.heartinfei.slogger.S;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Configuration c = new Configuration.Builder(this)
                .isPrintTrackInfo(true)
                .trackInfoDeep(10)
                .tag("Fucking")
                .build();
        S.addConfig(c);

    }

    @Override
    public void onClick(View v) {
        hehh();
    }

    private void hehh() {
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
