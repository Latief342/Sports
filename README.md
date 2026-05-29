# 🏅 SportsApp

Aplikasi Android yang menampilkan daftar 10 atlet dengan penghasilan tertinggi di dunia. Proyek ini dibuat sebagai sarana pembelajaran pengembangan aplikasi Android tingkat lanjut menggunakan **Kotlin**, **Jetpack Compose**, dan implementasi alur navigasi UX serta penyimpanan data lokal yang optimal.

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)

---

## 🚀 Fitur Utama

* **[BARU] Dependency Injection dengan Hilt:** Mengelola dependensi aplikasi secara otomatis menggunakan Dagger Hilt sehingga kode menjadi lebih modular, bersih, dan mudah dipelihara.
* **Penyimpanan Permanen dengan DataStore:** Menyimpan riwayat kata kunci pencarian pengguna secara persisten di latar belakang. Teks yang dicari tidak akan hilang atau *reset* meskipun aplikasi ditutup paksa dan dibuka kembali.
* **Preview dengan Bottom Sheet:** Memunculkan ringkasan info atlet dari bawah layar (*Bottom Sheet Dialog*) saat data di-klik, sebelum masuk ke tampilan detail penuh.
* **Halaman Beranda (Home Page):** Layar pembuka (*entry point*) yang elegan sebelum masuk ke dalam katalog utama.
* **Daftar Atlet Teratas:** Menampilkan 10 atlet dengan penghasilan tertinggi dalam format list yang modern dan responsif.
* **Fitur Pencarian (Search):** Mencari atlet secara *real-time* berdasarkan nama yang terintegrasi langsung dengan memori lokal.
* **Halaman Detail:** Informasi mendalam tentang setiap atlet, termasuk cabang olahraga, deskripsi karier, dan total penghasilan.
* **Berbagi Informasi (Share):** Fitur Global Intent untuk membagikan ringkasan data atlet ke aplikasi lain (WhatsApp, Email, dll.).

---

## 🛠️ Tech Stack & Library

Aplikasi **SportsApp** dibangun menggunakan standar pengembangan Android Native modern.

* **Language:** Kotlin
* **UI Framework:** Jetpack Compose, Material 3 Design
* **Architecture:** MVVM (Model-View-ViewModel)
* **Dependency Injection:** Dagger Hilt
* **Annotation Processing:** Kotlin Symbol Processing (KSP)

* **Dependencies/Library:**
    * Jetpack Preferences DataStore
    * Navigation Compose
    * StateFlow & Coroutines
    * Dagger Hilt
    * Glide

---

## 📂 Struktur Proyek

Struktur *project* disusun berdasarkan pemisahan UI (*screens*) dan *Logic* agar mudah dipahami dan dipelihara:

## 📂 Struktur Proyek

```text
app
├── java/com.example.sports
│   ├── Athlete.kt
│   ├── AthleteViewModel.kt
│   ├── MainActivity.kt
│   ├── SportsApplication.kt
│   │
│   ├── di
│   │   └── DataStoreModule.kt
│   │
│   └── ui
│       └── screens
│           ├── HomeScreen.kt
│           ├── CatalogScreen.kt
│           └── DetailScreen.kt
│
└── res/drawable

```
---

## 🆕 Update Terbaru

### Implementasi Dependency Injection (Hilt)
Aplikasi kini menggunakan Dagger Hilt untuk mengelola dependensi secara otomatis sehingga tidak lagi memerlukan ViewModelFactory manual.

### Integrasi DataStore Preferences
Riwayat pencarian pengguna kini tersimpan secara permanen menggunakan Jetpack DataStore sehingga data tetap tersedia meskipun aplikasi ditutup.

### SportsApplication & Hilt Initialization
Ditambahkan kelas `SportsApplication` dengan anotasi `@HiltAndroidApp` sebagai titik awal inisialisasi Dependency Injection pada aplikasi.

---
## 📸 Tampilan Aplikasi
---

## 🏠︎ Home Page

Berikut merupakan tampilan halaman utama aplikasi.

<img width="349" height="785" alt="Screenshot 2026-04-24 180243" src="https://github.com/user-attachments/assets/8cef8482-00bd-4b19-b9c6-008da577ca00" />

---

## 🗂️ Halaman Utama Aplikasi

Struktur project dan hasil tampilan aplikasi dapat dilihat pada gambar berikut.

<img width="356" height="787" alt="Screenshot 2026-04-17 172344" src="https://github.com/user-attachments/assets/23a4a32c-ee84-45df-b846-9305fcbcaec5" />

---

## 📄 Halaman Detail Atlet

Berikut tampilan halaman detail atlet saat salah satu data dipilih.

<img width="344" height="770" alt="Screenshot 2026-04-24 180349" src="https://github.com/user-attachments/assets/e30b58b7-f2bc-4395-b124-3fdcec73e937" />


---

## 📌 Pop-Up Bottom Sheet

<img width="355" height="178" alt="Screenshot 2026-05-01 175724" src="https://github.com/user-attachments/assets/b003000c-245d-48f8-86e3-ced6bbf7ad68" />



## 👨‍💻 Anggota Kelompok

1. Abdul Latief (L0324001)
2. Anton Sulaiman (L0324004)
3. Muhammad Hafizh Fadhilah (L0324021)
      
---

## ▶️ Link Youtube

1. https://youtube.com/shorts/UDbAqlrNn3o?si=nIuJcsi1VaIZgtDi (Praktikum 6)
2. https://youtube.com/shorts/YMw8Nn3DUKw?feature=share (Praktikum 9)
