
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

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> get(int a) {
        List<String> list = new ArrayList<>();
        if (a == 2) {
            Cursor cursor = database.rawQuery("SELECT WORD FROM WORD_LIST WHERE TYPE=2", null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();

        }

        if (a == 1) {
            Cursor cursor = database.rawQuery("SELECT WORD FROM WORD_LIST WHERE TYPE=1", null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }
        if (a == 3) {
            Cursor cursor = database.rawQuery("SELECT WORD FROM WORD_LIST WHERE TYPE=3", null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }

        if (a == 4) {
            Cursor cursor = database.rawQuery("SELECT WORD FROM WORD_LIST WHERE TYPE=4", null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }
        if (a == 5) {
            Cursor cursor = database.rawQuery("SELECT MEANING FROM WORD_LIST", null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }


        return list;

    }


    public String des(int id, int test, String con) {
        String hi = "";
        String my="SELECT MEANING FROM WORD_LIST WHERE WORD="+con;

        if (test==5) {
            Cursor k = database.rawQuery("SELECT WORD FROM WORD_LIST", null);
            if (k.moveToFirst()) {
                k.moveToPosition(id);
                hi = k.getString(0);
                k.moveToNext();
            }
            k.close();


        }


        else {
            Cursor cursor = database.rawQuery("SELECT MEANING FROM WORD_LIST WHERE WORD ='"+con+"'" ,null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                hi=(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hi;

    }

}




