package com.kenyaweb.kenyawebapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by nabwera_taracha on 5/26/16.
 */
//public class PushFragment extends Fragment implements View.OnClickListener {
public class PushFragment extends Fragment {
    Button btn_find_us;

    public PushFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_push, container, false);
//        return inflater.inflate(R.layout.fragment_find_us, container, false);

//        btn_find_us=(Button) view.findViewById(R.id.btn_find_us);
//        btn_find_us.setOnClickListener(this);

        return view;
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_find_us:
//                Intent mapIntent = new Intent(getActivity(), MapsActivity.class);
//                startActivity(mapIntent);
//                break;
//
//
//        }
//    }

}
