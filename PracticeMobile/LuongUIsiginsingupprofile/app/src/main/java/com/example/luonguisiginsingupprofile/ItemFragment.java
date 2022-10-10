package com.example.luonguisiginsingupprofile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link ItemFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class ItemFragment extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public ItemFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ItemFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ItemFragment newInstance(String param1, String param2) {
//        ItemFragment fragment = new ItemFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    ImageView imgHinh, backHomeFragment;
    TextView txtItemTen,txtItemMota;


    public ItemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_item, container, false);

        Bundle bundle = this.getArguments();
        String hinh  = bundle.getString("img");
        String ten  = bundle.getString("name");
        String mota  = bundle.getString("description");


        imgHinh = view.findViewById(R.id.imgItemHinh);
        txtItemTen = view.findViewById(R.id.txtItemName);
        txtItemMota = view.findViewById(R.id.txtItemMoTa);

        txtItemTen.setText(ten);
        Glide.with(getContext()).load(hinh).into(imgHinh);
        txtItemMota.setText(mota);

        backHomeFragment = view.findViewById(R.id.backHomeFragment);
        backHomeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment() ).addToBackStack(null).commit();
            }
        });

        return view;
    }
}