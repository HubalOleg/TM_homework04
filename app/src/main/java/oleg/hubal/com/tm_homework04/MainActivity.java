package oleg.hubal.com.tm_homework04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    static int themeValue = R.style.WhiteTheme;
    final int aRequestCode = 1, bRequestCode = 2;

    Switch swtTheme;
    Button btnCalc;
    TextView tvA, tvB, tvResult;
    EditText edtOper;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(themeValue);
        setContentView(R.layout.activity_main);

        initializeVarilables();
        setListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_a_AM:
                Intent intent = new Intent(this, InputActivity.class);
                startActivityForResult(intent, aRequestCode);
                break;
            case R.id.tv_b_AM:
                Intent intent1 = new Intent(this, InputActivity.class);
                startActivityForResult(intent1, bRequestCode);
                break;
            case R.id.btn_calc_AM:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null ) {return;}
        String value = data.getStringExtra("value");
        switch (requestCode) {
            case aRequestCode:
                tvA.setText(value);
                break;
            case bRequestCode:
                tvB.setText(value);
                break;
        }
    }

    private void setListener() {
        tvA.setOnClickListener(this);
        tvB.setOnClickListener(this);
        btnCalc.setOnClickListener(this);
        swtTheme.setOnCheckedChangeListener(new SwitchListener());
    }

    private void initializeVarilables() {
        swtTheme = (Switch) findViewById(R.id.swt_theme);
        btnCalc = (Button) findViewById(R.id.btn_calc_AM);
        tvA = (TextView) findViewById(R.id.tv_a_AM);
        tvB = (TextView) findViewById(R.id.tv_b_AM);
        tvResult = (TextView) findViewById(R.id.tvRes_AM);
        edtOper = (EditText) findViewById(R.id.edt_oper_AM);
    }

    class SwitchListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                themeValue = R.style.BlackTheme;
            } else {
                themeValue = R.style.WhiteTheme;
            }
        }
    }

}
