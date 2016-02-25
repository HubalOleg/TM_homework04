package oleg.hubal.com.tm_homework04;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    static int themeValue = R.style.WhiteTheme;
    final int aRequestCode = 1, bRequestCode = 2;

    Switch swtTheme;
    Button btnCalc;
    TextView tvA, tvB, tvResult;
    EditText edtOper;
    int a, b;
    String oper;
    Context context;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(themeValue);
        setContentView(R.layout.activity_main);

        context = this;
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
                oper = edtOper.getText().toString();
                if (checkValues(oper, tvA.getText().toString(), tvB.getText().toString())) {
                    result = calculateValues(oper);
                    tvResult.setText(String.valueOf(result));
                }
        }
    }

    private int calculateValues(String oper) {
        switch (oper) {
            case "-":
                return (a - b);
            case "+":
                return (a + b);
            case "*":
                return (a * b);
            case "/":
                return (a / b);
            default:
                return 0;
        }
    }

    private boolean checkValues(String oper, String a, String b) {
        if(oper.isEmpty() || a.isEmpty() || b.isEmpty()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show();
            return false;
        } else if (!(oper.equals("-") || oper.equals("+") || oper.equals("/") || oper.equals("*"))) {
            Toast.makeText(this, "Выбирете одну из операций:(+,-,*,/)",Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null ) {return;}
        String value = data.getStringExtra("value");

        switch (requestCode) {
            case aRequestCode:
                tvA.setText(value);
                a = Integer.parseInt(value);
                break;
            case bRequestCode:
                tvB.setText(value);
                b = Integer.parseInt(value);
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
