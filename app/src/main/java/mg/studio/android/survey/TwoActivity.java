package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TwoActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_two );

        btn = (Button)findViewById( R.id.button2 );
        Intent intent = getIntent();
        s1 = intent.getStringExtra( "question_one" );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_three();
            }
        });
    }

    public String selectRadioBtn(RadioGroup radioGroup){
        RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        return(radioButton.getText().toString());
    }

    void to_three(){
        rg = (RadioGroup)findViewById( R.id.radioGroup2 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(TwoActivity.this,ThreeActivity.class);
            intent.putExtra( "question_one", s1 );
            intent.putExtra( "question_two", selectRadioBtn(rg) );
            startActivity(intent);
        }else{
            Toast.makeText(TwoActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }

    }
}
