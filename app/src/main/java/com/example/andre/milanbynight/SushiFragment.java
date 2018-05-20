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

public class SushiFragment extends Fragment {

    ArrayList<Place> placesList = new ArrayList<>();
    PlaceAdapter placeAdapter;

    public SushiFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View returnView = inflater.inflate(R.layout.sushi, container, false);

        placesList.add(  new Place(getResources().getString(R.string.sushiName1),getResources().getString(R.string.sushiAdd1),getResources().getString(R.string.sushitel1), R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.sushiName2),getResources().getString(R.string.sushiAdd2),getResources().getString(R.string.sushitel2), R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.sushiName3),getResources().getString(R.string.sushiAdd3),getResources().getString(R.string.sushitel3), R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.sushiName4),getResources().getString(R.string.sushiAdd4),getResources().getString(R.string.sushitel4),R.drawable.hana, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.sushiName5),getResources().getString(R.string.sushiAdd5),getResources().getString(R.string.sushitel5),R.drawable.moonkuzai, R.string.desc));

        ListView listView = (ListView) returnView.findViewById(R.id.sushiList);
        //listView.setAdapter(new PlaceAdapter(returnView.getContext(), placesList));
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