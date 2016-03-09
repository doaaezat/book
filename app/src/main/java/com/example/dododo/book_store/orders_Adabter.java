package com.example.dododo.book_store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DoDo DO on 27/12/2015.
 */
public class orders_Adabter  extends ArrayAdapter <order_class> {
    List<order_class> listobj ;

    @Override
    public order_class getItem(int position) {
        return super.getItem(position);
    }

    order_class myorder ;
    TextView title , price , quntty ;
    private Context context ;

    public orders_Adabter(Context context, int resource, int textViewResourceId, List<order_class> objects) {
        super(context, resource, textViewResourceId, objects);
        listobj = objects ;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row =inflater.inflate(R.layout.item_order,parent,false);
        myorder = listobj.get(position);
        title = (TextView) row.findViewById(R.id.title_order);
        price = (TextView) row.findViewById(R.id.price_order);
        quntty = (TextView) row.findViewById(R.id.qnty_order);
        title.setText(myorder.getTitle());
        price.setText(myorder.getPrice());
        quntty.setText(myorder.getQnty());
        return row ;
    }
}
