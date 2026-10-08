/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Karyawan;
import view.DagingView;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class Karyawancontroller {
 
    private int idKaryawanBerikutnya = 1;
 
    private final ArrayList<Karyawan> daftarKaryawan;
    private final DagingView view;
 
    public Karyawancontroller(ArrayList<Karyawan> daftarKaryawan, DagingView view) {
        this.daftarKaryawan = daftarKaryawan;
        this.view = view;
    }
 
    public void tambahkanDataAwal(String namaKaryawan, String jabatan) {
        daftarKaryawan.add(new Karyawan(idKaryawanBerikutnya++, namaKaryawan, jabatan));
    }
 
    public void jalankanMenu() {
        int pilihanMenu;
        do {
            view.tampilkanMenu("Menu Karyawan", new String[] {
                    "1. Tambah Data Karyawan",
                    "2. Lihat Data Karyawan",
                    "0. Kembali ke Menu Utama"});
            pilihanMenu = view.bacaAngka("Pilih menu: ", 0, 2);
 
            switch (pilihanMenu) {
                case 1: tambahKaryawan(); break;
                case 2: tampilkanDaftarKaryawan(); break;
                case 0: break;
            }
        } while (pilihanMenu != 0);
    }
 
    private void tambahKaryawan() {
        String namaKaryawan = view.bacaTeks("Nama karyawan", "Budi Santoso");
        String jabatan = view.bacaTeks("Jabatan", "Admin Gudang");
 
        int idBaru = idKaryawanBerikutnya;
        tambahkanDataAwal(namaKaryawan, jabatan);
        view.tampilkanPesan("Data karyawan berhasil ditambahkan dengan ID " + idBaru + "!");
    }
 
    public void tampilkanDaftarKaryawan() {
        view.tampilkanTabelKaryawan(daftarKaryawan);
    }
 
    public Karyawan cariKaryawanById(int idKaryawan) {
        for (Karyawan karyawanItem : daftarKaryawan) {
            if (karyawanItem.getIdKaryawan() == idKaryawan) {
                return karyawanItem;
            }
        }
        return null;
    }
}
