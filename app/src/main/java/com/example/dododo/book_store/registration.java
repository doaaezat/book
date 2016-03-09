package com.example.dododo.book_store;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;


public class registration extends ActionBarActivity {
public Button submit ;
    public EditText username;
    public EditText password;
    public EditText email;
    public EditText phone;
    String  UN, PW ,EM , PN ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
       username = (EditText) findViewById(R.id.usre_name_filed) ;
        password= (EditText) findViewById(R.id.pass_filed);
        email = (EditText)findViewById(R.id.email_filed) ;
        phone = (EditText) findViewById(R.id.phone_filed);

       submit = (Button) findViewById(R.id.submit_regestration);
        Intent intent = getIntent();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UN = username.getText().toString();
                PW = password.getText().toString();
                EM = email.getText().toString();
                PN= phone.getText().toString();
             task tsk = new task ();
                tsk.execute("http://192.168.47.239:8080/WebApplication2/webresources/sssssssss.users/"+UN+"/"+PW+"/"+EM+"/"+PN );
                Toast.makeText(getApplication(), " NOW LOGIN " ,Toast.LENGTH_LONG ).show();
                Intent i = new Intent(registration.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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

 class  task extends AsyncTask <String ,Void , String> {
     ProgressDialog prgDialog;

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

