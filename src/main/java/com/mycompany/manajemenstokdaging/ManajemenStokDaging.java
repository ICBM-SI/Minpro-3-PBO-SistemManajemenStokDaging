/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajemenstokdaging;
import controller.Dagingcontroller;
import controller.Karyawancontroller;
import controller.StokKeluarController;
import controller.StokMasukController;
import model.Daging;
import model.Karyawan;
import model.StokKeluar;
import model.StokMasuk;
import view.DagingView;
import java.util.ArrayList;
import java.util.Scanner;
 
/**
 *
 * @author LENOVO
 */
public class ManajemenStokDaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DagingView view = new DagingView(scanner);
 
        ArrayList<Daging> daftarDaging = new ArrayList<>();
        ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
        ArrayList<StokMasuk> daftarStokMasuk = new ArrayList<>();
        ArrayList<StokKeluar> daftarStokKeluar = new ArrayList<>();
 
        Dagingcontroller dagingController = new Dagingcontroller(daftarDaging, view);
        Karyawancontroller karyawanController = new Karyawancontroller(daftarKaryawan, view);
        StokMasukController stokMasukController = new StokMasukController(
                daftarStokMasuk, dagingController, karyawanController, view);
        StokKeluarController stokKeluarController = new StokKeluarController(
                daftarStokKeluar, dagingController, karyawanController, view);
 
        muatDataAwal(dagingController, karyawanController, stokMasukController, stokKeluarController);
 
        int pilihanMenuUtama;
        do {
            view.tampilkanMenu("Sistem Manajemen Stok Daging", new String[] {
                    "1. Data Daging",
                    "2. Data Karyawan",
                    "3. Stok Masuk",
                    "4. Stok Keluar",
                    "0. Keluar"});
            pilihanMenuUtama = view.bacaAngka("Pilih menu: ", 0, 4);
 
            if (pilihanMenuUtama == 1) {
                dagingController.jalankanMenu();
            } else if (pilihanMenuUtama == 2) {
                karyawanController.jalankanMenu();
            } else if (pilihanMenuUtama == 3) {
                stokMasukController.jalankanMenu();
            } else if (pilihanMenuUtama == 4) {
                stokKeluarController.jalankanMenu();
            } else if (pilihanMenuUtama == 0) {
                view.tampilkanPesan("Program selesai.");
            }
        } while (pilihanMenuUtama != 0);
 
        scanner.close();
    }

    private static void muatDataAwal(Dagingcontroller dagingController, Karyawancontroller karyawanController,
                                      StokMasukController stokMasukController, StokKeluarController stokKeluarController) {
 
        dagingController.tambahkanDataAwal("Daging Sapi", "Paha", 10.5,
                "01-09-2026", "10-09-2026", 3, "Tersedia");
        dagingController.tambahkanDataAwal("Daging Ayam", "Dada", 5.0,
                "02-09-2026", "05-09-2026", 15, "Tersedia");
 
        karyawanController.tambahkanDataAwal("Budi", "Admin Gudang");
 
        stokMasukController.tambahkanDataAwal(1, 1, "01-09-2026", 20, "Pembelian awal");
 
        stokKeluarController.tambahkanDataAwal(1, 1, "05-09-2026", 3, "Penjualan", "Dijual ke pelanggan");
    }
}
