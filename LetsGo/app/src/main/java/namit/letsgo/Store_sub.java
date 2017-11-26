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
public class Store_sub extends AppCompatActivity {
    ImageButton im1,im2,im3,im4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_sub);
        im1= (ImageButton) findViewById(R.id.imageButton12);
        im2= (ImageButton) findViewById(R.id.imageButton13);
        im3= (ImageButton) findViewById(R.id.imageButton15);
        im4= (ImageButton) findViewById(R.id.imageButton14);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Store_sub.this,Store_electronics.class);
                startActivity(i);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Store_sub.this,Store_hardware.class);
                startActivity(i2);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Store_sub.this,Store_jewelery.class);
                startActivity(i3);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(Store_sub.this,Store_goods.class);
                startActivity(i4);
            }
        });
    }
}
