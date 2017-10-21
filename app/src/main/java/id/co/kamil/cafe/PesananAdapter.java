package id.co.kamil.cafe;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Irham on 10/21/2017.
 */

public class PesananAdapter extends ArrayAdapter<Pesanan> {
    public PesananAdapter(@NonNull Context context, @NonNull List<Pesanan> objects) {
        super(context, R.layout.item_pesanan, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rooView = layoutInflater.inflate(R.layout.item_pesanan,parent,false);
        TextView txtTgl = (TextView) rooView.findViewById(R.id.txtTgl);
        TextView txtJam = (TextView) rooView.findViewById(R.id.txtJam);
        TextView txtMeja = (TextView) rooView.findViewById(R.id.txtMeja);
        TextView txtMenu = (TextView) rooView.findViewById(R.id.txtMenu);
        TextView txtHarga = (TextView) rooView.findViewById(R.id.txtHarga);

        final Pesanan pesanan = getItem(position);
        txtTgl.setText(pesanan.getTgl());
        txtJam.setText(pesanan.getJam());
        txtMeja.setText(pesanan.getMeja());
        txtMenu.setText(pesanan.getMenu());
        txtHarga.setText("Rp. " + String.format("%,.0f",Float.parseFloat(pesanan.getHarga())));

        return rooView;
    }
}
