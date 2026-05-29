# 🏅 SportsApp

Aplikasi Android Native yang menampilkan daftar 10 atlet dengan penghasilan tertinggi di dunia. Proyek ini dikembangkan sebagai sarana pembelajaran pengembangan aplikasi Android modern menggunakan **Kotlin**, **Jetpack Compose**, **MVVM Architecture**, **DataStore Preferences**, dan **Dependency Injection menggunakan Hilt**.

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpack-compose&logoColor=white)

---

# 🚀 Fitur Utama

### ⭐ Implementasi Dependency Injection dengan Hilt
Aplikasi menggunakan Dagger Hilt untuk mengelola dependensi secara otomatis sehingga kode menjadi lebih modular, mudah diuji, dan mudah dikembangkan.

### ⭐ Penyimpanan Permanen dengan DataStore Preferences
Riwayat pencarian atlet disimpan secara persisten menggunakan Jetpack DataStore sehingga data tetap tersedia meskipun aplikasi ditutup atau perangkat direstart.

### ⭐ Arsitektur MVVM Modern
Pemisahan antara UI dan Business Logic dilakukan menggunakan pola MVVM (Model-View-ViewModel) untuk meningkatkan maintainability aplikasi.

### ⭐ Halaman Beranda (Home Page)
Layar pembuka yang berfungsi sebagai titik masuk aplikasi sebelum pengguna mengakses katalog atlet.

### ⭐ Katalog Atlet
Menampilkan daftar 10 atlet dengan penghasilan tertinggi di dunia dalam tampilan yang modern dan responsif menggunakan Jetpack Compose.

### ⭐ Fitur Pencarian Real-Time
Pengguna dapat mencari atlet berdasarkan nama secara langsung dengan hasil yang diperbarui secara real-time.

### ⭐ Bottom Sheet Preview
Menampilkan ringkasan informasi atlet menggunakan Bottom Sheet sebelum pengguna membuka halaman detail.

### ⭐ Halaman Detail Atlet
Menampilkan informasi lengkap mengenai atlet, termasuk cabang olahraga, deskripsi singkat, dan total penghasilan.

### ⭐ Fitur Share
Memanfaatkan Android Intent untuk membagikan informasi atlet ke berbagai aplikasi lain seperti WhatsApp, Telegram, Email, dan lainnya.

---

# 🛠️ Tech Stack & Library

## Language
- Kotlin

## UI Framework
- Jetpack Compose
- Material 3

## Architecture
- MVVM (Model-View-ViewModel)

## Dependency Injection
- Dagger Hilt

## Local Storage
- Jetpack Preferences DataStore

## Navigation
- Navigation Compose

## Asynchronous Programming
- Kotlin Coroutines
- StateFlow

## Image Loading
- Glide

## Annotation Processing
- Kotlin Symbol Processing (KSP)

---

# 🆕 Pembaruan Terbaru

### Implementasi Dependency Injection Menggunakan Hilt
- Menghilangkan kebutuhan pembuatan ViewModelFactory secara manual.
- ViewModel memperoleh dependensi secara otomatis menggunakan Hilt.
- Dependency Injection diterapkan pada AthleteViewModel.

### Migrasi dari KAPT ke KSP
- Meningkatkan performa proses build.
- Lebih kompatibel dengan Android Gradle Plugin terbaru.
- Mengurangi waktu kompilasi proyek.

### Integrasi DataStore Preferences
- Menyimpan kata kunci pencarian pengguna secara permanen.
- Data pencarian tetap tersedia setelah aplikasi ditutup.
- Menggantikan pendekatan penyimpanan konvensional.

### Modernisasi Konfigurasi Gradle
- Konfigurasi plugin Hilt dan KSP menggunakan pendekatan Gradle modern.
- Struktur proyek menjadi lebih sederhana dan mudah dipelihara.

### Registrasi Application Class
- Menambahkan kelas `SportsApplication`.
- Menggunakan anotasi `@HiltAndroidApp`.
- Hilt diinisialisasi secara otomatis saat aplikasi dijalankan.

---

# 📂 Struktur Proyek

```text
app
├── java/com.example.sports
│
├── Athlete.kt
│
├── AthleteViewModel.kt
│
├── MainActivity.kt
│
├── SportsApplication.kt
│
├── di
│   └── DataStoreModule.kt
│
└── ui
    └── screens
        ├── HomeScreen.kt
        ├── CatalogScreen.kt
        └── DetailScreen.kt

res
└── drawable
```

---

# 📸 Tampilan Aplikasi

## 🏠 Home Page

<img width="349" height="785" alt="Screenshot 2026-04-24 180243" src="https://github.com/user-attachments/assets/8cef8482-00bd-4b19-b9c6-008da577ca00" />

---

## 🗂️ Halaman Utama Aplikasi

<img width="356" height="787" alt="Screenshot 2026-04-17 172344" src="https://github.com/user-attachments/assets/23a4a32c-ee84-45df-b846-9305fcbcaec5" />

---

## 📄 Halaman Detail Atlet

<img width="344" height="770" alt="Screenshot 2026-04-24 180349" src="https://github.com/user-attachments/assets/e30b58b7-f2bc-4395-b124-3fdcec73e937" />

---

## 📌 Bottom Sheet Preview

<img width="355" height="178" alt="Screenshot 2026-05-01 175724" src="https://github.com/user-attachments/assets/b003000c-245d-48f8-86e3-ced6bbf7ad68" />

---

# 👨‍💻 Anggota Kelompok

1. Abdul Latief (L0324001)
2. Anton Sulaiman (L0324004)
3. Muhammad Hafizh Fadhilah (L0324021)

---

# ▶️ Demo Video

### Praktikum 6
https://youtube.com/shorts/UDbAqlrNn3o?si=nIuJcsi1VaIZgtDi

### Praktikum 9
https://youtube.com/shorts/YMw8Nn3DUKw?feature=share

---
