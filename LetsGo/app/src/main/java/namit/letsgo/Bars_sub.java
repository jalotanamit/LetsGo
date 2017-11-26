package namit.letsgo;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by jalotanamit on 25-07-2016.
 */
public class Bars_sub extends AppCompatActivity{
    ImageButton i1,i2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bars_sub);
        i1= (ImageButton) findViewById(R.id.imageButton10);
        i2= (ImageButton) findViewById(R.id.imageButton11);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Bars_sub.this,Bars_500.class);
                startActivity(i);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Bars_sub.this,Bars_5.class);
                startActivity(i1);
            }
        });


    }


}
