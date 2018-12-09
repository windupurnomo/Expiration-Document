package com.zcodegroup.expireddocument.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.zcodegroup.expireddocument.model.Document;

/**
 * Created by windupurnomo on 3/2/17.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "ExpiredDocument";
    private final static String TABLE_DOCUMENT = "ExpiredDocument";
    private final static String KEY_ID = "id";
    private final static String KEY_COMPANY = "company";
    private final static String KEY_PRODUCT = "product";
    private final static String KEY_EXPIRED = "expired";


    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_DOCUMENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_COMPANY + " TEXT,"
                + KEY_PRODUCT + " TEXT,"
                + KEY_EXPIRED + " NUMBER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOCUMENT);
        onCreate(db);
    }

    void addDocument(Document contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, contact.getId());
        values.put(KEY_COMPANY, contact.getCompany());
        values.put(KEY_PRODUCT, contact.getProduct());
        values.put(KEY_EXPIRED, contact.getExpired().getTime());
        db.insert(TABLE_DOCUMENT, null, values);
        db.close(); // Closing database connection
    }


}
