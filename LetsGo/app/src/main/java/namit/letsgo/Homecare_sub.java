package namit.letsgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by jalotanamit on 30-07-2016.
 */
public class Homecare_sub extends AppCompatActivity {
    ImageButton im1,im2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homecare_sub);
        im1= (ImageButton) findViewById(R.id.imageButton10);
        im2= (ImageButton) findViewById(R.id.imageButton11);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Homecare_sub.this,Plumber.class);
                startActivity(i);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Homecare_sub.this,Electrician.class);
                startActivity(i2);
            }
        });
    }
}
