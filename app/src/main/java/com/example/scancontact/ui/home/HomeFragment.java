package com.example.scancontact.ui.home;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.scancontact.MainActivity;
import com.example.scancontact.R;
import com.example.scancontact.ui.dashboard.DashboardFragment;


public class HomeFragment extends Fragment {
    ListAdapter mListAdapter;
    private ListView mListView;


    public HomeFragment () {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = (LinearLayout) inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        final String[] contacts =
                view.getResources().getStringArray(R.array.contacts_array);
        final String[] phoneNumber =
                view.getResources().getStringArray(R.array.phones_array);
        final int[] flag = {R.drawable.pictures, R.drawable.pictures,
                R.drawable.pictures, R.drawable.pictures,R.drawable.pictures, R.drawable.pictures,
                R.drawable.pictures, R.drawable.pictures, R.drawable.pictures,
                R.drawable.pictures};
        mListView = (ListView)view.findViewById(R.id.listview);
        mListAdapter =new ListAdapter(getActivity(), contacts, phoneNumber,
                flag);
        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int
                    i, long l) {
                Toast.makeText(getActivity(), contacts[i],
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present
        inflater.inflate(R.menu.top_nav_menu, menu);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}

