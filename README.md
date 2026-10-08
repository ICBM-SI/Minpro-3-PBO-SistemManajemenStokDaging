# Mini Project PBO - Sistem Manajemen Stok Daging

**Nama: Aditya Dwinugraha Yusniandra**

**NIM: 2509116114**

# Deskripsi Program
Program Sistem Manajemen Stok Daging merupakan program yang dibuat untuk memudahkan proses manajemen stok daging dalam gudang. Program ini dibuat menggunakan Java dan menerapkan pendekatan pemrograman yang menggunakan objek untuk menyusun dan mengatur kode atau yang biasa disebut Object Oriented Programming (OOP).

# Penjelasan Alur Program
## A. Menu Utama

Tampilan awal menu saat pertama kali menjalankan program:

<img width="351" height="158" alt="image" src="https://github.com/user-attachments/assets/3dc179a4-3a36-4e2a-a5cb-6bfad2c3fe76" />

## B. Data Daging
### Menu Daging
Memilih opsi Data Daging akan menampilkan CRUD Data Daging seperti tambah, lihat, ubah, dan hapus. Ditambahkan juga opsi untuk kembali ke menu utama.

<img width="177" height="154" alt="image" src="https://github.com/user-attachments/assets/b53037bd-33c0-4a63-b524-9d5fe3a5b47a" />

### 1. Tambah
Opsi ini digunakan untuk menambahkan stok daging baru ke dalam database.

<img width="267" height="322" alt="image" src="https://github.com/user-attachments/assets/bb8740f6-5a9f-4c2b-9e37-8c9532cae7da" />

### 2. Lihat
Opsi ini digunakan untuk melihat data stok daging yang ada.

<img width="705" height="229" alt="image" src="https://github.com/user-attachments/assets/6c7a40ee-cafc-4808-9ed0-0417e60afe8d" />

### 3. Ubah
Jika ingin mengubah jumlah nama dan stok daging yang sudah ada di dalam database, opsi ini dapat digunakan.

<img width="259" height="264" alt="image" src="https://github.com/user-attachments/assets/8b6becf5-2592-4bf9-ba30-02b3afec68c1" />

### 4. Hapus
Jika ada data daging yang ingin dihapus, opsi ini dapat digunakan.

<img width="265" height="207" alt="image" src="https://github.com/user-attachments/assets/222af19d-7604-462b-8b35-757e25df6225" />

### 5. Kembali
Digunakan untuk kembali ke menu utama program.

<img width="354" height="323" alt="image" src="https://github.com/user-attachments/assets/23e82de6-7e37-4038-88dd-dc56f9b5f68e" />

## C. Data Karyawan
### Menu Karyawan
Pada menu ini terdapat beberapa opsi seperti menambahkan karyawan dan melihat daftar karyawan.

<img width="208" height="115" alt="image" src="https://github.com/user-attachments/assets/91524e2e-b59f-47ae-8b6c-bd74c9ec01fd" />

### 1. Tambah
Opsi ini digunakan untuk menambah data karyawan dengan memasukkan nama dan jabatan.

<img width="225" height="183" alt="image" src="https://github.com/user-attachments/assets/33129f22-fb35-4259-a5ef-a5452e8fca85" />

### 2. Lihat
Opsi ini digunakan untuk melihat data karyawan yang ada pada database.

<img width="213" height="178" alt="image" src="https://github.com/user-attachments/assets/332a98a2-fa10-4817-9493-a133c581b5cf" />

### 3. Kembali
Digunakan untuk kembali ke menu utama program.

<img width="338" height="264" alt="image" src="https://github.com/user-attachments/assets/ef977469-528f-4e1b-8004-c9f0de2bd2c8" />

## D. Stok Masuk
### Menu Stok Masuk
Di menu ini terdapat opsi untuk menambahkan dan melihat stok daging yang masuk ke gudang.

<img width="223" height="93" alt="image" src="https://github.com/user-attachments/assets/d480b02e-464d-48ef-8dc4-c205b65e59a7" />

### 1. Tambah
Opsi ini dapat menambahkan stok baru ke dalam database dengan memasukkan id daging, id supplier, id karyawan, tanggal masuk, jumlah, dan keterangan.

<img width="262" height="263" alt="image" src="https://github.com/user-attachments/assets/23fc8ba8-bcd2-4fe3-bb07-98a591e11c03" />

### 2. Lihat
Opsi untuk melihat data stok masuk.

