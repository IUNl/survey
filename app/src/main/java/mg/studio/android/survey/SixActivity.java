package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SixActivity extends AppCompatActivity {
    Button btn;
    EditText et;
    String s1,s2,s3,s4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_six );

        btn = (Button)findViewById( R.id.button6 );
        Intent intent = getIntent();
        s1 = intent.getStringExtra( "question_one" );
        s2 = intent.getStringExtra( "question_two" );
        s3 = intent.getStringExtra( "question_three" );
        s4 = intent.getStringExtra( "question_four" );
        s5 = intent.getStringExtra( "question_five" );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_seven();
            }
        });
    }

    public String selectRadioBtn(RadioGroup radioGroup){
        RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        return(radioButton.getText().toString());
    }

    void to_seven() {
        et = (EditText) findViewById( R.id.et61 );
        if (!et.getText().toString().isEmpty()) {
            Intent intent = new Intent();
            intent.setClass( SixActivity.this, SevenActivity.class );
            intent.putExtra( "question_one", s1 );
            intent.putExtra( "question_two", s2 );
            intent.putExtra( "question_three", s3 );
            intent.putExtra( "question_four", s4 );
            intent.putExtra( "question_five", s5 );
            intent.putExtra( "question_six", et.getText().toString() );
            startActivity( intent );
        } else {
            Toast.makeText( SixActivity.this, "You have to text something!", Toast.LENGTH_SHORT ).show();
        }
    }
}
