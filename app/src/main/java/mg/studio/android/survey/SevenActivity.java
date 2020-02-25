package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SevenActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    String s1,s2,s3,s4,s5,s6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_seven );

        btn = (Button)findViewById( R.id.button7 );
        Intent intent = getIntent();
        s1 = intent.getStringExtra( "question_one" );
        s2 = intent.getStringExtra( "question_two" );
        s3 = intent.getStringExtra( "question_three" );
        s4 = intent.getStringExtra( "question_four" );
        s5 = intent.getStringExtra( "question_five" );
        s6 = intent.getStringExtra( "question_six" );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_eight();
            }
        });
    }

    public String selectRadioBtn(RadioGroup radioGroup){
        RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        return(radioButton.getText().toString());
    }

    void to_eight() {
        rg = (RadioGroup) findViewById( R.id.radioGroup7 );
        if (rg.getCheckedRadioButtonId() != -1) {
            Intent intent = new Intent();
            intent.setClass( SevenActivity.this, EightActivity.class );
            intent.putExtra( "question_one", s1 );
            intent.putExtra( "question_two", s2 );
            intent.putExtra( "question_three", s3 );
            intent.putExtra( "question_four", s4 );
            intent.putExtra( "question_five", s5 );
            intent.putExtra( "question_six", s6 );
            intent.putExtra( "question_seven", selectRadioBtn(rg) );
            startActivity( intent );
        } else {
            Toast.makeText( SevenActivity.this, "You have to choose one!", Toast.LENGTH_SHORT ).show();
        }
    }
}
