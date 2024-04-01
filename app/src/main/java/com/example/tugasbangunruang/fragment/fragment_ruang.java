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
import com.example.tugasbangunruang.bangunRuang.balok;
import com.example.tugasbangunruang.bangunRuang.bola;
import com.example.tugasbangunruang.bangunRuang.kubus;
import com.example.tugasbangunruang.bangunRuang.tabung;
import com.example.tugasbangunruang.modelbangun;

import java.util.ArrayList;
import java.util.List;

public class fragment_ruang extends Fragment implements AdapterBangun.ItemClickListener  {

    RecyclerView rvBangun;
    List<modelbangun> modelbangunList;
    AdapterBangun adapterBangun;

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
        return inflater.inflate(R.layout.fragment_ruang, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangun = view.findViewById(R.id.rvBangunRuang);
        modelbangunList = new ArrayList<>();

        modelbangun kubus = new modelbangun();
        kubus.setNamaBangun("Kubus");
        kubus.setDesc("6 x s²");
        kubus.setImageBangun("data:image/png;base64,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");
        modelbangunList.add(kubus);

        modelbangun bola = new modelbangun();
        bola.setNamaBangun("Bola");
        bola.setDesc("Luas Permukaan Bola = 4 x Luas Lingkaran (π x r²)");
        bola.setImageBangun("data:image/jpeg;base64,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");
        modelbangunList.add(bola);

        modelbangun tabung = new modelbangun();
        tabung.setNamaBangun("Tabung");
        tabung.setDesc("Luas permukaan tabung = 2 x Luas alas + Luas selimut tabung");
        tabung.setImageBangun("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIDhJ9RqfItL6nBvPAUi6wGeeorm-zgBtFVQ&usqp=CAU");
        modelbangunList.add(tabung);

        modelbangun balok = new modelbangun();
        balok.setNamaBangun("Balok");
        balok.setDesc("L = 2 x [(p x l) + (p x t) + (l x t)]");
        balok.setImageBangun("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQpShzzkFiybZIEd2D1RRhTwoS27J6OheUXp1Vs3nDovCML9kpI");
        modelbangunList.add(balok);

        rvBangun.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterBangun = new AdapterBangun(modelbangunList, getContext());
        rvBangun.setAdapter(adapterBangun);
        adapterBangun.setClickListener(this);


    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapterBangun.getItem(position).getNamaBangun().equals("Balok")) {
            Intent intent = new Intent(getActivity(), balok.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getNamaBangun().equals("Bola")) {
            Intent intent = new Intent(getActivity(), bola.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getNamaBangun().equals("Kubus")) {
            Intent intent = new Intent(getActivity(), kubus.class);
            startActivity(intent);
        }else if (adapterBangun.getItem(position).getNamaBangun().equals("Tabung")) {
            Intent intent = new Intent(getActivity(), tabung.class);
            startActivity(intent);
        }

    }
}
