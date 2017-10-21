package id.co.kamil.cafe;

import android.provider.BaseColumns;

/**
 * Created by Irham on 10/21/2017.
 */

public class DatabaseContract{
    public class Pesanan implements BaseColumns{
        public static final String TABLE_NAME = "pesanan";
        public static final String COL_TGL = "tgl";
        public static final String COL_JAM = "jam";
        public static final String COL_MEJA = "meja";
        public static final String COL_MENU = "menu";
        public static final String COL_HARGA = "harga";
    }
}
