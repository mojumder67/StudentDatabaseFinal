package studentdatabase.nayan.com.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nayan on 3/20/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Students.db";
    public static final  String TABLE_NAME = "student_table";
    public static final  String ID_1 = "ID";
    public static final  String NAME_2 = "NAME";
    public static final  String ID_NUMBER_3 = "ID NUMBER";
    public static final  String MOBILE_NUMBER_4 = "MOBILE NUMBER";
    public static final  String EMAIL_5 = "EMAIL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ID NUMBER TEXT, MOBILE NUMBER TEXT, EMAIL TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name, String idnumber, String mobilrnumber, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_2, name);
        contentValues.put(ID_NUMBER_3, idnumber);
        contentValues.put(MOBILE_NUMBER_4, mobilrnumber);
        contentValues.put(EMAIL_5, email);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
