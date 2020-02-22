package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TwoActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_two );

        btn = (Button)findViewById( R.id.button2 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_three();
            }
        });
    }

    void to_three(){
        rg = (RadioGroup)findViewById( R.id.radioGroup2 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(TwoActivity.this,ThreeActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(TwoActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }

    }
}
