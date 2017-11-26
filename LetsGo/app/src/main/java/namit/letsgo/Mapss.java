package namit.letsgo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by jalotanamit on 31-08-2016.
 */
public class Mapss extends AppCompatActivity {
    Bundle bundle;
    TextView t1,t2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapss);
        t1= (TextView) findViewById(R.id.textView4);
        t2= (TextView) findViewById(R.id.textView5);
        bundle=getIntent().getExtras();
        String s=bundle.getString("abc");
        String s2=bundle.getString("aaa");
        t1.setText(s);
        t2.setText(s2);




    }
}
