package com.nuansa.uas.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nuansa.uas.DetailBerita;
import com.nuansa.uas.R;
import com.nuansa.uas.models.Berita;

import java.util.List;


public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>{
    private Context context;
    private List<Berita> listBerita;

    public BeritaAdapter(Context context, List<Berita> listBerita) {
        this.context = context;
        this.listBerita = listBerita;
    }

    @Override
    public BeritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita,parent,false);
        return new BeritaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeritaViewHolder holder, int position) {
        final Berita berita = listBerita.get(position);
        holder.judulBerita.setText(berita.getJudul());
        holder.judulBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), berita.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DetailBerita.class);
                i.putExtra("BeritaId", berita.getId());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    public class BeritaViewHolder extends RecyclerView.ViewHolder {
        public TextView judulBerita;
        public BeritaViewHolder(View itemView) {
            super(itemView);
            judulBerita = (TextView) itemView.findViewById(R.id.judulBerita);
        }
    }
}
