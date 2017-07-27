
/**
 * Created by vikram on 14/7/17.
 */

package com.grehotwordsgrouped;

        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;

        import static android.R.id.list;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;


    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }


    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<String> get(int a) {
        List<String> list = new ArrayList<>();

            Cursor cursor = database.rawQuery("SELECT WORD FROM WORD_LIST WHERE TYPE='"+ a +"'", null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();




        if (a == 5) {
            Cursor curso = database.rawQuery("SELECT MEANING FROM WORD_LIST", null);

            curso.moveToFirst();
            while (!curso.isAfterLast()) {
                list.add(curso.getString(0));
                curso.moveToNext();
            }
            curso.close();
        }


        return list;

    }


    public String des(int id, int test, String con) {
        String hi = "";
        if (test == 5) {
            Cursor k = database.rawQuery("SELECT WORD FROM WORD_LIST", null);
            if (k.moveToFirst()) {
                k.moveToPosition(id);
                hi = k.getString(0);
                k.moveToNext();
            }
            k.close();


        } else {
            Cursor cursor = database.rawQuery("SELECT MEANING FROM WORD_LIST WHERE WORD ='" + con + "'", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                hi = (cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }

        return hi;

    }

    public String ex(String con,int test) {
        String hi = "";
        if(test==5){
        Cursor cursor = database.rawQuery("SELECT SENTENCE FROM WORD_LIST WHERE MEANING ='" + con + "'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            hi = (cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();}
        else
        {
            Cursor cursor = database.rawQuery("SELECT SENTENCE FROM WORD_LIST WHERE WORD ='" + con + "'", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                hi = (cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }

        return hi;

    }
}











