# 🏅 SportsApp

Aplikasi Android sederhana yang menampilkan daftar 10 atlet dengan penghasilan tertinggi di dunia. Proyek ini dibuat sebagai sarana pembelajaran pengembangan aplikasi Android menggunakan **Kotlin**, **RecyclerView**, dan **Master-Detail Pattern**.

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)

---

## 🚀 Fitur Utama

* **Daftar Atlet Teratas:** Menampilkan 10 atlet dengan penghasilan tertinggi dalam format list yang modern.
* **Fitur Pencarian (Search):** Mencari atlet secara *real-time* berdasarkan nama.
* **Halaman Detail:** Informasi mendalam tentang setiap atlet, termasuk deskripsi karier dan total penghasilan.
* **Berbagi Informasi (Share):** Fitur untuk membagikan data atlet ke aplikasi lain (WhatsApp, Email, dll.).
* **Gambar Optimal:** Menggunakan library **Glide** untuk pemuatan gambar yang ringan dan efisien.

---

## 🛠️ Tech Stack & Library

* **Language:** [Kotlin](https://kotlinlang.org/)
* **UI Framework:** Android XML (View-based)
* **Architecture:** Master-Detail Flow
* **Library:**
    * [Glide](https://github.com/bumptech/glide) - Untuk image loading & caching.
    * RecyclerView - Untuk menampilkan daftar data yang efisien.
    * CardView - Untuk desain list yang modern dan berbayang.
    * Serializable - Untuk pengiriman data antar Activity.

---

## 📂 Struktur Proyek

```text
app
├── java/com.example.sports
│   ├── Athlete.kt           # Model data (Serializable)
│   ├── AthleteAdapter.kt    # Logic untuk RecyclerView & Search Filter
│   ├── MainActivity.kt      # Halaman utama & logika Search
│   └── DetailActivity.kt    # Halaman detail & fitur Share
├── res/layout
│   ├── activity_main.xml    # Layout utama dengan Search Bar
│   ├── activity_detail.xml  # Layout detail atlet
│   └── item_athlete.xml     # Layout custom untuk setiap baris atlet
└── res/drawable             # Asset gambar atlet (resized)

```
---

## 📸 Tampilan Aplikasi

Struktur project dan hasil tampilan aplikasi dapat dilihat pada gambar berikut.

<img width="356" height="787" alt="Screenshot 2026-04-17 172344" src="https://github.com/user-attachments/assets/23a4a32c-ee84-45df-b846-9305fcbcaec5" />

---

## 📄 Halaman Detail Atlet

Berikut tampilan halaman detail atlet saat salah satu data dipilih.

<img width="352" height="545" alt="Screenshot 2026-04-17 172358" src="https://github.com/user-attachments/assets/f27acf76-b624-429a-b2e6-207530e5aa47" />

---



---

## 👨‍💻 Anggota Kelompok

1. Abdul Latief (L0324001)
2. Anton Sulaiman (L0324004)
3. Muhammad Hafizh Fadhilah (L0324021)
   
   
---

## ▶️ Link Youtube

https://youtube.com/shorts/naf1wGCw7PM?feature=share
