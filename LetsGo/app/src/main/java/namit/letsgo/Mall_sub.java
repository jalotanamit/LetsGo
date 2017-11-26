package namit.letsgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Created by jalotanamit on 23-07-2016.
 */
public class Mall_sub extends AppCompatActivity {
    ImageButton im1,im2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mall_sub);
        im1= (ImageButton) findViewById(R.id.imageButton10);
        im2= (ImageButton) findViewById(R.id.imageButton11);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Mall_sub.this,Mall_500.class);
                startActivity(i);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Mall_sub.this,Mall_5.class);
                startActivity(i2);
            }
        });


    }
}
