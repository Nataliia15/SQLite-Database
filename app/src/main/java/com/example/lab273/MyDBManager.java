package com.example.lab273;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyDBManager {
    //private Context context;
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;

    public MyDBManager(Context context) {
        this.myDBHelper=new MyDBHelper(context);
       // this.context = context;
    }
    public void openDB(){
        db=myDBHelper.getWritableDatabase();
    }
    public void insertToDB(String name,String lastName){
        //db=myDBHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MyConstants.ConstantsOfNames.COLUMN_NAME,name);
        values.put(MyConstants.ConstantsOfNames.CULUMN_LAST_NAME,lastName);
        db.insert(MyConstants.ConstantsOfNames.TABLE_NAME,null,values);
    }
    public List<String>readFromDB(){
        List<String>listOfPersons=new ArrayList<>();
        Cursor cursor=db.query(MyConstants.ConstantsOfNames.TABLE_NAME,null,null,null,null,null,null);
while (cursor.moveToNext()){
    String person=cursor.getString(cursor.getColumnIndex(MyConstants.ConstantsOfNames.COLUMN_NAME))+" "+cursor.getString(cursor.getColumnIndex(MyConstants.ConstantsOfNames.CULUMN_LAST_NAME));
    listOfPersons.add(person);

    
}cursor.close();
        return listOfPersons;
    }
    public void removeItem(String name,String lastName) {
        db = myDBHelper.getWritableDatabase();
        String queryString = "DELETE FROM " + MyConstants.ConstantsOfNames.TABLE_NAME + " WHERE " + MyConstants.ConstantsOfNames.COLUMN_NAME + " LIKE " +"'"+name+"'"+" AND "+MyConstants.ConstantsOfNames.CULUMN_LAST_NAME + " LIKE " +"'"+lastName+"'";
        db.execSQL(queryString);

    }

    public void closeDB() {
        db.close();
    }
}

