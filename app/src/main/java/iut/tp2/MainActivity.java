package iut.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = ((EditText) findViewById(R.id.editText1));
        final EditText editText2 = ((EditText) findViewById(R.id.editText2));

        TextWatcher watson = new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable editable) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ((TextView)findViewById(R.id.result)).setText(getString(R.string.result, ""));

                findViewById(R.id.calculer).setEnabled(editText1.getText().length() > 0 && editText2.getText().length() > 0);
            }
        };

        editText1.addTextChangedListener(watson);
        editText2.addTextChangedListener(watson);
    }

    public void onClick(View v){
        Editable op1 = ((EditText) findViewById(R.id.editText1)).getText();
        Editable op2 = ((EditText) findViewById(R.id.editText2)).getText();
        if(op1.length() == 0 || op2.length() == 0){
            Toast.makeText(getApplicationContext(), getString(R.string.notSpecified), Toast.LENGTH_SHORT).show();
            return;
        }

        float v1 = Integer.parseInt(op1.toString());
        float v2 = Integer.parseInt(op2.toString());
        Float resultat = 0F;


        RadioGroup rg = findViewById(R.id.radioGroup);
        switch(rg.getCheckedRadioButtonId()){
            case R.id.addition:
                resultat = v1 + v2;
                break;

            case R.id.divide:
                if(v2 == 0){
                    Toast.makeText(getApplicationContext(), getString(R.string.dividedByZero), Toast.LENGTH_SHORT).show();
                } else {
                    resultat = v1 / v2;
                }
                break;

            case R.id.multiply:
                resultat = v1 * v2;
                break;

            case R.id.substract:
                resultat = v1 - v2;
                break;

        }


        TextView result = findViewById(R.id.result);
        result.setText(getString(R.string.result, resultat.toString()));
    }
}
