package namit.letsgo;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jalotanamit on 30-07-2016.
 */
public class Lodging_5 extends AppCompatActivity implements LocationListener {
    String latitude, longitude;
    String url;
    ProgressDialog progressDialog;
    ListView listView;
    RequestQueue requestQueue;
    LocationManager locationManager;
    int listno;
    String namee, address,lattiis,longiis,opens;
    ArrayList nam = new ArrayList();
    ArrayList addr = new ArrayList();
    ArrayList longim = new ArrayList();
    ArrayList lattim = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lodging_5);
        listView = (ListView) findViewById(R.id.listView14);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        //Toast.makeText(Lodging_5.this, "Getting your Location", Toast.LENGTH_LONG).show();
        //Toast.makeText(Lodging_5.this, "Please wait", Toast.LENGTH_SHORT).show();
        progressDialog=ProgressDialog.show(this,"Loading","Please wait",true);

    }

    @Override
    public void onLocationChanged(Location location) {
        double lat=location.getLatitude();
        double lng=location.getLongitude();
        latitude=String.valueOf(lat);
        longitude=String.valueOf(lng);
        url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+latitude+","+longitude+"&radius=5000&types=lodging&sensor=false&key=AIzaSyBYim7RY_8oUxXfBxnJCb0jjgPCDrFr790";

        requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray=jsonObject.getJSONArray("results");
                    listno=jsonArray.length();
                    JSONObject obj2;
                    JSONObject obj3;
                    for(int i=0;i<listno;i++)
                    {
                        JSONObject obj=jsonArray.getJSONObject(i);
                        namee=obj.getString("name");
                        address=obj.getString("vicinity");
                        obj2=obj.getJSONObject("geometry");
                        obj3=obj2.getJSONObject("location");
                        lattiis=obj3.getString("lat");
                        longiis=obj3.getString("lng");
                        nam.add(namee);
                        addr.add(address);
                        longim.add(longiis);
                        lattim.add(lattiis);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MyCustomList myCustomList=new MyCustomList();
                listView.setAdapter(myCustomList);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Lodging_5.this, ""+volleyError, Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonObjectRequest);
        progressDialog.dismiss();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    public class MyCustomList extends BaseAdapter {

        @Override
        public int getCount() {
            return listno;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.customlayout_mall,parent,false);
            ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView);
            //TextView pr= (TextView) convertView.findViewById(R.id.textView52);
            final TextView na= (TextView) convertView.findViewById(R.id.textView14);
            final TextView dis= (TextView) convertView.findViewById(R.id.textView15);
            final TextView lo= (TextView) convertView.findViewById(R.id.textView6);
            final TextView la= (TextView) convertView.findViewById(R.id.textView7);
            Button mybtn= (Button) convertView.findViewById(R.id.button2);

            mybtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(Lodging_5.this,Mapsss.class);
                    i.putExtra("abc",la.getText());
                    i.putExtra("aaa",lo.getText());
                    i.putExtra("aba",na.getText());
                    startActivity(i);
                }
            });
            na.setText((CharSequence) nam.get(position));
            dis.setText((CharSequence) addr.get(position));
            lo.setText((CharSequence) longim.get(position));
            la.setText((CharSequence) lattim.get(position));
            return convertView;

        }
    }
}
