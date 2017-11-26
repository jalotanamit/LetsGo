package namit.letsgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    ImageButton i1, i2, i3, i4, i5, i6, i7, i8, i9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        i1 = (ImageButton) findViewById(R.id.imageButton);
        i2 = (ImageButton) findViewById(R.id.imageButton2);
        i3 = (ImageButton) findViewById(R.id.imageButton3);
        i4 = (ImageButton) findViewById(R.id.imageButton4);
        i5 = (ImageButton) findViewById(R.id.imageButton5);
        i6 = (ImageButton) findViewById(R.id.imageButton6);
        i7 = (ImageButton) findViewById(R.id.imageButton7);
        i8 = (ImageButton) findViewById(R.id.imageButton8);
        i9 = (ImageButton) findViewById(R.id.imageButton9);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Restaurant_sub.class);
                startActivity(i);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(MainActivity.this, School_sub.class);
                startActivity(i4);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(MainActivity.this, Hospital_sub.class);
                startActivity(i5);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Bars_sub.class);
                startActivity(intent2);
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intx = new Intent(MainActivity.this, Store_sub.class);
                startActivity(intx);
            }
        });
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this, Mall_sub.class);
                startActivity(i3);
            }
        });
        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(MainActivity.this, Atm_sub.class);
                startActivity(i6);
            }
        });
        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(MainActivity.this, Lodging_sub.class);
                startActivity(i7);
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(MainActivity.this, Homecare_sub.class);
                startActivity(intent8);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      //  int id = item.getItemId();
      //  if (id == R.id.android1) {
            //Toast.makeText(MainActivity.this,"You clicked on Android",Toast.LENGTH_SHORT).show();
       // }
        return super.onOptionsItemSelected(item);
    }
}
