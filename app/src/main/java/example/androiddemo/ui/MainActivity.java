package example.androiddemo.ui;

import android.os.Bundle;

import example.androiddemo.R;
import example.androiddemo.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
