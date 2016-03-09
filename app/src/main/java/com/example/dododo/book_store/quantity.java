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
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

import java.util.List;


public class quantity extends ActionBarActivity {
    String title  , price , qnty , username_order ;
    EditText quantitay ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);
        quantitay = (EditText) findViewById(R.id.quant);

        Button OK = (Button) findViewById(R.id.OK);
        Intent i = getIntent();

           title  = (String) i.getExtras().get("title");
           price = (String) i.getExtras().get("price");
           username_order =(String) i.getExtras().get("usernameorders");

       OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quantity.this, orders.class);
                qnty = quantitay.getText().toString();

                posttask tsk = new posttask ();

                tsk.execute("http://192.168.47.239:8080/DSS/webresources/d.orders/"+title+"/"+price+"/"+qnty+"/"+username_order );
                intent.putExtra("usernamefororders", username_order);
                startActivity(intent);

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quantity, menu);
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
    class  posttask extends AsyncTask <String ,Void , String> {


        @Override
        protected String doInBackground(String... params) {

            String response = httpmanager.getdatafromurl(params[0]);
            //  HttpPost post = new HttpPost( "http://192.168.0.106:8080/WebApplication2/webresources/sssssssss.users/"+UN+PW+EM+PN );


            return null;

        }
    }
}
