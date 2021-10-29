package com.example.userroomdatabase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userroomdatabase.R;
import com.example.userroomdatabase.entities.UserEntity;
import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {

    // create  a list for of UserEntity
    List<UserEntity> userEntityList;

    // create a constructor for the adapter
    public UserRecyclerAdapter(List<UserEntity> userList) {
        this.userEntityList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the row item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item, parent, false);
//         UserRecyclerAdapter.UserViewHolder userViewHolder = new UserViewHolder(view);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) { //relates to the for loop in Java SE by putting in information into the viewHolder for each element of the ArrayList
        holder.user_id.setText(""+userEntityList.get(position).getId()); //cast to string by concatenation
        holder.user_email.setText(userEntityList.get(position).getEmail());
        holder.user_name.setText(userEntityList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return userEntityList.size();
    }

    public  class UserViewHolder extends RecyclerView.ViewHolder {
             TextView user_id, user_name, user_email; // Make references for the views from the layout,
            public UserViewHolder(@NonNull View itemView) {
                super(itemView); // calls the constructor of the superclass, RecyclerView.ViewHolder
                user_id = itemView.findViewById(R.id.id); // Be careful of the variable names. Adapter class collects the viewClass objects from the view Layout file
                user_name = itemView.findViewById(R.id.name); // that is, the LayoutResourceXmlFile and NO other! If you reffer to variable names that do not exist
                user_email = itemView.findViewById(R.id.email); // or the wrong variable names, then an error will surely occur!
            }
    }

}
