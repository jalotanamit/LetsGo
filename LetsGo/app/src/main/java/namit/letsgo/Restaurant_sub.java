package namit.letsgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by jalotanamit on 21-07-2016.
 */
public class Restaurant_sub extends AppCompatActivity {
    ImageButton imageButton,imageButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_sub);
        imageButton= (ImageButton) findViewById(R.id.imageButton10);
        imageButton2= (ImageButton) findViewById(R.id.imageButton11);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Restaurant_sub.this,Restaurant_500.class);
                startActivity(i);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Restaurant_sub.this,Restaurant_5.class);
                startActivity(i2);
            }
        });
    }
}
