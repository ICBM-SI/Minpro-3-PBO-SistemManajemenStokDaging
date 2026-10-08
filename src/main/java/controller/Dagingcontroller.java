/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Daging;
import view.DagingView;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class Dagingcontroller {
 
    private int idDagingBerikutnya = 1;
    private final ArrayList<Daging> daftarDaging;
    private final DagingView view;
 
    public Dagingcontroller(ArrayList<Daging> daftarDaging, DagingView view) {
        this.daftarDaging = daftarDaging;
        this.view = view;
    }
 
    public void tambahkanDataAwal(String namaDaging, String bagianDaging, double berat,
                                   String tanggalMasuk, String tanggalExpired, int stok, String status) {
        daftarDaging.add(new Daging(idDagingBerikutnya++, namaDaging, bagianDaging, berat,
                tanggalMasuk, tanggalExpired, stok, status));
    }
 
    public void jalankanMenu() {
        int pilihanMenu;
        do {
            view.tampilkanMenu("Menu Daging", new String[] {
                    "1. Tambah Data Daging",
                    "2. Lihat Data Daging",
                    "3. Ubah Data Daging",
                    "4. Hapus Data Daging",
                    "0. Kembali ke Menu Utama"});
            pilihanMenu = view.bacaAngka("Pilih menu: ", 0, 4);
 
            switch (pilihanMenu) {
                case 1: tambahDaging(); break;
                case 2: tampilkanDaftarDaging(); break;
                case 3: ubahDaging(); break;
                case 4: hapusDaging(); break;
                case 0: break;
            }
        } while (pilihanMenu != 0);
    }
 
    private void tambahDaging() {
        String namaDaging = view.bacaTeks("Nama daging", "Daging Sapi");
        String bagianDaging = view.bacaTeks("Bagian daging", "Paha");
        double berat = view.bacaAngkaDesimalPositif("Berat dalam kg (contoh: 10.5): ");
        String tanggalMasuk = view.bacaTanggal("Tanggal masuk");
        String tanggalExpired = view.bacaTanggal("Tanggal expired");
        int stok = view.bacaAngkaNonNegatif("Jumlah stok awal (contoh: 20): ");
        String status = view.bacaTeks("Status", "Tersedia");
 
        int idBaru = idDagingBerikutnya;
        tambahkanDataAwal(namaDaging, bagianDaging, berat, tanggalMasuk, tanggalExpired, stok, status);
        view.tampilkanPesan("Data daging berhasil ditambahkan dengan ID " + idBaru + "!");
    }
 
    public void tampilkanDaftarDaging() {
        view.tampilkanTabelDaging(daftarDaging);
    }
 
    private void ubahDaging() {
        tampilkanDaftarDaging();
        if (daftarDaging.isEmpty()) {
            return;
        }
        int idDagingDipilih = view.bacaAngkaPositif("ID daging yang ingin diubah (contoh: 1): ");
        Daging dagingTerpilih = cariDagingById(idDagingDipilih);
        if (dagingTerpilih == null) {
            view.tampilkanPesan("ID daging tidak ditemukan!");
            return;
        }
 
        dagingTerpilih.setNamaDaging(view.bacaTeks("Nama daging baru", dagingTerpilih.getNamaDaging()));
        dagingTerpilih.setStok(view.bacaAngkaNonNegatif("Stok baru (contoh: 15): "));
        dagingTerpilih.setStatus(view.bacaTeks("Status baru", "Tersedia"));
        view.tampilkanPesan("Data daging berhasil diubah!");
    }
 
    private void hapusDaging() {
        tampilkanDaftarDaging();
        if (daftarDaging.isEmpty()) {
            return;
        }
        int idDagingDipilih = view.bacaAngkaPositif("ID daging yang ingin dihapus (contoh: 1): ");
        Daging dagingTerpilih = cariDagingById(idDagingDipilih);
        if (dagingTerpilih == null) {
            view.tampilkanPesan("ID daging tidak ditemukan!");
            return;
        }
        daftarDaging.remove(dagingTerpilih);
        view.tampilkanPesan("Data daging berhasil dihapus!");
    }
 
    public Daging cariDagingById(int idDaging) {
        for (Daging dagingItem : daftarDaging) {
            if (dagingItem.getIdDaging() == idDaging) {
                return dagingItem;
            }
        }
        return null;
    }
}
