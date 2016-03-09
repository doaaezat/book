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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Objects;


public class Book extends ActionBarActivity {

    ListView list ;
    List<Book_object> objects ;
    Context mcontext ;
     private Adabter  myadabtar ;
    String Username ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Intent intent = getIntent();
        Username = (String) intent.getExtras().get("user_name_order");
        list = (ListView) findViewById(R.id.listView);
        mcontext =this ;

        requestData("http://192.168.47.239:8080/book_store/webresources/ws.book");

         final EditText ser = (EditText) findViewById(R.id.search);
        ImageButton IMgboutton = (ImageButton) findViewById(R.id.imageButton);
        IMgboutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                Intent i = new Intent(Book.this, search.class);
               String action =  ser.getText().toString() ;
                if(!action.equals("")) {
                    i.putExtra("searchitem", action);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplication(), "pleas enter name of book  " ,Toast.LENGTH_LONG ).show();
                }
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Book_object objc = new Book_object();
                objc = myadabtar.getItem(position);

                Intent intent2 = new Intent(Book.this, Details.class);

                intent2.putExtra("bookid", objc.getId());
                intent2.putExtra("bookname", objc.getName());
                intent2.putExtra("bookaouthor", objc.getAuthor());
                intent2.putExtra("bookdate", objc.getDate());
                intent2.putExtra("bookprice", objc.getPrice());
                intent2.putExtra("booktybe", objc.getTybe());
                intent2.putExtra("usernameorder", Username);
                startActivity(intent2);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book, menu);

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
    public void requestData(String url ){

asynctask task = new asynctask();
        task.execute(url);
    }
    public class asynctask extends AsyncTask <String , String , List<Book_object>> {


        @Override
        protected List<Book_object> doInBackground(String... params) {
            String response = httpmanager.getdatafromurl(params[0]);
            objects = Jsonparse.GetBooks(response);


            return objects;
        }

        @Override
        protected void onPostExecute(List<Book_object> book_objects) {
            myadabtar = new Adabter(getApplication() , android.R.layout.simple_list_item_1 , R.id.text,book_objects) ;
            list .setAdapter(myadabtar);
        }
    }
}
