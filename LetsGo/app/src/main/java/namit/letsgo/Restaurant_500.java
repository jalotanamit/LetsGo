package namit.letsgo;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
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
import android.widget.RatingBar;
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
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by jalotanamit on 21-07-2016.
 */
public class Restaurant_500 extends AppCompatActivity implements LocationListener {

    String latitude, longitude;

    String url;
    ProgressDialog progressDialog;
    ListView listView;
    RequestQueue requestQueue;
    LocationManager locationManager;
    int listno;
    String namee, address,lattiis,longiis,opens;
    Double ratis;


    ArrayList nam = new ArrayList();
    ArrayList addr = new ArrayList();
    ArrayList longim = new ArrayList();
    ArrayList lattim = new ArrayList();
   // ArrayList ratt=new ArrayList();
    //ArrayList rat =new ArrayList();
    //ArrayList rating= new ArrayList();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_500);
      // new MyAsyncTask().execute();
        listView = (ListView) findViewById(R.id.listView2);
        locationManager= (LocationManager) getSystemService(LOCATION_SERVICE);

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
       // Toast.makeText(Restaurant_500.this, "Getting your Location", Toast.LENGTH_LONG).show();
        //Toast.makeText(Restaurant_500.this, "Please wait", Toast.LENGTH_SHORT).show();
        progressDialog=ProgressDialog.show(this,"Loading","Please wait",true);
    }



    @Override
    public void onLocationChanged(Location location) {
        double lat=location.getLatitude();
        double lng=location.getLongitude();
        latitude=String.valueOf(lat);
        longitude=String.valueOf(lng);
       url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+latitude+","+longitude+"&radius=500&types=restaurant&sensor=false&key=AIzaSyBYim7RY_8oUxXfBxnJCb0jjgPCDrFr790";


       // url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=28.5806201,77.3150729&radius=500&types=restaurant&sensor=false&key=AIzaSyBYim7RY_8oUxXfBxnJCb0jjgPCDrFr790";
       requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray=jsonObject.getJSONArray("results");
                    listno=jsonArray.length();
                    JSONObject obj2;
                    JSONObject obj3;
                    //JSONObject obj4;
                    for(int i=0;i<listno;i++)
                    {
                        JSONObject obj=jsonArray.getJSONObject(i);
                        namee=obj.getString("name");
                        address=obj.getString("vicinity");
                        //ratis= obj.getDouble("rating");
                        //ratings=obj.getString("rating");
                        obj2=obj.getJSONObject("geometry");
                        obj3=obj2.getJSONObject("location");
                        lattiis=obj3.getString("lat");
                        longiis=obj3.getString("lng");

                        //obj4=obj.getJSONObject("opening_hours");
                        //opens=obj4.getString("open_now");

                        //obj2=obj.getJSONObject("opening_hours");
                        //openn=obj2.getBoolean("open_now");
                        //ratings=obj.getString("rating");


                        nam.add(namee);
                        addr.add(address);
                        longim.add(longiis);
                        lattim.add(lattiis);
                        //ratt.add(ratis);
                        //rat.add(ratis);



                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MyCustomList myCustomList=new MyCustomList();
                listView.setAdapter(myCustomList);

                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Restaurant_500.this, ""+volleyError, Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonObjectRequest);


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
            convertView=getLayoutInflater().inflate(R.layout.customlayout_rest,parent,false);
            ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView);
            //TextView pr= (TextView) convertView.findViewById(R.id.textView52);
            final TextView na= (TextView) convertView.findViewById(R.id.textView14);
            TextView dis= (TextView) convertView.findViewById(R.id.textView15);
            final TextView lo= (TextView) convertView.findViewById(R.id.textView);
            final TextView la= (TextView) convertView.findViewById(R.id.textView2);
           // TextView op= (TextView) convertView.findViewById(R.id.textView4);
            Button mybtn= (Button) convertView.findViewById(R.id.button);

            mybtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(Restaurant_500.this,Mapsss.class);
                    i.putExtra("abc",la.getText());
                    i.putExtra("aaa",lo.getText());
                    i.putExtra("aba",na.getText());
                    startActivity(i);
                }
            });


            //imageView.setImageResource(image[position]);
            //pr.setText(cloths[position]);
            na.setText((CharSequence) nam.get(position));
            dis.setText((CharSequence) addr.get(position));
            lo.setText((CharSequence) longim.get(position));
            la.setText((CharSequence) lattim.get(position));
            //op.setText(String.valueOf(rat.get(position)));
            return convertView;

        }
    }





}
