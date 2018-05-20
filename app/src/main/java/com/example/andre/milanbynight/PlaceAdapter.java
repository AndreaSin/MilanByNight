package com.example.andre.milanbynight;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class PlaceAdapter extends ArrayAdapter<Place>
{
    class ViewHolder
    {
        ImageView image;
        TextView name ;
        TextView address;
        TextView tel;
    }

    public PlaceAdapter(Context context, ArrayList<Place> placesArrayList)
    {
        super(context, R.layout.list_item, placesArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Place place = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.address = (TextView) convertView.findViewById(R.id.address);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.tel =(TextView) convertView.findViewById(R.id.tel);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(place.getName());
        viewHolder.address.setText(place.getAddress());
        viewHolder.image.setImageResource(place.getImageId());
        viewHolder.tel.setText(place.getTel());
        return convertView;
    }
}