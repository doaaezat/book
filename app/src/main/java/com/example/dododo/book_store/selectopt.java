package com.example.dododo.book_store;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


public class selectopt extends ActionBarActivity {
    String username;
    String title;
    String qnty;
    Button update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectopt);

        update = (Button) findViewById(R.id.update);
        Intent i = getIntent();
        username = (String) i.getExtras().get("username");
        title = (String) i.getExtras().get("title");
        qnty = (String) i.getExtras().get("qnty");
        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectopt.this, update_quantity.class);


                startActivity(intent);
            }
        });
        delete = (Button) findViewById(R.id.deletet);

        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                deletetask tssk = new deletetask ();

//                tsk.execute("http://192.168.0.106:8080/DSS/webresources/d.orders/delete/"+title+"/"+username);
                Intent doaa = new Intent(selectopt.this, orders.class);
                doaa.putExtra("usernamefororders", username);
                doaa.putExtra ("title",title);
//                deletetask tsk = new deletetask ();
//http://localhost:8080/DSS/webresources/d.orders/delete/%7Bname%7D/%7Busername%7D
                tssk.execute("http://192.168.47.239:8080/DSS/webresources/d.orders/"+title+"/"+username);

                startActivity(doaa);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selectopt, menu);
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

    class deletetask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {
//         HttpClient httpClient = new DefaultHttpClient();
//         HttpContext localContext = new BasicHttpContext();
//         HttpResponse response;
//         JSONObject json = new JSONObject();
//         "http://192.168.0.106:8080/WebApplication2/webresources/sssssssss.users/"+UN+PW+EM+PN ;
            String response = httpmanager.getdatafromurl(params[0]);
            //  HttpPost post = new HttpPost( "http://192.168.0.106:8080/WebApplication2/webresources/sssssssss.users/"+UN+PW+EM+PN );


            return null;

        }
    }
}