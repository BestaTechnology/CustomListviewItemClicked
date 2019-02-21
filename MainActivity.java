package com.example.customlistviewpositionclicked;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;

    String[] item ={"Apple", "Mango","Banana","Guava","Strubary","Bitcoin","Bitcash","BitGold","Zcash",
            "Apple", "Mango","Banana","Guava","Strubary","Bitcoin","Bitcash","BitGold","Zcash"};

    int[] logo ={R.drawable.beets,R.drawable.cherries,R.drawable.gg,R.drawable.beets,R.drawable.cherries,R.drawable.gg
    ,R.drawable.beets,R.drawable.cherries,R.drawable.gg,R.drawable.beets,R.drawable.cherries,R.drawable.gg
    ,R.drawable.beets,R.drawable.cherries,R.drawable.gg,R.drawable.beets,R.drawable.cherries,R.drawable.gg};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAdapter adapter= new CustomAdapter(MainActivity.this,item,logo);
        listView =(ListView)findViewById(R.id.listview);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemvalues = (String)listView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),itemvalues,Toast.LENGTH_LONG).show();
            }
        });



    }

    class CustomAdapter extends ArrayAdapter<String> {

        private final Context context;
        private final String[] item;
        private final int[] logo;


        public CustomAdapter(Context context, String[] item, int[] logo) {


            super(context, R.layout.custom_layout, item);
            this.item = item;
            this.logo = logo;
            this.context = context;
        }
        // The getview method inflate the valuse given from the main activity from the custom design
        // and return the layout with inflated values in it

        public View getView(int position, View view, ViewGroup parent) {


            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.custom_layout, null, true);

            //Initilize the text  view and Image view that we declared in our custom layout resource file

            TextView textView = (TextView) rowView.findViewById(R.id.text_id);

            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);

            textView.setText(item[position]);

            imageView.setImageResource(logo[position]);


            return rowView;
        }


    }
    }


