package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TenActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_ten );

        btn = (Button)findViewById( R.id.button10 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_eleven();
            }
        });
    }

    void to_eleven(){
        rg = (RadioGroup)findViewById( R.id.radioGroup10 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(TenActivity.this,ElevenActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(TenActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }
    }
}
