package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NineActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.question_nine );

        btn = (Button)findViewById( R.id.button9 );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_ten();
            }
        });
    }

    void to_ten(){
        rg = (RadioGroup)findViewById( R.id.radioGroup9 );
        if(rg.getCheckedRadioButtonId() != -1){
            Intent intent = new Intent();
            intent.setClass(NineActivity.this,TenActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(NineActivity.this, "You have to choose one!", Toast.LENGTH_SHORT).show();
        }
    }
}
