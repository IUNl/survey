package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FiveActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_five );

        btn = (Button)findViewById( R.id.button5 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_six();
            }
        });
    }

    void to_six() {
        rg = (RadioGroup) findViewById( R.id.radioGroup5 );
        CheckBox cb1 = (CheckBox)findViewById( R.id.cb51 );
        CheckBox cb2 = (CheckBox)findViewById( R.id.cb52 );
        CheckBox cb3 = (CheckBox)findViewById( R.id.cb53 );
        CheckBox cb4 = (CheckBox)findViewById( R.id.cb54 );
        CheckBox cb5 = (CheckBox)findViewById( R.id.cb55 );
        CheckBox cb6 = (CheckBox)findViewById( R.id.cb56 );
        CheckBox cb7 = (CheckBox)findViewById( R.id.cb57);
        if (cb1.isChecked()||cb2.isChecked()||cb3.isChecked()||cb4.isChecked()||cb5.isChecked()||cb6.isChecked()||cb7.isChecked()) {
            Intent intent = new Intent();
            intent.setClass( FiveActivity.this, SixActivity.class );
            startActivity( intent );
        } else {
            Toast.makeText( FiveActivity.this, "You have to choose one at least!", Toast.LENGTH_SHORT ).show();
        }
    }
}
