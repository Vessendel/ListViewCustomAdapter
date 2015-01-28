package com.example.wolf.testadapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {

    ListView lv;
    Context context;


    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1};
    public static String [] prgmNameList={"Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C","Let Us C"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        ArrayList<String> arr=new ArrayList<String>();


        try {
            String json = loadJSONFromAsset();
            JSONObject parsedjson = new JSONObject(json);


            Iterator iter = parsedjson.keys();
            while(iter.hasNext()){
                String key = (String)iter.next();
                arr.add(parsedjson.getString(key));
            }




        } catch (Exception e) {
            e.printStackTrace();
        }
        CustomAdapter adapter = new CustomAdapter(this, prgmNameList,prgmImages);
        adapter.arr = arr;
        lv.setAdapter(adapter);
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("json.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}



