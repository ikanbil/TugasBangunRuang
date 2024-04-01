package com.example.tugasbangunruang.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tugasbangunruang.AdapterBangun;
import com.example.tugasbangunruang.R;
import com.example.tugasbangunruang.bangunDatar.lingkaran;
import com.example.tugasbangunruang.bangunDatar.persegi;
import com.example.tugasbangunruang.bangunDatar.persegiPanjang;
import com.example.tugasbangunruang.bangunDatar.segitiga;
import com.example.tugasbangunruang.modelbangun;

import java.util.ArrayList;
import java.util.List;

public class fragment_datar extends Fragment implements AdapterBangun.ItemClickListener {

    RecyclerView rvBangunDatar;
    List<modelbangun> listDataBangunDatar;
    AdapterBangun adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangunDatar = view.findViewById(R.id.rvBangun);
        listDataBangunDatar = new ArrayList<>();

        modelbangun persegi = new modelbangun();
        persegi.setNamaBangun("Persegi");
        persegi.setDesc("S x S ");
        persegi.setImageBangun("https://cdn0-production-images-kly.akamaized.net/gaLeVlmAVmjQc85Ib_SLhqBAtL8=/500x281/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/3409130/original/098589600_1616496130-persegi.jpg");
        listDataBangunDatar.add(persegi);

        modelbangun segitiga = new modelbangun();
        segitiga.setNamaBangun("Segitiga");
        segitiga.setDesc("L = 1/2 x a x t");
        segitiga.setImageBangun("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnih4CHiGuL-0FbGr9nvJJFGRV1EBYE3dRmg&usqp=CAU");
        listDataBangunDatar.add(segitiga);

        modelbangun PersegiPanjang = new modelbangun();
        PersegiPanjang.setNamaBangun("Persegi Panjang");
        PersegiPanjang.setDesc("P x L x T");
        PersegiPanjang.setImageBangun("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDG6u6wFaSceAsnbIzPJEPTLzeXlieKAQxzw&usqp=CAU");
        listDataBangunDatar.add(PersegiPanjang);

        modelbangun lingkaran = new modelbangun();
        lingkaran.setNamaBangun("Lingkaran");
        lingkaran.setDesc("Phi x r x r");
        lingkaran.setImageBangun("https://mamatematika.files.wordpress.com/2016/11/179.png");
        listDataBangunDatar.add(lingkaran);

        rvBangunDatar.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterBangun(listDataBangunDatar, getContext());
        rvBangunDatar.setAdapter(adapter);
        adapter.setClickListener(this);


    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapter.getItem(position).getNamaBangun().equals("Lingkaran")) {
            Intent intent = new Intent(getActivity(), lingkaran.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getNamaBangun().equals("Persegi")) {
            Intent intent = new Intent(getActivity(), persegi.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getNamaBangun().equals("Persegi Panjang")) {
            Intent intent = new Intent(getActivity(), persegiPanjang.class);
            startActivity(intent);
        }else if (adapter.getItem(position).getNamaBangun().equals("Segitiga")) {
            Intent intent = new Intent(getActivity(), segitiga.class);
            startActivity(intent);
        }
    }
}