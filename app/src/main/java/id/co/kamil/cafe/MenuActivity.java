package id.co.kamil.cafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private final String TAG = "MenuActivity";
    private List<DataMenu> list = new ArrayList<>();
    private ListView lstMenu;
    private DataMenu dataMenu;
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
        setContentView(R.layout.activity_menu);
        lstMenu = (ListView) findViewById(R.id.listMenu);
        lstMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final boolean pesan = getIntent().getBooleanExtra("pesan",false);
                Log.i(TAG,"pesan : " + pesan);
                if (pesan) {
                    Intent intent = new Intent();
                    intent.putExtra("index", position);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
        int i =0;
        for(i=0;i<8;i++){
            dataMenu= new DataMenu();
            dataMenu.setNama(nama[i]);
            dataMenu.setJenis(jenis[i]);
            dataMenu.setPenjelasan(penjelasan[i]);
            dataMenu.setHarga(harga[i]);
            list.add(dataMenu);
        }
        displayMenu();
    }
    private void displayMenu(){
        final MenuAdapter menuAdapter = new MenuAdapter(this,list);
        lstMenu.setAdapter(menuAdapter);
    }

}
