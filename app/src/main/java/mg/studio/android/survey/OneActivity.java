package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OneActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_one );

        btn = (Button)findViewById( R.id.button1 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_two();
            }
        });
    }

    void to_two(){
        rg = (RadioGroup)findViewById( R.id.radioGroup1 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(OneActivity.this,TwoActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(OneActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }
    }
}
