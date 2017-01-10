package com.kenyaweb.kenyawebapp;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.kenyaweb.kenyawebapp.services.Consultancy;
import com.kenyaweb.kenyawebapp.services.Internet;
import com.kenyaweb.kenyawebapp.services.LatestProducts;
import com.kenyaweb.kenyawebapp.services.MobileServices;
import com.kenyaweb.kenyawebapp.services.SEO;
import com.kenyaweb.kenyawebapp.services.SoftwareServices;
import com.kenyaweb.kenyawebapp.services.WebServices;

/**
 * Created by nabwera_taracha on 5/24/16.
 */
public class ProductFragment extends ListFragment implements AdapterView.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Products, R.layout.list_fragment_details);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
//        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();

        if (position == 0) {
            //code specific to first list item
            Intent webIntent = new Intent(view.getContext(), LatestProducts.class);
            startActivityForResult(webIntent, 0);

        }

        if (position == 1) {
            //code specific to first list item
            Intent myIntent = new Intent(view.getContext(), Internet.class);
            startActivityForResult(myIntent, 0);

        }

        if (position == 2) {
            //code specific to first list item
            Intent webIntent = new Intent(view.getContext(), WebServices.class);
            startActivityForResult(webIntent, 0);

        }

        if (position == 3) {
            //code specific to first list item
            Intent webIntent = new Intent(view.getContext(), SoftwareServices.class);
            startActivityForResult(webIntent, 0);

        }

        if (position == 4) {
            //code specific to first list item
            Intent webIntent = new Intent(view.getContext(), MobileServices.class);
            startActivityForResult(webIntent, 0);

        }

        if (position == 5) {
            //code specific to first list item
            Intent webIntent = new Intent(view.getContext(), SEO.class);
            startActivityForResult(webIntent, 0);

        }

        if (position == 6) {
            //code specific to first list item
            Intent webIntent = new Intent(view.getContext(), Consultancy.class);
            startActivityForResult(webIntent, 0);

        }

    }
}
