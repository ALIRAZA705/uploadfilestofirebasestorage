package com.monstertechno.loginsignupui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends  RecyclerView.Adapter<myholder>{
    Context c;
    ArrayList<model> modl;

    public myadapter(Context c, ArrayList<model> modl) {
        this.c = c;
        this.modl = modl;
    }

    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflate =LayoutInflater.from(parent.getContext());//to create view jtna bhi view hotay h layout k andar us k lya object dete ha
       View view=inflate.inflate(R.layout.row,parent,false);
       // View view=inflate.inflate(R.layout.row,null);
//     RecyclerView.ViewHolder viewHolder = new Viewholder((LinearLayout) cardlayout);
        return new myholder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull final  myholder holder, final int position) {
//holder.tx.setText(modl.get(position));
      //  holder.tx2.setText("vavav");
//        model m1=new model();
        holder.tx.setText(modl.get(position).getTicket_no());
        holder.tx2.setText(modl.get(position).getLocation());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        Toast.makeText(getClass(),"text is " ,Toast.LENGTH_LONG ).show();
        Toast.makeText(c,"field are empty" +position ,Toast.LENGTH_SHORT).show();
//        if(position==1)
            Intent intent=new Intent(v.getContext(),homeActivity.class);
            intent.putExtra("ticket no" ,holder.tx.getText());
        v.getContext().startActivity(intent);
//        startActivity(new Intent(myadapter.this,homac.class));
    }
});
    }

    @Override
    public int getItemCount() {
        return modl.size();
    }
}
