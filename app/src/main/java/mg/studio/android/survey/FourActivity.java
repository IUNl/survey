package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FourActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_four );

        btn = (Button)findViewById( R.id.button4 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_five();
            }
        });
    }

    void to_five() {
        rg = (RadioGroup) findViewById( R.id.radioGroup4 );
        CheckBox cb1 = (CheckBox)findViewById( R.id.cb41 );
        CheckBox cb2 = (CheckBox)findViewById( R.id.cb42 );
        CheckBox cb3 = (CheckBox)findViewById( R.id.cb43 );
        CheckBox cb4 = (CheckBox)findViewById( R.id.cb44 );
        CheckBox cb5 = (CheckBox)findViewById( R.id.cb45 );
        CheckBox cb6 = (CheckBox)findViewById( R.id.cb46 );
        CheckBox cb7 = (CheckBox)findViewById( R.id.cb47 );
        if (cb1.isChecked()||cb2.isChecked()||cb3.isChecked()||cb4.isChecked()||cb5.isChecked()||cb6.isChecked()||cb7.isChecked()) {
            Intent intent = new Intent();
            intent.setClass( FourActivity.this, FiveActivity.class );
            startActivity( intent );
        } else {
            Toast.makeText( FourActivity.this, "You have to choose one at least!", Toast.LENGTH_SHORT ).show();
        }
    }
}
