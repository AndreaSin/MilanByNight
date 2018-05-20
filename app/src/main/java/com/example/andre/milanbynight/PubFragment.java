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

public class PubFragment extends Fragment {

    ArrayList<Place> placesList = new ArrayList<>();
    PlaceAdapter placeAdapter;

    public PubFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View returnView = inflater.inflate(R.layout.pub, container, false);

        placesList.add(new Place(getResources().getString(R.string.pubName1),getResources().getString(R.string.pubAdd1),getResources().getString(R.string.pubTel1),R.drawable.backdoor43, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.pubName2),getResources().getString(R.string.pubAdd2), getResources().getString(R.string.pubTel2),R.drawable.bfree, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.pubName3),getResources().getString(R.string.pubAdd3) ,getResources().getString(R.string.pubTel3),R.drawable.chiesetta, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.pubName4),getResources().getString(R.string.pubAdd4) ,getResources().getString(R.string.pubTel4),R.drawable.monkey, R.string.desc));
        placesList.add(new Place(getResources().getString(R.string.pubName5),getResources().getString(R.string.pubAdd5), getResources().getString(R.string.pubTel5),R.drawable.moscow, R.string.desc));
        ListView listView = (ListView) returnView.findViewById(R.id.pubList);
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