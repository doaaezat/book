package com.example.dododo.book_store;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DoDo DO on 23/12/2015.
 */
public class Adabter extends ArrayAdapter <Book_object>{
    List <Book_object>  listobj ;



    @Override
    public Book_object getItem(int position) {
        return super.getItem(position);
    }

    Book_object mybook ;
    TextView title , author ;
    private Context context ;

    public Adabter(Context context, int resource, int textViewResourceId, List<Book_object> objects) {
        super(context, resource, textViewResourceId, objects);
        listobj = objects ;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row =inflater.inflate(R.layout.book_item,parent,false);
        mybook = listobj.get(position);
        title = (TextView) row.findViewById(R.id.title);
        author = (TextView) row.findViewById(R.id.author);
        title.setText(mybook.getName());
        author.setText(mybook.getAuthor());
        return row ;
    }
}
