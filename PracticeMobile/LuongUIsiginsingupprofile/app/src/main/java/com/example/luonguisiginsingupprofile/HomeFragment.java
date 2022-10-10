package com.example.luonguisiginsingupprofile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


//*
// * A simple {@link Fragment} subclass.
// * Use the {@link HomeFragment#newInstance} factory method to
// * create an instance of this fragment.

public class HomeFragment extends Fragment {

    ListView lvBanBe;
    ArrayList<BanBe> arrayBanBe;
    BanBeAdapter adapter;

    Button btnChuyen;
    EditText edt;
    int vitri;

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
//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
///*
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HomeFragment.
//     */
//
//    // TODO: Rename and change types and number of parameters
//    public static HomeFragment newInstance(String param1, String param2) {
//        HomeFragment fragment = new HomeFragment();
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
//

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        lvBanBe = view.findViewById(R.id.listviewBanBe);
        lvBanBe = (ListView) view.findViewById(R.id.listviewBanBe);
        arrayBanBe = new ArrayList<>();

        arrayBanBe.add(new BanBe("Nguyễn Đức Cường", "Bạn thân nhất", "https://scontent.fdad3-5.fna.fbcdn.net/v/t39.30808-6/310380973_3222132724782742_3766321947549458839_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=730e14&_nc_ohc=bnlVZh4ab5kAX-e7wDn&_nc_ht=scontent.fdad3-5.fna&oh=00_AT_QJvZWGCcs5JSz0P-S-RRBA9MYdQJ_hD_o08_H-I5g9g&oe=6344EAC5"));
        arrayBanBe.add(new BanBe("HaiAnh Nguyen ", "Bạn bình thường", "https://scontent.fdad3-1.fna.fbcdn.net/v/t39.30808-6/310769670_3222132708116077_328760177504886418_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_ohc=iGIPktdDDqcAX_oaph4&_nc_ht=scontent.fdad3-1.fna&oh=00_AT-eY38orFQUo1Py5lsjM_srUWfRUqyEums10B3YHMTHkQ&oe=6345AC03"));
        arrayBanBe.add(new BanBe("Vo Thi Lanh", "Bạn bình thường", "https://scontent.fdad3-1.fna.fbcdn.net/v/t39.30808-6/310321768_3222132814782733_7777376421121292488_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=730e14&_nc_ohc=zm0Anip3ElAAX_jmN3W&_nc_ht=scontent.fdad3-1.fna&oh=00_AT_gxSke7akMcjZTlgSXdeAikNeo_vupvqa4acxizYRCuQ&oe=6345CED9"));
        arrayBanBe.add(new BanBe("Hồ Như Quý", "Bạn bình thường", "https://scontent.fdad3-5.fna.fbcdn.net/v/t39.30808-6/310481606_3222132801449401_8581064425520312443_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=730e14&_nc_ohc=P6Ju2CK9xUsAX-bYfcZ&_nc_ht=scontent.fdad3-5.fna&oh=00_AT9JkMcnA2Eo8SrlixWf_s-pt3TS6xIjcgw8GtBVd5BcBA&oe=6345C907"));
        arrayBanBe.add(new BanBe("Phạm Long Uyển", "Bạn bình thường", "https://scontent.fdad3-1.fna.fbcdn.net/v/t39.30808-6/310955352_3222132851449396_8304897346038473207_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_ohc=ZnI1m9_KdMYAX8rfqS_&_nc_ht=scontent.fdad3-1.fna&oh=00_AT9M1qZjQzteuMQVlNGOpti81hH3QFTCGb_Q7XTQgmNJqg&oe=63465E83"));
        arrayBanBe.add(new BanBe("Diệp Thanh Thảo", "Bạn bình thường", "https://scontent.fdad3-4.fna.fbcdn.net/v/t39.30808-6/310552443_3222132854782729_6337734897255003552_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=730e14&_nc_ohc=pktszs6U_I8AX_NLB9v&_nc_ht=scontent.fdad3-4.fna&oh=00_AT-oOkiNm5Bjkr8h_vRTAfpwPO1JY9fytDjgFIdFqyEy3A&oe=63452B70"));
        arrayBanBe.add(new BanBe("Thảo Quyên", "Bạn bình thường", "https://scontent.fdad3-4.fna.fbcdn.net/v/t39.30808-6/310502451_3222132674782747_8784540077542498660_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=730e14&_nc_ohc=7nr-pXEs9sAAX_TJbJz&_nc_ht=scontent.fdad3-4.fna&oh=00_AT_mZUTfBr2fTt3A-wV2MvwXAtaWocwi6kYcw65F0iEZhQ&oe=63463368"));
        arrayBanBe.add(new BanBe("Nguyễn Ngọc Nga", "Bạn bình thường", "https://scontent.fdad3-5.fna.fbcdn.net/v/t39.30808-6/310380973_3222132724782742_3766321947549458839_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=730e14&_nc_ohc=bnlVZh4ab5kAX-e7wDn&_nc_ht=scontent.fdad3-5.fna&oh=00_AT_QJvZWGCcs5JSz0P-S-RRBA9MYdQJ_hD_o08_H-I5g9g&oe=6344EAC5"));
        arrayBanBe.add(new BanBe("Nguyễn X.Trường", "Bạn bình thường", "https://scontent.fdad3-1.fna.fbcdn.net/v/t39.30808-6/311134061_3222132711449410_3106106576805907650_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_ohc=7lP2-XOK0pQAX9x1w7s&_nc_ht=scontent.fdad3-1.fna&oh=00_AT8MgOcs4yMOb3Q9T5TQC1rc85INXHMllsvD71x9zmbBcQ&oe=634567D0"));
        arrayBanBe.add(new BanBe("Lê Phan Hoàng Phúc", "Bạn bình thường", "https://scontent.fdad3-1.fna.fbcdn.net/v/t39.30808-6/310432585_3222132704782744_4707038704861313957_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_ohc=K4FxnOrR7DQAX9TFUw-&_nc_ht=scontent.fdad3-1.fna&oh=00_AT-EmNA8BLyYx8qSGAsMscz7biR8W-o9O_vLoWYngXOotg&oe=63463FB1"));
        arrayBanBe.add(new BanBe("Đặng Văn Luận", "Bạn bình thường", "https://scontent.fdad3-1.fna.fbcdn.net/v/t39.30808-6/310700281_3222132921449389_4822156104850775512_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_ohc=nBjUuido0OQAX-ARAAI&_nc_ht=scontent.fdad3-1.fna&oh=00_AT-0ZF9rBgbyRKn1chZOLPrGN6NyQaRPt0qu2FYX-9stBQ&oe=63457B43"));
        arrayBanBe.add(new BanBe("Mai Xuân Sơn", "Bạn bình thường", "https://scontent.fdad3-5.fna.fbcdn.net/v/t39.30808-6/310316631_3222132944782720_7197269212755851546_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=730e14&_nc_ohc=We07_5lapL8AX8WcUfn&_nc_ht=scontent.fdad3-5.fna&oh=00_AT8U0kssBy2iPrpK2XHAEnldL8YBvUbpR5txDqlKPv07-w&oe=6344ED19"));

        lvBanBe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, itemFragment).commit();

                Bundle bundle = new Bundle();
                bundle.putString("img", arrayBanBe.get(i).getHinh());
                bundle.putString("name", arrayBanBe.get(i).getTen());
                bundle.putString("description", arrayBanBe.get(i).getMoTa());

                ItemFragment itemFragment = new ItemFragment();
                itemFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, itemFragment).addToBackStack(null).commit();


            }
        });


        Adapter adapter = new BanBeAdapter(getContext(), R.layout.mucdobanbe, arrayBanBe);
        lvBanBe.setAdapter((ListAdapter) adapter);


        return view;
    }


}