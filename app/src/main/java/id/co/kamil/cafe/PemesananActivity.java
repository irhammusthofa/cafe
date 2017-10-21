package id.co.kamil.cafe;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class PemesananActivity extends AppCompatActivity {
    private static final String TAG = "PemesananActivity";
    private EditText txtTgl;
    private EditText txtJam;
    private EditText txtMeja;
    private EditText txtMenu;
    private EditText txtHarga;
    private Button btnTambah;
    private Button btnMenu;
    private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);
        dbHelper = new DatabaseHelper(this);

        txtTgl = (EditText) findViewById(R.id.txtTgl);
        txtJam = (EditText) findViewById(R.id.txtJam);
        txtMenu = (EditText) findViewById(R.id.txtNamaMenu);
        txtMeja = (EditText) findViewById(R.id.txtMeja);
        txtHarga = (EditText) findViewById(R.id.txtHarga);
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnMenu = (Button) findViewById(R.id.btnMenu);

        String date = new java.text.SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String time = new java.text.SimpleDateFormat("HH:mm:ss").format(new Date());
        txtTgl.setText(date);
        txtJam.setText(time);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MenuActivity.class));
            }
        });
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SQLiteDatabase db = dbHelper.getWritableDatabase();

                final ContentValues values = new ContentValues();
                values.put(DatabaseContract.Pesanan.COL_TGL,txtTgl.getText().toString());
                values.put(DatabaseContract.Pesanan.COL_JAM,txtJam.getText().toString());
                values.put(DatabaseContract.Pesanan.COL_MEJA,txtMeja.getText().toString());
                values.put(DatabaseContract.Pesanan.COL_MENU,txtMenu.getText().toString());
                values.put(DatabaseContract.Pesanan.COL_HARGA,txtHarga.getText().toString());
                Log.i(TAG,"Insert data : " + values);
                db.insert(DatabaseContract.Pesanan.TABLE_NAME,null,values);

                Toast.makeText(getApplicationContext(),"Data berhasil disimpan",Toast.LENGTH_SHORT);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
