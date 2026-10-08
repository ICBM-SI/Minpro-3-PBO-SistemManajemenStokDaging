/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Daging;
import model.Karyawan;
import model.StokKeluar;
import view.DagingView;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class StokKeluarController {
 
    private int idStokKeluarBerikutnya = 1;
 
    private final ArrayList<StokKeluar> daftarStokKeluar;
    private final Dagingcontroller dagingController;
    private final Karyawancontroller karyawanController;
    private final DagingView view;
 
    public StokKeluarController(ArrayList<StokKeluar> daftarStokKeluar, Dagingcontroller dagingController,
                                 Karyawancontroller karyawanController, DagingView view) {
        this.daftarStokKeluar = daftarStokKeluar;
        this.dagingController = dagingController;
        this.karyawanController = karyawanController;
        this.view = view;
    }
 
    public void tambahkanDataAwal(int idDaging, int idKaryawan, String tanggalKeluar,
                                   int jumlah, String alasan, String keterangan) {
        StokKeluar stokKeluarBaru = new StokKeluar(idStokKeluarBerikutnya++, idDaging, idKaryawan,
                tanggalKeluar, jumlah, alasan, keterangan);
        daftarStokKeluar.add(stokKeluarBaru);
 
        Daging dagingTerkait = dagingController.cariDagingById(idDaging);
        if (dagingTerkait != null) {
            dagingTerkait.setStok(dagingTerkait.getStok() - jumlah);
        }
    }
 
    public void jalankanMenu() {
        int pilihanMenu;
        do {
            view.tampilkanMenu("Menu Stok Keluar", new String[] {
                    "1. Catat Stok Keluar",
                    "2. Lihat Data Stok Keluar",
                    "0. Kembali ke Menu Utama"});
            pilihanMenu = view.bacaAngka("Pilih menu: ", 0, 2);
 
            switch (pilihanMenu) {
                case 1: catatStokKeluar(); break;
                case 2: tampilkanDaftarStokKeluar(); break;
                case 0: break;
            }
        } while (pilihanMenu != 0);
    }
 
    private void catatStokKeluar() {
        dagingController.tampilkanDaftarDaging();
        int idDagingDipilih = view.bacaAngkaPositif("ID daging yang keluar (lihat daftar di atas): ");
        Daging dagingTerpilih = dagingController.cariDagingById(idDagingDipilih);
        if (dagingTerpilih == null) {
            view.tampilkanPesan("ID daging tidak ditemukan!");
            return;
        }
 
        karyawanController.tampilkanDaftarKaryawan();
        int idKaryawanDipilih = view.bacaAngkaPositif("ID karyawan yang mencatat (lihat daftar di atas): ");
        Karyawan karyawanTerpilih = karyawanController.cariKaryawanById(idKaryawanDipilih);
        if (karyawanTerpilih == null) {
            view.tampilkanPesan("ID karyawan tidak ditemukan!");
            return;
        }
 
        String tanggalKeluar = view.bacaTanggal("Tanggal keluar");
        int jumlah = view.bacaAngkaPositif("Jumlah daging keluar (contoh: 3): ");
 
        if (jumlah > dagingTerpilih.getStok()) {
            view.tampilkanPesan("Stok tidak mencukupi! Stok tersedia saat ini: " + dagingTerpilih.getStok());
            return;
        }
 
        String alasan = view.bacaTeks("Alasan", "Penjualan ke pelanggan");
        String keterangan = view.bacaTeks("Keterangan", "Dijual ke pelanggan tetap");
 
        tambahkanDataAwal(idDagingDipilih, idKaryawanDipilih, tanggalKeluar, jumlah, alasan, keterangan);
        view.tampilkanPesan("Stok keluar berhasil dicatat, sisa stok daging menjadi "
                + dagingTerpilih.getStok() + "!");
    }
 
    public void tampilkanDaftarStokKeluar() {
        view.tampilkanTabelStokKeluar(daftarStokKeluar);
    }
}
