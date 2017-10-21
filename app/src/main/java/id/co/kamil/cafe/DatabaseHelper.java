package id.co.kamil.cafe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Irham on 10/21/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "cafe.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE =
            String.format("CREATE TABLE %s " +
                    "(%s INTEGER PRIMARY KEY, " +
                    "%s VARCHAR(10), " +
                    "%s INTEGER(1)," +
                    "%s VARCHAR(50)," +
                    "%s VARCHAR(10)," +
                    "%s VARCHAR(10))",
                    DatabaseContract.Pesanan.TABLE_NAME,
                    DatabaseContract.Pesanan._ID,
                    DatabaseContract.Pesanan.COL_TGL,
                    DatabaseContract.Pesanan.COL_MEJA,
                    DatabaseContract.Pesanan.COL_MENU,
                    DatabaseContract.Pesanan.COL_JAM,
                    DatabaseContract.Pesanan.COL_HARGA);

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "Creating Table : " + CREATE_TABLE);
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
