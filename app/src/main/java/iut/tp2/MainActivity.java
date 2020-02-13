package iut.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        float resultat = 0;

        switch(v.getId()){
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
        result.setText(getString(R.string.result, resultat));
    }
}
