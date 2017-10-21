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
    private String[] nama = {"Kopi Hitam","Cappuccino","Sparkling Tea","Batagor","Cireng","Nasi Goreng","Cheese Cake","Black Salad"};
    private String[] jenis = {"Minuman","Minuman","Minuman","Makanan","Makanan","Makanan","Dessert","Dessert"};
    private String[] harga = {"10000","20000","15000","25000","10000","50000","40000","30000"};
    private String[] penjelasan = {"Kopi Hitam dengan dibuat dengan teknik espresso, dimana biji kopi yang diguanakn yaitu berasal dari Aceh Gayo jenis Arabika, disajikan dengan gula terpisah",
            "Paduan Kopi dengan buih susu kental serta menggunakan sirup karamel, dimana biji kopi yang digunakan berasal dari Gunung Puntang Jawa Barat jenis Robusta",
            "Minuman teh yang menggunakan daun teh dari pegunungan daerah garut dengan tambahan sari melati asli dan gula merah alami",
            "Baso dan Tahu goreng dengan sajian bumbu kacang dan kecap khas bandung",
            "Makann ringan berupa tepung kenji goreng isi bahan dasar tempe fermentasi yang disebut oncom, disajikan dengan bumbu kacang pedas",
            "Nasi goreng ayam yang disajikan dengan telur mata sapi disertai satai ayam",
            "Kue Tart 1 dlice dengan bahan utama cream cgeese dengan topping buah-buahan asli seperti anggur, jeruk, kiwi",
            "Potongan buah-buah segar yang terdiri dari Pepaya, Jambu, melon, dan mangga disajikan dengan bumbu rujak kacang pedas dan gula merah."};

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
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                intent.putExtra("pesan",true);
                startActivityForResult(intent,1);
            }
        });
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String tmpmeja = txtMeja.getText().toString();
                final String tmpmenu = txtMenu.getText().toString();
                final String tmpharga = txtHarga.getText().toString();

                if (tmpmeja.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Maaf, Nomor Meja masih kosong",Toast.LENGTH_SHORT).show();
                }else if (tmpmenu.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Maaf, Nama Menu masih kosong",Toast.LENGTH_SHORT).show();;
                }else{
                    if(tmpharga.isEmpty()){
                        txtHarga.setText("0");
                    }

                    final SQLiteDatabase db = dbHelper.getWritableDatabase();
                    final ContentValues values = new ContentValues();
                    values.put(DatabaseContract.Pesanan.COL_TGL,txtTgl.getText().toString());
                    values.put(DatabaseContract.Pesanan.COL_JAM,txtJam.getText().toString());
                    values.put(DatabaseContract.Pesanan.COL_MEJA,txtMeja.getText().toString());
                    values.put(DatabaseContract.Pesanan.COL_MENU,txtMenu.getText().toString());
                    values.put(DatabaseContract.Pesanan.COL_HARGA,txtHarga.getText().toString());
                    Log.i(TAG,"Insert data : " + values);
                    db.insert(DatabaseContract.Pesanan.TABLE_NAME,null,values);

                    Toast.makeText(getApplicationContext(),"Data berhasil disimpan",Toast.LENGTH_SHORT).show();;
                    finish();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                int index = data.getIntExtra("index",0);
                Log.i(TAG,"Result Index : " + index);
                txtMenu.setText(nama[index]);
                txtHarga.setText(harga[index]);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
