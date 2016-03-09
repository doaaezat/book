package com.example.dododo.book_store;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class search extends ActionBarActivity {
    String search ;
    Book_object booksearch ;
    TextView Title , Aouther , Date ,Price ,Type ;
    String title , aouthe , date ,price ,tybe ;
    Button Button_search  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent i = getIntent();
        Button_search = (Button) findViewById(R.id.s_boutton);
        Button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(search.this, quantity.class);
                i.putExtra("title",title);
                i.putExtra("price", price);
                startActivity(i);
            }
        });
        search = (String) i.getExtras().get("searchitem");
       // Toast.makeText(getApplication(), "this is " + search ,Toast.LENGTH_LONG ).show();
 searchtask task = new searchtask() ;
        task.execute("http://192.168.47.239:8080/book_store/webresources/ws.book");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
    public class searchtask extends AsyncTask<String , String , Book_object > {


        @Override
        protected Book_object doInBackground(String... params) {
            String response = httpmanager.getdatafromurl(params[0]);
            booksearch = Jsonparse.getsearchbook(response, search);

            return booksearch;
        }

        @Override
        protected void onPostExecute(Book_object bok) {

                title = bok.getName();
                aouthe = bok.getAuthor();
                price = bok.getPrice();
                tybe = bok.getTybe();
                date = bok.getDate();

                Title = (TextView) findViewById(R.id.s_title);
                Title.setText(title);
                Aouther = (TextView) findViewById(R.id.s_author);
                Aouther.setText(aouthe);
                Date = (TextView) findViewById(R.id.s_date);
                Date.setText(date);
                Price = (TextView) findViewById(R.id.s_price);
                Price.setText(price);
                Type = (TextView) findViewById(R.id.s_type);
                Type.setText(tybe);
            }

        }
    }

