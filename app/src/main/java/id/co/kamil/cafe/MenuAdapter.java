package id.co.kamil.cafe;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Irham on 10/21/2017.
 */

public class MenuAdapter extends ArrayAdapter<DataMenu> {
    public MenuAdapter(@NonNull Context context, @NonNull List<DataMenu> objects) {
        super(context, R.layout.item_menu, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rooView = layoutInflater.inflate(R.layout.item_menu,parent,false);
        TextView txtJenis = (TextView) rooView.findViewById(R.id.txtJenis);
        TextView txtNama = (TextView) rooView.findViewById(R.id.txtNama);
        TextView txtPenjelasan = (TextView) rooView.findViewById(R.id.txtPenjelasan);
        TextView txtHarga = (TextView) rooView.findViewById(R.id.txtHarga);

        final DataMenu dataMenu = getItem(position);
        txtJenis.setText(dataMenu.getJenis());
        txtNama.setText(dataMenu.getNama());
        txtPenjelasan.setText(dataMenu.getPenjelasan());
        txtHarga.setText("Rp. " + String.format("%,.0f",Float.parseFloat(dataMenu.getHarga())));
        return rooView;
    }
}
