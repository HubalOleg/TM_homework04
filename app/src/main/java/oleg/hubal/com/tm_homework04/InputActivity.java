package oleg.hubal.com.tm_homework04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by User on 24.02.2016.
 */
public class InputActivity extends Activity implements View.OnClickListener {

    EditText edtInput;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MainActivity.themeValue);
        setContentView(R.layout.activity_input);

        initializeVariables();
        btnOk.setOnClickListener(this);

    }

    private void initializeVariables() {
        edtInput = (EditText) findViewById(R.id.edt_input_AI);
        btnOk = (Button) findViewById(R.id.btn_ok_AI);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok_AI:
                Intent intent = new Intent();
                intent.putExtra("value", edtInput.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
