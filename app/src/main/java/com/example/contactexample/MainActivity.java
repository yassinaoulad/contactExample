package com.example.contactexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    MyDbContact db;
    ArrayList<Contact> lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lst = findViewById(R.id.lst);
        db = new MyDbContact(this);
        lc = new ArrayList<>();


        lc.add(new Contact("said","male","0673284936",R.drawable.male));
        lc.add(new Contact("hamid","male","0602884936",R.drawable.male));
        lc.add(new Contact("farid","male","0013700936",R.drawable.male));
        lc.add(new Contact("saida","female","31903847",R.drawable.female));
        lc.add(new Contact("majid","male","47403403",R.drawable.male));
        lc.add(new Contact("hamida","female","077393622",R.drawable.female));
        lc.add(new Contact("farida","female","1102472",R.drawable.female));


       // for (Contact c:lc)
        //    if (MyDbContact.insert_contact(db.getWritableDatabase(),c)==-1)
         //       Toast.makeText(this, "Cannot insert data into database", Toast.LENGTH_LONG).show();


        lc=MyDbContact.getAllcontacts(db.getReadableDatabase());
        ArrayList<HashMap<String,Object>> data=new ArrayList<>();
        for (Contact c:lc){
            HashMap<String,Object> hm=new HashMap<>();
            hm.put("name",c.getName());
            hm.put("number",c.getNumber());
            hm.put("pic",c.getPicture());
            data.add(hm);
        }

        String[] from={"name","number","pic"};
        int[] to={R.id.txtName,R.id.txtNumber,R.id.picId};
        SimpleAdapter ad=new SimpleAdapter(this,data,R.layout.strip_layout,from,to);
        lst.setAdapter(ad);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Contact con=lc.get(i);
                Intent in=new Intent(MainActivity.this,Details.class);
                in.putExtra("contact",con);
                startActivity(in);
            }
        });




    }
}