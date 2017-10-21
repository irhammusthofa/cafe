package id.co.kamil.cafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private final String TAG = "MenuActivity";
    private List<DataMenu> list = new ArrayList<>();
    private ListView lstMenu;
    private DataMenu dataMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lstMenu = (ListView) findViewById(R.id.listMenu);

        dataMenu= new DataMenu();
        dataMenu.setNama("Kopi Hitam");
        dataMenu.setJenis("Minuman");
        dataMenu.setPenjelasan("Kopi Hitam dengan dibuat dengan teknik espresso, dimana biji kopi yang diguanakn yaitu berasal dari Aceh Gayo jenis Arabika, disajikan dengan gula terpisah");
        dataMenu.setHarga("10.000");
        list.add(dataMenu);

        dataMenu= new DataMenu();
        dataMenu.setNama("Cappuccino");
        dataMenu.setJenis("Minuman");
        dataMenu.setPenjelasan("Paduan Kopi dengan buih susu kental serta menggunakan sirup karamel, dimana biji kopi yang digunakan berasal dari Gunung Puntang Jawa Barat jenis Robusta");
        dataMenu.setHarga("20.000");
        list.add(dataMenu);

        dataMenu= new DataMenu();
        dataMenu.setNama("Sparkling Tea");
        dataMenu.setJenis("Minuman");
        dataMenu.setPenjelasan("Minuman teh yang menggunakan daun teh dari pegunungan daerah garut dengan tambahan sari melati asli dan gula merah alami");
        dataMenu.setHarga("15.000");
        list.add(dataMenu);

        dataMenu= new DataMenu();
        dataMenu.setNama("Batagor");
        dataMenu.setJenis("Makanan");
        dataMenu.setPenjelasan("Baso dan Tahu goreng dengan sajian bumbu kacang dan kecap khas bandung");
        dataMenu.setHarga("25.000");
        list.add(dataMenu);

        dataMenu= new DataMenu();
        dataMenu.setNama("Cireng");
        dataMenu.setJenis("Makanan");
        dataMenu.setPenjelasan("Makann ringan berupa tepung kenji goreng isi bahan dasar tempe fermentasi yang disebut oncom, disajikan dengan bumbu kacang pedas");
        dataMenu.setHarga("10.000");
        list.add(dataMenu);

        dataMenu= new DataMenu();
        dataMenu.setNama("Nasi Goreng");
        dataMenu.setJenis("Makanan");
        dataMenu.setPenjelasan("Nasi goreng ayam yang disajikan dengan telur mata sapi disertai satai ayam");
        dataMenu.setHarga("50.000");
        list.add(dataMenu);

        dataMenu= new DataMenu();
        dataMenu.setNama("Cheese Cake");
        dataMenu.setJenis("Dessert");
        dataMenu.setPenjelasan("Kue Tart 1 dlice dengan bahan utama cream cgeese dengan topping buah-buahan asli seperti anggur, jeruk, kiwi");
        dataMenu.setHarga("40.000");
        list.add(dataMenu);

        dataMenu= new DataMenu();
        dataMenu.setNama("Black Salad");
        dataMenu.setJenis("Dessert");
        dataMenu.setPenjelasan("Potongan buah-buah segar yang terdiri dari Pepaya, Jambu, melon, dan mangga disajikan dengan bumbu rujak kacang pedas dan gula merah.");
        dataMenu.setHarga("30.000");
        list.add(dataMenu);

        displayMenu();
    }
    private void displayMenu(){
        final MenuAdapter menuAdapter = new MenuAdapter(this,list);
        lstMenu.setAdapter(menuAdapter);
    }

}
