package com.example.andre.milanbynight;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Bundle extras = getIntent().getExtras();
        final String name = extras.getString(getResources().getString(R.string.keyName));
        final String address = extras.getString(getResources().getString(R.string.keyAddress));
        String tel = extras.getString(getResources().getString(R.string.keyTel));
        int desc = extras.getInt(getResources().getString(R.string.keyDesc));
        int image = extras.getInt(getResources().getString(R.string.keyImage));

        TextView nameView = (TextView)findViewById(R.id.name);
        TextView telView = (TextView)findViewById(R.id.tel);
        TextView descView = (TextView)findViewById(R.id.desc);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        TextView addressView = (TextView)findViewById(R.id.address);
        nameView.setText(name);
        telView.setText(tel);
        descView.setText(desc);
        imageView.setImageResource(image);
        addressView.setText(address);
        addressView.setPaintFlags(addressView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        ViewGroup map = (ViewGroup) findViewById(R.id.layoutMap);
        map.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse(getResources().getString(R.string.googleMapUr) + name + " " + address);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(getResources().getString(R.string.googleMapSet));
                startActivity(mapIntent);
            }
        });
    }
}
