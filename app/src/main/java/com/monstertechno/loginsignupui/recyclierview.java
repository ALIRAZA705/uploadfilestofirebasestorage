package com.monstertechno.loginsignupui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class recyclierview extends AppCompatActivity {
    RecyclerView programinglist;
    private ExpandableListView listView;
    private expandablelist ebtn;
    DatabaseReference b1, b2, b3, b4;
    private List<String> ls;
    private HashMap<String, List<String>> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclierview);
        RecyclerView programinglist = findViewById(R.id.my_recycler_view);
        programinglist.setLayoutManager(new LinearLayoutManager(this));
        programinglist.setAdapter(new myadapter(this, getMYlist()));
//b1= FirebaseDatabase.getInstance().getReference();
//b2=b1.child("tasks");
//Query query=b2.orderByChild("email").equalTo(MainActivity.email);
//query.addValueEventListener(new ValueEventListener() {
//    @Override
//    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//        for(DataSnapshot child: dataSnapshot.getChildren()) {
//            ArrayList<model> modl1 = new ArrayList<>();
////            model m = new model();
//
//            model m1 = dataSnapshot.getValue(model.class);
//
//            modl1.add(m1);
//        }
//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//    }
//});


//b2.addValueEventListener(new ValueEventListener() {
//    @Override
//    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//        String post = dataSnapshot.getValue(String.class);
//        Log.v("aliraza" , "value is" + post);
//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError databaseError) {
////        Log.v("aliraza" , "value is" + post);
//    }
//});
//    }
    }

    private ArrayList<model> getMYlist() {
//        ArrayList<model> modl1=new ArrayList<>();

//        model m=new model();
//        m.setLocation("netherland1");
//        m.setTicket_no("ticket #2358");
//        modl1.add(m);
//
//        m=new model();
//        m.setLocation("netherland2");
//        m.setTicket_no("ticket #2359");
//        modl1.add(m);
//
//        m=new model();
//        m.setLocation("netherland3");
//        m.setTicket_no("ticket #2360");
//        modl1.add(m);
//        m=new model();
//        m.setLocation("netherland4");
//        m.setTicket_no("ticket #2361");
//        modl1.add(m);
//        m=new model();
//
//        m.setLocation("netherland5");
//        m.setTicket_no("ticket #2362");
//        modl1.add(m);
//        return modl1;
//        model m = new model();
        b1 = FirebaseDatabase.getInstance().getReference();
        b2 = b1.child("tasks");
        final  ArrayList<model>  modl1 = new ArrayList<>();
       b2.orderByChild("email").equalTo(MainActivity.email).addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
               model    m = dataSnapshot.getValue(model.class);
               Log.v("ali", "value " + m.getLocation());
                    Log.v("ali ticke", "value  ticket " + m.getTicket_no());
                    m.setLocation(m.getLocation());
                    m.setTicket_no( m.getTicket_no());
                    modl1.add(m);

           }

           @Override
           public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

           }

           @Override
           public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

           }

           @Override
           public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
//        Log.v("ali", "value " + MainActivity.email);
//        Log.v("ali5", "value " +query);
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot child : dataSnapshot.getChildren()) {
//
////            model m = new model();
//
//                    model    m = dataSnapshot.getValue(model.class);
//                    Log.v("ali", "value " + m.getLocation());
//                    Log.v("ali ticke", "value  ticket " + m.getTicket_no());
//                    m.setLocation(m.getLocation());
//                    m.setTicket_no( m.getTicket_no());
//                    modl1.add(m);
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
        return modl1;

    }
}
