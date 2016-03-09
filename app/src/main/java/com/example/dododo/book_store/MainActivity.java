package com.example.dododo.book_store;

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

import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {
public Button regist ;
public Button login ;

    String UN , PW ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     final EditText  username = (EditText) findViewById(R.id.editText2);
      final  EditText password = (EditText) findViewById(R.id.passfiled);
        regist= (Button) findViewById(R.id.registration);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registration.class);
                startActivity(intent);
            }
        });
        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            boolean d ;
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Book.class);
                UN = username.getText().toString();
                PW = password.getText().toString();
                intent.putExtra("user_name_order",UN);
                logintask task = new logintask();

                try {
                     d = task .execute("http://192.168.47.239:8080/WebApplication2/webresources/sssssssss.users").get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if (d == true ) {
                    startActivity(intent);
                    username.setText("");
                    password.setText("");
                }
                else {
                  Toast.makeText(getApplication(), "pleas enter valid data " ,Toast.LENGTH_LONG ).show();
                }
            }
        });
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
user user_object = new user ();
    public class logintask extends AsyncTask<String , String , Boolean> {


        @Override
        protected Boolean doInBackground(String... params) {
            String response = httpmanager.getdatafromurl(params[0]);
//            user_object = Jsonparse.get(response, search);
boolean result = false;
            result = Jsonparse.uservalidat(response,UN,PW);
            return result ;
        }

    }
}
