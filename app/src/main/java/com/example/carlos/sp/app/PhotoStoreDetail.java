package com.example.carlos.sp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class PhotoStoreDetail extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_store_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo_store_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_photo_store_detail, container, false);

            Intent intent =getActivity().getIntent();
            String store = intent.getStringExtra(Intent.EXTRA_TEXT);

            int index;
            int image = 0;
            switch(store) {
                case "Tienda de Lego":
                    image = R.drawable.lego;
                    break;
                case "Tienda de Libros":
                    image = R.drawable.libros;
                    break;
                case "Tienda de Zapatos":
                    image = R.drawable.zapatos;
                    break;
                case "Tienda de Ropa":
                    image = R.drawable.ropa;
                    break;
                default:
                    image = R.drawable.vinos;
                    break;
            }
            ((TextView) rootView.findViewById(R.id.store_photo_name)).setText(store);
            ((ImageView) rootView.findViewById(R.id.image_store)).setImageResource(image);


            return rootView;
        }
    }
}
