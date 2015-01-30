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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        private ArrayAdapter<String> mStoresAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] storesArray = {
                    "Tienda de Lego",
                    "Tienda de Libros",
                    "Tienda de Zapatos",
                    "Tienda de Ropa",
                    "Tienda de Vinos"
            };
            ArrayList<String> stores = new ArrayList<String>(
                    Arrays.asList(storesArray)
            );

            mStoresAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.list_stores,
                    R.id.list_item_store_textview,
                    stores
            );

            ListView listview = (ListView) rootView.findViewById(R.id.listview_store);
            listview.setAdapter(mStoresAdapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String aux = mStoresAdapter.getItem(position);
                    // Toast.makeText(getActivity(), aux ,Toast.LENGTH_SHORT).show()

                    Intent intent = new Intent(getActivity(),StoreDetail.class).putExtra(Intent.EXTRA_TEXT, aux);
                    startActivity(intent);
                }
            });

            return rootView;
        }
    }
}
