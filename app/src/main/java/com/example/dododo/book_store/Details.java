package com.example.dododo.book_store;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Details extends ActionBarActivity {

    Button bton ;
    String usernameorder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
         final String title = (String) i.getExtras().get("bookname");
        String aouther = (String) i.getExtras().get("bookaouthor");
        String date = (String) i.getExtras().get("bookdate");
        final String price = (String) i.getExtras().get("bookprice");
        String type = (String) i.getExtras().get("booktybe");
         usernameorder = (String) i.getExtras().get("usernameorder");

        TextView Title , Aouther , Date ,Price ,Type ;
        Title = (TextView) findViewById(R.id.D_title);
        Title.setText(title);
        Aouther = (TextView) findViewById(R.id.D_author);
        Aouther.setText(aouther);
        Date = (TextView) findViewById(R.id.D_date);
        Date.setText(date);
        Price = (TextView) findViewById(R.id.D_price);
        Price.setText(price);
        Type = (TextView) findViewById(R.id.D_type);
        Type.setText(type);
        bton = (Button) findViewById(R.id.D_boutton);
        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Details.this, quantity.class);
                i.putExtra("title",title);
                i.putExtra("price", price);
                i.putExtra("usernameorders",usernameorder);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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
}
