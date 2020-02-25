package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FourActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    String s1,s2,s3,s4 = "";
    CheckBox c1,c2,c3,c4,c5,c6,c7;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_four );

        btn = (Button)findViewById( R.id.button4 );
        c1 = findViewById( R.id.cb41 );c2 = findViewById( R.id.cb42 );c3 = findViewById( R.id.cb43 );c4 = findViewById( R.id.cb44);
        c5 = findViewById( R.id.cb45 );c6 = findViewById( R.id.cb46 );c7 = findViewById( R.id.cb47 );
        Intent intent = getIntent();
        s1 = intent.getStringExtra( "question_one" );
        s2 = intent.getStringExtra( "question_two" );
        s3 = intent.getStringExtra( "question_three" );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_five();
            }
        });
    }

    void to_five() {
        if(c1.isChecked()){
            count++;
            s4 += "(" + count + ")." + "Music functions.";
        }
        if(c2.isChecked()){
            count++;
            s4 += "(" + count + ")." + "Photo functions.";
        }
        if(c3.isChecked()){
            count++;
            s4 += "(" + count + ")." + "Game functions.";
        }
        if(c4.isChecked()){
            count++;
            s4 += "(" + count + ")." + "Bussiness functions(Word,Excel,etc).";
        }
        if(c5.isChecked()){
            count++;
            s4 += "(" + count + ")." + "GPS functions.";
        }
        if(c6.isChecked()){
            count++;
            s4 += "(" + count + ")." + "Data functions(BlueTooth,WLAN,etc).";
        }
        if(c7.isChecked()){
            count++;
            s4 += "(" + count + ")." + "Others.";
        }
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
            intent.putExtra( "question_one", s1 );
            intent.putExtra( "question_two", s2 );
            intent.putExtra( "question_three", s3 );
            intent.putExtra( "question_four", s4 );
            startActivity( intent );
        } else {
            Toast.makeText( FourActivity.this, "You have to choose one at least!", Toast.LENGTH_SHORT ).show();
        }
    }
}
