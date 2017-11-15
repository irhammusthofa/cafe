package id.co.kamil.cafe;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {
    private static final String TAG = "MainActivity";
    private List<Pesanan> listPesanan = new ArrayList<>();
    private ListView lstPesanan;
    private DatabaseHelper dbHelper;
    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstPesanan = (ListView) findViewById(R.id.listPesanan);
        dbHelper = new DatabaseHelper(this);
        txtInfo = (TextView) findViewById(R.id.txtinfo);

        final SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.execSQL("DELETE FROM " + DatabaseContract.Pesanan.TABLE_NAME);
        lstPesanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(M());
                alertDialog.setTitle("Hapus");
                alertDialog.setMessage(String.format("Apakah anda yakin akan menghapus data berikut : \nNo Meja : %s \n Menu : %s \nHarga Rp. %s",
                        listPesanan.get(position).getMeja(),listPesanan.get(position).getMenu(),listPesanan.get(position).getHarga()));
                alertDialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteRow(listPesanan.get(position).getId());
                    }
                });
                alertDialog.setNegativeButton("Tidak", null);
                alertDialog.show();*/
            }
        });
    }
    private void deleteRow(Integer id)
    {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " +
                DatabaseContract.Pesanan.TABLE_NAME +
                " WHERE " + DatabaseContract.Pesanan._ID + "=" + id
        );
        Toast.makeText(getApplicationContext(),"Data berhasil dihapus",Toast.LENGTH_SHORT).show();
        onResume();
    }
    @Override
    protected void onResume() {
        loadData();
        displayPesanan();
        super.onResume();
    }

    private void loadData(){
        listPesanan.clear();
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        final Cursor cursor = db.rawQuery(String.format(
                "SELECT * FROM %s ORDER BY %s", DatabaseContract.Pesanan.TABLE_NAME, DatabaseContract.Pesanan._ID
        ),null);

        if (cursor != null){
            try {
                if (cursor.moveToFirst()) {
                    do {
                        final Integer id = cursor.getInt(cursor.getColumnIndex(DatabaseContract.Pesanan._ID));
                        final String tgl = cursor.getString(cursor.getColumnIndex(DatabaseContract.Pesanan.COL_TGL));
                        final String jam = cursor.getString(cursor.getColumnIndex(DatabaseContract.Pesanan.COL_JAM));
                        final String meja = cursor.getString(cursor.getColumnIndex(DatabaseContract.Pesanan.COL_MEJA));
                        final String menu = cursor.getString(cursor.getColumnIndex(DatabaseContract.Pesanan.COL_MENU));
                        final String harga = cursor.getString(cursor.getColumnIndex(DatabaseContract.Pesanan.COL_HARGA));

                        final Pesanan pesanan = new Pesanan();
                        pesanan.setId(id);
                        pesanan.setTgl(tgl);
                        pesanan.setJam(jam);
                        pesanan.setMenu(menu);
                        pesanan.setMeja(meja);
                        pesanan.setHarga(harga);
                        Log.i(TAG,"Get data : "+pesanan.toString());
                        listPesanan.add(pesanan);
                    }while (cursor.moveToNext());
                    display(true);
                }else{
                    display(false);
                    //Toast.makeText(this, "Tidak ada data yang dapat ditampilkan", Toast.LENGTH_SHORT).show();
                }
            }finally {
                Log.i(TAG,"Cursor state : Close");
                cursor.close();
            }
        }
    }
    private void display(boolean bool){
        if (bool){
            txtInfo.setVisibility(View.GONE);
            lstPesanan.setVisibility(View.VISIBLE);
        }else{
            txtInfo.setVisibility(View.VISIBLE);
            txtInfo.setText("Tidak ada data meja yang memesan, silahkan lakukan transaksi.");
            lstPesanan.setVisibility(View.GONE);
        }
    }
    private void displayPesanan(){
        final PesananAdapter pesananAdapter = new PesananAdapter(this,listPesanan);
        lstPesanan.setAdapter(pesananAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnMenu:
                startActivity(new Intent(this,MenuActivity.class));
                break;
            case R.id.mnPesanan:
                Intent intent = new Intent(this,PemesananActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
