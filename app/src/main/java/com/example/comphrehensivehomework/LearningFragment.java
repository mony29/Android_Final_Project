package com.example.comphrehensivehomework;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.comphrehensivehomework.adapter.LearningAdapter;
import com.example.comphrehensivehomework.model.LearningItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningFragment extends Fragment {

    private ListView listView;
    private List<LearningItem> list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningFragment newInstance(String param1, String param2) {
        LearningFragment fragment = new LearningFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        // Please carefully of this 'R.layout.fragment_learning', R.id or R.layout
        @SuppressLint("ResourceType")
        View view = inflater.inflate(R.layout.fragment_learning, container, false);

        listView = view.findViewById(R.id.learningListView);

        list = new ArrayList<>();

        list.add(new LearningItem(R.drawable.coding, "Title 1", "Content 1"));
        list.add(new LearningItem(R.drawable.coding, "Title 2", "Content 2"));
        list.add(new LearningItem(R.drawable.coding, "Title 3", "Content 3"));

        if (list.isEmpty()) {
            Toast.makeText(getActivity(), "No data", Toast.LENGTH_LONG).show();
        }

        LearningAdapter adapter = new LearningAdapter(getActivity(), list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LearningItem clickedItem = list.get(position);

                Toast.makeText(getActivity(), "Clicked on : " + clickedItem.getTitle(), Toast.LENGTH_SHORT).show();

//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                ItemDetailFragment itemDetailFragment = ItemDetailFragment.newInstance(clickedItem);
//                transaction.replace(R.id.main, itemDetailFragment);
////                ItemDetailFragment itemDetailFragment = ItemDetailFragment.newInstance(clickedItem);
////                transaction.replace(R.id.container, itemDetailFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });

        return view;
    }
}