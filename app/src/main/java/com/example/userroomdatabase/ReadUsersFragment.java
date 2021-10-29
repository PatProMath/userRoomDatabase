package com.example.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.userroomdatabase.adapter.UserRecyclerAdapter;
import com.example.userroomdatabase.entities.UserEntity;

import java.util.List;

public class ReadUsersFragment extends Fragment {
    RecyclerView recyclerView;
    UserRecyclerAdapter userRecyclerAdapter;
    List<UserEntity> userEntityList;

    public ReadUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //populate tthe userEntityList with users from the Room database using the database object
        userEntityList = MainActivity.userDatabase.userDao().getUsers();
        // pass in the userEntityList to the userRecyclerAdapter as an argument for its constructor
        // Log.d(TAG, "onCreateView: "+userEntityList.get(0).getName()+" and "+userEntityList.get(1).getName());
        userRecyclerAdapter = new UserRecyclerAdapter(userEntityList);

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_users, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        // set up divider for the recyclerview
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true);
        /* The above line informs the RecyclerView object, recyclerView that its width and height should always remain the same. Otherwise, as
        individual list item views are continually recycled, it may attempt to reset its own size to best fit the content.
        If each list item was a different size, the RecyclerView might need to resize as we scrolled to best fit content, but our
         list items are pretty uniform. So, we can avoid wasting precious processing power by setting a fixed size. */
        recyclerView.setAdapter(userRecyclerAdapter);
        return view;
    }
}