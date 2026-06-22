# 🏅 SportsApp

Aplikasi Android yang menampilkan daftar 10 atlet dengan penghasilan tertinggi di dunia. Proyek ini dibuat sebagai sarana pembelajaran pengembangan aplikasi Android tingkat lanjut menggunakan **Kotlin**, **Jetpack Compose**, dan implementasi alur navigasi UX serta penyimpanan data lokal yang optimal.

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)

---

📖 Latar Belakang

Perkembangan teknologi mobile telah mempermudah masyarakat dalam mengakses berbagai informasi secara cepat dan praktis. Namun, informasi mengenai atlet dari berbagai cabang olahraga sering kali tersebar di berbagai platform sehingga kurang efisien untuk dicari dan dipelajari. Oleh karena itu, diperlukan sebuah aplikasi yang dapat menyajikan informasi atlet secara terpusat, mudah diakses, dan interaktif melalui perangkat Android.

---

💡 Solusi

Sports merupakan aplikasi Android yang dirancang untuk menyediakan informasi atlet dari berbagai cabang olahraga dalam satu platform. Aplikasi ini dilengkapi dengan fitur autentikasi pengguna, katalog atlet, pencarian atlet, preview data atlet, dan halaman detail atlet. Dengan memanfaatkan REST API dan teknologi Android modern seperti Jetpack Compose, Hilt, Retrofit, dan DataStore, aplikasi mampu memberikan pengalaman pengguna yang cepat, responsif, dan mudah digunakan.

---

## 🚀 Fitur Utama

* [BARU] HTTP Request dengan Retrofit: Mengambil data atlet secara langsung dari REST API menggunakan Retrofit dan Gson Converter.
* [BARU] Integrasi MockAPI: Data atlet dan pengguna disimpan pada MockAPI sehingga aplikasi dapat melakukan komunikasi client-server secara online.
* [BARU] Sistem Login: Pengguna dapat masuk ke aplikasi menggunakan akun yang tersimpan pada MockAPI.
* [BARU] Sistem Register: Pengguna dapat membuat akun baru dan menyimpannya langsung ke MockAPI menggunakan HTTP POST Request.
* [BARU] Halaman Profil: Menampilkan informasi pengguna yang sedang login, termasuk nama lengkap dan username.
* [BARU] Logout: Pengguna dapat keluar dari aplikasi dan kembali ke halaman login dengan aman.
* Dependency Injection dengan Hilt: Mengelola dependensi aplikasi secara otomatis menggunakan Dagger Hilt sehingga kode menjadi lebih modular, bersih, dan mudah dipelihara.
* Penyimpanan Permanen dengan DataStore: Menyimpan riwayat kata kunci pencarian pengguna secara persisten di latar belakang.
* Preview dengan Bottom Sheet: Menampilkan ringkasan informasi atlet sebelum masuk ke halaman detail.
* Daftar Atlet Teratas: Menampilkan data atlet dengan penghasilan tertinggi yang diperoleh dari REST API.
* Fitur Pencarian (Search): Mencari atlet secara real-time berdasarkan nama.
* Halaman Detail: Menampilkan informasi lengkap mengenai atlet yang dipilih.
* Berbagi Informasi (Share): Membagikan informasi atlet ke aplikasi lain menggunakan Android Intent.

---

## 🛠️ Tech Stack & Library

Aplikasi **SportsApp** dibangun menggunakan standar pengembangan Android Native modern.

* Language:** Kotlin
* UI Framework:** Jetpack Compose, Material 3 Design
* Architecture:** MVVM (Model-View-ViewModel)
* Design System: Material 3
* Dependency Injection:** Dagger Hilt
* Annotation Processing:** Kotlin Symbol Processing (KSP)

* **Dependencies/Library:**
    * Gson Converter
    * OkHttp Logging Interceptor
    * Retrofit
    * Jetpack Preferences DataStore
    * Navigation Compose
    * Kotlin Coroutines
    * StateFlow & Coroutines
    * Dagger Hilt
    * Glide
    * MockAPI

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

### Integrasi Retrofit & REST API 
Aplikasi kini menggunakan Retrofit untuk melakukan HTTP Request dan mengambil data atlet secara langsung dari server MockAPI.

### Implementasi MockAPI 
Data atlet dan pengguna kini disimpan secara online menggunakan MockAPI sehingga aplikasi dapat melakukan operasi GET dan POST seperti aplikasi Android pada umumnya. 

### Sistem Login dan Register
Ditambahkan fitur autentikasi sederhana menggunakan endpoint users pada MockAPI. Pengguna dapat membuat akun baru dan login menggunakan data yang tersimpan pada server. ### Halaman Profil Pengguna

### Halaman Profil
Pengguna Setelah login, pengguna dapat melihat informasi akun yang sedang digunakan melalui halaman profil. 

### Implementasi Logout 
Ditambahkan fitur logout yang akan mengembalikan pengguna ke halaman login dan menghapus sesi pengguna aktif.

### Penyempurnaan Navigation Compose 
Alur navigasi aplikasi kini menjadi: Login → Register → Login → Catalog → Detail Atlet → Profil → Logout

---
## 📸 Tampilan Aplikasi
---

## 🔐 Login Page

Berikut merupakan tampilan halaman Login aplikasi.

<img width="346" height="567" alt="Screenshot 2026-06-21 174127" src="https://github.com/user-attachments/assets/53a6ed6e-58c7-4d89-8623-47f5a7f0c1b1" />

---

## 📝 Halaman Utama Aplikasi

Berikut merupakan tampilan halaman Register aplikasi.

<img width="337" height="613" alt="Screenshot 2026-06-21 174916" src="https://github.com/user-attachments/assets/13c97e0a-23ae-4824-8c78-8c79f2f383ea" />

---

## 🏠 Halaman Utama Aplikasi

Berikut merupakan tampilan Utama aplikasi.

<img width="337" height="461" alt="Screenshot 2026-06-21 175813" src="https://github.com/user-attachments/assets/ba2a5ee4-c15e-4e3f-b14c-5ffad384f8cc" />

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
2. https://youtube.com/shorts/YMw8Nn3DUKw?feature=share (Praktikum 9 & Praktikum 10)
3. https://youtube.com/shorts/x54TrR-0ab0?feature=share (Praktikum 11)
