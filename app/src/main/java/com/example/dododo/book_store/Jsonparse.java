package com.example.dododo.book_store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DoDo DO on 24/12/2015.
 */
public class Jsonparse {
    public static List<Book_object> GetBooks ( String objects){


        try {
            JSONArray array = new JSONArray(objects);
            List<Book_object> list_of_objcets = new ArrayList<Book_object>();
            for (int i = 0 ; i<array.length() ; i++){

                JSONObject obj = array.getJSONObject(i);
                Book_object my_Book_object = new Book_object();
                my_Book_object.setId(obj.getInt("id"));
                my_Book_object.setName(obj.getString("name"));
                my_Book_object.setAuthor(obj.getString("aouther"));
                my_Book_object.setDate(obj.getString("publicatuonDate"));
                my_Book_object.setPrice(obj.getString("price"));
                my_Book_object.setTybe(obj.getString("type"));

                list_of_objcets.add(my_Book_object);
            }
            return list_of_objcets ;
        } catch (JSONException e) {
            e.printStackTrace();
            return null ;
        }
    }
    public  static Book_object getsearchbook (String data , String search_item ){
        Book_object obj = new Book_object() ;
        try {
            JSONArray array = new JSONArray(data);
            List<Book_object> list = new ArrayList<Book_object>();
            for (int i = 0 ; i<array.length() ; i++){

                JSONObject objec = array.getJSONObject(i);
                Book_object my_Book_object = new Book_object();
                my_Book_object.setId(objec.getInt("id"));
                my_Book_object.setName(objec.getString("name"));
                my_Book_object.setAuthor(objec.getString("aouther"));
                my_Book_object.setDate(objec.getString("publicatuonDate"));
                my_Book_object.setPrice(objec.getString("price"));
                my_Book_object.setTybe(objec.getString("type"));

                list.add(my_Book_object);
            }

            for (int j =0 ;j<list.size();j++){
                if(search_item.equals(list.get(j).getName())){
                    obj.setId(list.get(j).getId());
                    obj.setName(list.get(j).getName());
                    obj.setAuthor(list.get(j).getAuthor());
                    obj.setDate(list.get(j).getDate());
                    obj.setTybe(list.get(j).getTybe());
                    obj.setPrice(list.get(j).getPrice());

                }

            }
            return obj ;
        } catch (JSONException e) {
            e.printStackTrace();
            return null ;
        }

    }
    public  static boolean uservalidat (String data , String username , String password  ) {

       boolean res = false;
        try {
            JSONArray array = new JSONArray(data);
            List<user> list = new ArrayList<user>();
            for (int i = 0; i < array.length(); i++) {

                JSONObject objec = array.getJSONObject(i);
                user userobject = new user();
                userobject.setId(objec.getInt("id"));
                userobject.setUsername(objec.getString("userName"));
                userobject.setPassword(objec.getString("password"));
                userobject.setEmail(objec.getString("email"));
                userobject.setPhone(objec.getString("phone"));

                list.add(userobject);
            }

            for (int k= 0; k < list.size(); k++) {
                if (username.equals(list.get(k).getUsername())& password.equals(list.get(k).getPassword())) {
                        res = true;

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();

        }
return  res ;
    }


    public static List<order_class> Getorders ( String objects){


        try {
            JSONArray array = new JSONArray(objects);
            List<order_class> list_of_objcets = new ArrayList<order_class>();
            for (int i = 0 ; i<array.length() ; i++){

                JSONObject obj = array.getJSONObject(i);
                order_class my_order_object = new order_class();
                my_order_object.setTitle(obj.getString("name"));
                my_order_object.setPrice(obj.getString("price"));
                my_order_object.setQnty(obj.getString("qnty"));


                list_of_objcets.add(my_order_object);
            }
            return list_of_objcets ;
        } catch (JSONException e) {
            e.printStackTrace();
            return null ;
        }
    }
}