<img width="681" height="188" alt="image" src="https://github.com/user-attachments/assets/6f91a8d7-c9c3-4bba-883f-4e4119fef4e1" />

### 3. Kembali
Digunakan untuk kembali ke menu utama program.

<img width="352" height="282" alt="image" src="https://github.com/user-attachments/assets/3c8bff67-8de4-4ec2-99a2-e6fc90487988" />

## E. Stok Keluar
### Menu Stok Keluar
Di menu ini terdapat opsi untuk menambahkan dan melihat stok daging yang keluar dari gudang.

<img width="365" height="260" alt="image" src="https://github.com/user-attachments/assets/1febcf1b-552b-422c-bf9c-bbc77a2dab4c" />

### 1. Tambah
Opsi untuk mendata stok daging yang dikeluarkan dari gudang.

<img width="414" height="261" alt="image" src="https://github.com/user-attachments/assets/db025864-20f0-444a-bf55-246cb88b0906" />

### 2. Lihat
Opsi untuk melihat data stok daging yang keluar dari gudang.

<img width="814" height="188" alt="image" src="https://github.com/user-attachments/assets/cc2424ac-b8b9-4bf5-98d7-0e62eaeecb67" />

### 3. Kembali
Digunakan untuk kembali ke menu utama program.

<img width="349" height="286" alt="image" src="https://github.com/user-attachments/assets/64c71c6f-100d-4191-b070-f2586c259f20" />

# Penerapan Encapsulation & Inheritence
## 1. Encapsulation
Encapsulation diterapkan dengan cara menyembunyikan field menggunakan modifier private, lalu menyediakan akses ke atribut tersebut melalui method public berupa getter dan setter. Dengan begitu, data di dalam objek tidak bisa diubah sembarangan dari luar class. Semua perubahan harus lewat method yang sudah disediakan. Konsep yang sama juga diterapkan di semua class model lain seperti Karyawan, StokMasuk, StokKeluar, dan superclass TransaksiStok.

Salah satu penerapan encapsulation pada program ini terdapat pada class Daging. Salah satu manfaat yang didapatkan dengan melakukan penerapan encapsulation adalah field stok tidak bisa diakses langsung dari luar class karena field-nya private.

<img width="705" height="727" alt="image" src="https://github.com/user-attachments/assets/5530e98a-e60c-4e49-bed2-738b3edbeead" />

## 2. Inheritence
Inheritance diterapkan pada dua class transaksi stok, yaitu StokMasuk dan StokKeluar, yang keduanya mewarisi field dan method yang sama dari satu superclass, yaitu TransaksiStok.

Kedua transaksi ini punya kesamaan data yaitu: idTransaksi, idDaging, idKaryawan, tanggal, jumlah, keterangan. Daripada ditulis dua kali di masing-masing class, field tersebut ditarik ke satu superclass TransaksiStok, lalu tiap subclass tinggal menambahkan field yang khas miliknya sendiri.

### Contoh Superclass TransaksiStok

<img width="851" height="533" alt="image" src="https://github.com/user-attachments/assets/86d7b535-8de7-4e94-ba5f-d3fdc606adfa" />

### Contoh Subclass StokMasuk

<img width="999" height="437" alt="image" src="https://github.com/user-attachments/assets/281ebb44-ffb4-4bf8-9a4f-56666283d693" />

### Contoh Subclass StokKeluar

<img width="1064" height="423" alt="image" src="https://github.com/user-attachments/assets/a2f49dac-36cf-4261-94d7-f2f3e80d3bde" />

# Nilai Tambah
## Penerapan Polymorphism (override)
Superclass TransaksiStok menggunakan method tampilkan()

<img width="364" height="68" alt="image" src="https://github.com/user-attachments/assets/1b7352fb-2e04-4eed-873d-a537286aa86e" />

Dua subclass-nya, StokMasuk dan StokKeluar sama-sama meng-extend TransaksiStok, tapi masing-masing melakukan override tampilkan() dengan implementasi yang berbeda karena struktur datanya juga berbeda.

### StokMasuk:
<img width="1270" height="439" alt="image" src="https://github.com/user-attachments/assets/7e884588-a371-4a60-986e-0cbe7d494a3e" />

### StokKeluar:

<img width="1318" height="409" alt="image" src="https://github.com/user-attachments/assets/da6897ed-44e7-46bf-9cc1-00112db695ff" />


