package com.example.dododo.book_store;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


public class orders extends ActionBarActivity {
String username ;
    ListView list ;
    orders_Adabter myababter ;
    Context mcontext ;
    List<order_class> objects ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        list = (ListView) findViewById(R.id.listView2);


        Intent i = new Intent();
        i = getIntent() ;
        username = (String) i.getExtras().get("usernamefororders");
        ordedrtask task = new ordedrtask();

        task.execute("http://192.168.47.239:8080/DSS/webresources/d.orders/select/"+username);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                order_class objc = new order_class();
                objc =myababter.getItem(position);

                Intent intent2 = new Intent(orders.this, selectopt.class);

                intent2.putExtra("qnty", objc.getQnty());
                intent2.putExtra("title", objc.getTitle());
                intent2.putExtra("username", username);

                startActivity(intent2);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_orders, menu);
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
    public class ordedrtask extends AsyncTask<String , String , List<order_class>> {


        @Override
        protected List<order_class> doInBackground(String... params) {
            String response = httpmanager.getdatafromurl(params[0]);
            objects = Jsonparse.Getorders(response);


            return objects;
        }

        @Override
        protected void onPostExecute(List<order_class> order_objects) {
            myababter = new orders_Adabter(getApplication() , android.R.layout.simple_list_item_1 , R.id.text,order_objects) ;
            list .setAdapter(myababter);
        }
    }
}
