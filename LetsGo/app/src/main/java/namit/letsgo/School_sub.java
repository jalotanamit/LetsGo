package namit.letsgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by jalotanamit on 23-07-2016.
 */
public class School_sub extends AppCompatActivity{
    ImageButton im1,im2;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_sub);
        im1= (ImageButton) findViewById(R.id.imageButton10);
        im2= (ImageButton) findViewById(R.id.imageButton11);
        t1= (TextView) findViewById(R.id.textView11);
        t2= (TextView) findViewById(R.id.textView12);
        t3= (TextView) findViewById(R.id.textView13);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(School_sub.this,School_500.class);
                startActivity(i);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(School_sub.this,School_5.class);
                startActivity(i1);
            }
        });


    }
}
