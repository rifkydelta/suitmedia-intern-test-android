# Suitmedia - Mobile Developer Intern Test (Android)

## Deskripsi Proyek

Ini adalah proyek aplikasi mobile yang dapat dijalankan di platform Android. Aplikasi ini memiliki tiga layar utama yang masing-masing memiliki fungsionalitas spesifik:

1. **Layar Pertama:** Memeriksa apakah suatu kalimat adalah palindrom.
2. **Layar Kedua:** Menampilkan nama pengguna yang dimasukkan dan menyediakan opsi untuk memilih pengguna dari daftar.
3. **Layar Ketiga:** Menampilkan daftar pengguna yang diambil dari API eksternal dengan fitur refresh dan pagination.

## Spesifikasi Teknologi

### Android Native
- Bahasa Pemrograman: Kotlin
- UI: XML
- Min SDK: 21
- Target SDK: 34

## Detail Fungsionalitas Aplikasi

### 1. Layar Pertama
- **Input Teks:** Terdapat dua kolom input, satu untuk memasukkan nama dan satu lagi untuk memasukkan kalimat yang ingin diperiksa.
- **Fitur Palindrom:** Pengguna dapat memeriksa apakah kalimat yang dimasukkan merupakan palindrom atau bukan dengan menekan tombol "Check".
  - **Contoh:**
    - "kasur rusak" -> Palindrom (true)
    - "step on no pets" -> Palindrom (true)
    - "put it up" -> Palindrom (true)
    - "suitmedia" -> Bukan Palindrom (false)
- **Dialog:** Menampilkan pesan "isPalindrome" jika kalimat adalah palindrom, atau "not palindrome" jika bukan.
- **Tombol "Next":** Mengarahkan pengguna ke layar kedua.

### 2. Layar Kedua
- **Label Selamat Datang:** Teks statis "Welcome".
- **Label Dinamis:** Terdapat dua label dinamis yang menampilkan nama pengguna dari layar pertama dan nama pengguna yang dipilih dari layar ketiga.
- **Tombol "Choose a User":** Mengarahkan pengguna ke layar ketiga untuk memilih pengguna.

### 3. Layar Ketiga
- **Daftar Pengguna:** Menampilkan daftar pengguna yang diambil dari API Reqres.in dengan informasi email, first_name, last_name, dan avatar.
- **Fitur Pull to Refresh:** Menyegarkan data pengguna saat pengguna menarik layar ke bawah.
- **Pagination:** Memuat halaman berikutnya ketika menggulir ke bagian bawah daftar.
- **Empty State:** Menampilkan pesan jika tidak ada data yang tersedia.
- **Pilih Pengguna:** Saat pengguna mengklik salah satu item di daftar, nama pengguna yang dipilih akan ditampilkan di label "Selected User Name" di layar kedua.

## Desain Wireframe
Desain wireframe dan prototipe dapat dilihat di Figma. Anda dapat login menggunakan akun Figma untuk melihat detail desain dan mengakses aset yang diperlukan.

---

Proyek ini dibuat sebagai bagian dari tes teknis untuk pendaftaran Magang Kampus Merdeka di Suitmedia untuk posisi Mobile Developer.
