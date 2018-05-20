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

public class DiscoFragment extends Fragment
{

    ArrayList<Place> placesList = new ArrayList<>();
    PlaceAdapter placeAdapter;

    public DiscoFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View returnView = inflater.inflate(R.layout.disco, container, false);

        placesList.add(new Place(getResources().getString(R.string.discoName1),getResources().getString(R.string.discoAdd1),getResources().getString(R.string.discoTel1),R.drawable.pepeneromilanocity, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.discoName2),getResources().getString(R.string.discoAdd2),getResources().getString(R.string.discoTel2),R.drawable.alcatraz, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.discoName3),getResources().getString(R.string.discoAdd3),getResources().getString(R.string.discoTel3),R.drawable.gattopardo, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.discoName4),getResources().getString(R.string.discoAdd4),getResources().getString(R.string.discoTel4),R.drawable.discotrammk, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.discoName5),getResources().getString(R.string.discoAdd5),getResources().getString(R.string.discoTel5),R.drawable.clubhaus80smilano, R.string.desc));

        ListView listView = (ListView) returnView.findViewById(R.id.discoList);
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