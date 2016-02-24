package oleg.hubal.com.tm_homework04;

import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.WhiteTheme);
        setContentView(R.layout.activity_main);
    }
}
