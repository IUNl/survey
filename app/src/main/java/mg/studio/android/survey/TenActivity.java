package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TenActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_ten );

        btn = (Button)findViewById( R.id.button10 );
        Intent intent = getIntent();
        s1 = intent.getStringExtra( "question_one" );
        s2 = intent.getStringExtra( "question_two" );
        s3 = intent.getStringExtra( "question_three" );
        s4 = intent.getStringExtra( "question_four" );
        s5 = intent.getStringExtra( "question_five" );
        s6 = intent.getStringExtra( "question_six" );
        s7 = intent.getStringExtra( "question_seven" );
        s8 = intent.getStringExtra( "question_eight" );
        s9 = intent.getStringExtra( "question_nine" );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_eleven();
            }
        });
    }

    public String selectRadioBtn(RadioGroup radioGroup){
        RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        return(radioButton.getText().toString());
    }

    void to_eleven(){
        rg = (RadioGroup)findViewById( R.id.radioGroup10 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(TenActivity.this,ElevenActivity.class);
            intent.putExtra( "question_one", s1 );
            intent.putExtra( "question_two", s2 );
            intent.putExtra( "question_three", s3 );
            intent.putExtra( "question_four", s4 );
            intent.putExtra( "question_five", s5 );
            intent.putExtra( "question_six", s6 );
            intent.putExtra( "question_seven", s7 );
            intent.putExtra( "question_eight", s8 );
            intent.putExtra( "question_nine", s9 );
            intent.putExtra( "question_ten", selectRadioBtn(rg) );
            startActivity(intent);
        }else{
            Toast.makeText(TenActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }
    }
}
