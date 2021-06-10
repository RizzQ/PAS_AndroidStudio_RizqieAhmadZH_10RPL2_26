package com.example.pas_androidstudio_rizqieahmadzh_10rpl2_26;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.MahasiswaViewHolder> {
    private Callback callback;
    private ArrayList<Siswa> dataList;
    int posku;
    View viewku;

    interface Callback {
        void onClick(int position);
    }

    public SiswaAdapter(ArrayList<Siswa> dataList, Callback callback) {
        this.callback = callback;
        this.dataList = dataList;
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_data, parent, false);
        // method ini gunanya untuk menghubungkan ke layout itemview
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaViewHolder holder, int position) {
        // 0 : Ani , 1 : Budi
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtJenjang.setText(dataList.get(position).getjenjang());
        holder.txtnomor_hp.setText(dataList.get(position).getnomor_hp());
        holder.txtemail.setText(dataList.get(position).getEmail());
    }

    // data nya berapa = 2, index 0 dan 1
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private TextView txtNama, txtJenjang, txtnomor_hp, txtemail;
        CardView cardku;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            viewku = itemView;
            itemView.setOnCreateContextMenuListener(this);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtJenjang = (TextView) itemView.findViewById(R.id.txt_jenjang_siswa);
            txtnomor_hp = (TextView) itemView.findViewById(R.id.txt_nomor_hp_mahasiswa);
            txtemail = (TextView) itemView.findViewById(R.id.txtemail);
            cardku = (CardView) itemView.findViewById(R.id.cardku);
            cardku.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            posku = getAdapterPosition();
            Edit.setOnMenuItemClickListener(onlickcontextmenu);
            Delete.setOnMenuItemClickListener(onlickcontextmenu);
        }
    }

    private final MenuItem.OnMenuItemClickListener onlickcontextmenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case 1:
                    //Delete data, butuh konfirmasi dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(viewku.getContext());
                    builder.setMessage("Are you sure you want to delete data?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dataList.remove(posku);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            //Set your icon here
                            .setTitle("Delete data")
                            .setIcon(R.mipmap.ic_launcher);
                    AlertDialog alert = builder.create();
                    alert.show();//showing the dialog

                    break;
            }
            return true;
        }
    };
}