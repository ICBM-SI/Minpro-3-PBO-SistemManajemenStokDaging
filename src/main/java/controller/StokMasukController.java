/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Daging;
import model.Karyawan;
import model.StokMasuk;
import view.DagingView;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class StokMasukController {
 
    private int idStokMasukBerikutnya = 1;
 
    // tidak ada data master Supplier di program ini, jadi ID-nya digenerate
    // otomatis oleh sistem - user tidak perlu (dan tidak bisa) mengetiknya sendiri
    private int idSupplierBerikutnya = 1;
 
    private final ArrayList<StokMasuk> daftarStokMasuk;
    private final Dagingcontroller dagingController;
    private final Karyawancontroller karyawanController;
    private final DagingView view;
 
    public StokMasukController(ArrayList<StokMasuk> daftarStokMasuk, Dagingcontroller dagingController,
                                Karyawancontroller karyawanController, DagingView view) {
        this.daftarStokMasuk = daftarStokMasuk;
        this.dagingController = dagingController;
        this.karyawanController = karyawanController;
        this.view = view;
    }
 
    public void tambahkanDataAwal(int idDaging, int idKaryawan, String tanggalMasuk, int jumlah, String keterangan) {
        StokMasuk stokMasukBaru = new StokMasuk(idStokMasukBerikutnya++, idDaging, idSupplierBerikutnya++,
                idKaryawan, tanggalMasuk, jumlah, keterangan);
        daftarStokMasuk.add(stokMasukBaru);
 
        Daging dagingTerkait = dagingController.cariDagingById(idDaging);
        if (dagingTerkait != null) {
            dagingTerkait.setStok(dagingTerkait.getStok() + jumlah);
        }
    }
 
    public void jalankanMenu() {
        int pilihanMenu;
        do {
            view.tampilkanMenu("Menu Stok Masuk", new String[] {
                    "1. Catat Stok Masuk",
                    "2. Lihat Data Stok Masuk",
                    "0. Kembali ke Menu Utama"});
            pilihanMenu = view.bacaAngka("Pilih menu: ", 0, 2);
 
            switch (pilihanMenu) {
                case 1: catatStokMasuk(); break;
                case 2: tampilkanDaftarStokMasuk(); break;
                case 0: break;
            }
        } while (pilihanMenu != 0);
    }
 
    private void catatStokMasuk() {
        dagingController.tampilkanDaftarDaging();
        int idDagingDipilih = view.bacaAngkaPositif("ID daging yang menerima stok (lihat daftar di atas): ");
        Daging dagingTerpilih = dagingController.cariDagingById(idDagingDipilih);
        if (dagingTerpilih == null) {
            view.tampilkanPesan("ID daging tidak ditemukan! Tambahkan data daging terlebih dahulu.");
            return;
        }
 
        karyawanController.tampilkanDaftarKaryawan();
        int idKaryawanDipilih = view.bacaAngkaPositif("ID karyawan yang mencatat (lihat daftar di atas): ");
        Karyawan karyawanTerpilih = karyawanController.cariKaryawanById(idKaryawanDipilih);
        if (karyawanTerpilih == null) {
            view.tampilkanPesan("ID karyawan tidak ditemukan! Tambahkan data karyawan terlebih dahulu.");
            return;
        }
 
        String tanggalMasuk = view.bacaTanggal("Tanggal masuk");
        int jumlah = view.bacaAngkaPositif("Jumlah daging masuk (contoh: 20): ");
        String keterangan = view.bacaTeks("Keterangan", "Pembelian rutin mingguan");
 
        tambahkanDataAwal(idDagingDipilih, idKaryawanDipilih, tanggalMasuk, jumlah, keterangan);
        view.tampilkanPesan("Stok masuk berhasil dicatat, stok daging bertambah menjadi "
                + dagingTerpilih.getStok() + "!");
    }
 
    public void tampilkanDaftarStokMasuk() {
        view.tampilkanTabelStokMasuk(daftarStokMasuk);
    }
}
