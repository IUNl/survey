package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.widget.TextView;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_report );

        Intent intent = getIntent();
        tv1 = findViewById( R.id.tv1 );tv2 = findViewById( R.id.tv2 );tv3 = findViewById( R.id.tv3 );tv4 = findViewById( R.id.tv4 );
        tv5 = findViewById( R.id.tv5 );tv6 = findViewById( R.id.tv6 );tv7 = findViewById( R.id.tv7 );tv8 = findViewById( R.id.tv8 );
        tv9 = findViewById( R.id.tv9 );tv10 = findViewById( R.id.tv10 );tv11 = findViewById( R.id.tv11 );tv12 = findViewById( R.id.tv12 );

        tv1.setText( "Q1:" + intent.getStringExtra( "question_one" ) );tv2.setText( "Q2:" + intent.getStringExtra( "question_two" ) );
        tv3.setText( "Q3:" + intent.getStringExtra( "question_three" ) );tv4.setText( "Q4:" + intent.getStringExtra( "question_four" ) );
        tv5.setText( "Q5:" + intent.getStringExtra( "question_five" ) );tv6.setText( "Q6:" + intent.getStringExtra( "question_six" ) );
        tv7.setText( "Q7:" + intent.getStringExtra( "question_seven" ) );tv8.setText( "Q8:" + intent.getStringExtra( "question_eight" ) );
        tv9.setText( "Q9:" + intent.getStringExtra( "question_nine" ) );tv10.setText( "Q10:" + intent.getStringExtra( "question_ten" ) );
        tv11.setText( "Q11:" + intent.getStringExtra( "question_eleven" ) );tv12.setText( "Q12:" + intent.getStringExtra( "question_twelve" ) );
    }
}
