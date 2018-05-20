package com.example.andre.milanbynight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ResturantFragment extends Fragment
{

    ArrayList<Place> placesList = new ArrayList<>();
    PlaceAdapter placeAdapter;

    public ResturantFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View returnView = inflater.inflate(R.layout.resturant, container, false);

        placesList.add(new Place(getResources().getString(R.string.resName1),getResources().getString(R.string.resAdd1),getResources().getString(R.string.restel1),R.drawable.seta, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.resName2),getResources().getString(R.string.resAdd2),getResources().getString(R.string.restel2),R.drawable.guerrini, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.resName3),getResources().getString(R.string.resAdd3),getResources().getString(R.string.restel3),R.drawable.iyo, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.resName4),getResources().getString(R.string.resAdd4),getResources().getString(R.string.restel4),R.drawable.nero, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.resName5),getResources().getString(R.string.resAdd5),getResources().getString(R.string.restel5),R.drawable.sikelaia, R.string.desc));

        ListView listView = (ListView) returnView.findViewById(R.id.resturamtList);
        placeAdapter = new PlaceAdapter(returnView.getContext(), placesList);
        listView.setAdapter(placeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(getResources().getString(R.string.keyName), placesList.get(position).getName());
                intent.putExtra(getResources().getString(R.string.keyTel), placesList.get(position).getTel());
                intent.putExtra(getResources().getString(R.string.keyDesc), placesList.get(position).getDesc());
                intent.putExtra(getResources().getString(R.string.keyImage), placesList.get(position).getImageId());
                intent.putExtra(getResources().getString(R.string.keyAddress), placesList.get(position).getAddress());
                getActivity().startActivity(intent);
            }
        });

        return returnView;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        placeAdapter.clear();
    }
}
