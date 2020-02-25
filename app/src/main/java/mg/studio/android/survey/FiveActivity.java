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

public class FiveActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    String s1,s2,s3,s4,s5 = "";
    CheckBox c1,c2,c3,c4,c5,c6,c7;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_five );

        btn = (Button)findViewById( R.id.button5 );
        c1 = findViewById( R.id.cb51 );c2 = findViewById( R.id.cb52 );c3 = findViewById( R.id.cb53 );c4 = findViewById( R.id.cb54);
        c5 = findViewById( R.id.cb55 );c6 = findViewById( R.id.cb56 );c7 = findViewById( R.id.cb57 );
        Intent intent = getIntent();
        s1 = intent.getStringExtra( "question_one" );
        s2 = intent.getStringExtra( "question_two" );
        s3 = intent.getStringExtra( "question_three" );
        s4 = intent.getStringExtra( "question_four" );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_six();
            }
        });
    }

    void to_six() {
        if(c1.isChecked()){
            count++;
            s5 += "(" + count + ")." + "Music functions.";
        }
        if(c2.isChecked()){
            count++;
            s5 += "(" + count + ")." + "Photo functions.";
        }
        if(c3.isChecked()){
            count++;
            s5 += "(" + count + ")." + "Game functions.";
        }
        if(c4.isChecked()){
            count++;
            s5 += "(" + count + ")." + "Bussiness functions(Word,Excel,etc).";
        }
        if(c5.isChecked()){
            count++;
            s5 += "(" + count + ")." + "GPS functions.";
        }
        if(c6.isChecked()){
            count++;
            s5 += "(" + count + ")." + "Data functions(BlueTooth,WLAN,etc).";
        }
        if(c7.isChecked()){
            count++;
            s5 += "(" + count + ")." + "Others.";
        }
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
            intent.putExtra( "question_one", s1 );
            intent.putExtra( "question_two", s2 );
            intent.putExtra( "question_three", s3 );
            intent.putExtra( "question_four", s4 );
            intent.putExtra( "question_five", s5 );
            startActivity( intent );
        } else {
            Toast.makeText( FiveActivity.this, "You have to choose one at least!", Toast.LENGTH_SHORT ).show();
        }
    }
}
