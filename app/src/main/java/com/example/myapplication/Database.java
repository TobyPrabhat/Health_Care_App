package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.Console;
import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text, email text, password text) ";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "create table cart(username text, product text, price float, orderType text)";
        sqLiteDatabase.execSQL(qry2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void registor(String username, String email, String password){
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }

    public int login(String username, String password){
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cq = db.rawQuery("select * from users where username=? and password=?", str);
        if(cq.moveToFirst()){
            result = 1;
        }
        return result;
    }

    public void addToCart(String username, String product, float price, String orderType){
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", product);
        cv.put("price", price);
        cv.put("orderType", orderType);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart", null, cv);
        db.close();
    }

    public int checkCart(String username, String product){
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cq = db.rawQuery("select * from cart where username = ? and product = ?", str);
        if(cq.moveToFirst()){
            result = 1;
        }
        db.close();
        return result;
    }

    public void removeCart(String username, String orderType){
        String str[] = new String[2];
        str[0] = username;
        str[1] = orderType;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "username = ? and orderType = ?", str);
        db.close();
    }

    public ArrayList getCartData(String username, String orderType){
        ArrayList<String> newArr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[2];
        str[0] = username;
        str[1] = orderType;
        Cursor cq = db.rawQuery("select * from cart where username = ? and orderType = ?", str);
        if(cq.moveToFirst()){
            do {
                String product = cq.getString(1);
                String price = cq.getString(2);
                newArr.add(product + "$" + price);
            }while (cq.moveToNext());
        }
        db.close();
        return newArr;
    }
}
