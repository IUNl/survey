package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EightActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_eight );

        btn = (Button)findViewById( R.id.button8 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_nine();
            }
        });
    }

    void to_nine(){
        rg = (RadioGroup)findViewById( R.id.radioGroup8 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(EightActivity.this,NineActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(EightActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }
    }
}
