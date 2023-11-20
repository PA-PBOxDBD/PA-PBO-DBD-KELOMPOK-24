# Pengelolaan Data Nilai Ujian Sekolah Siswa

## Kelompok 24
- 2209116003 - Sandrina Aulia
- 2209116018 - M. Haykal Fajjar Aulia

## Deskripsi Singkat
SMAKESHA (Sekolah Menengah Kejuruan Star Harmoni) adalah sebuah institusi pendidikan yang berkomitmen untuk memberikan pendidikan berkualitas kepada para siswa. Mereka menyadari bahwa mengelola data nilai siswa dengan cara manual mengalami banyak kendala, termasuk kesalahan pencatatan, kerumitan dalam mengakses data.

## Fitur Inti
1. Pengelolaan Data Siswa: Aplikasi ini memungkinkan Siswa untuk melihat informasi siswa itu sendiri. Siswa dapat melihat data seperti nama, Nomor Induk Sekolah (NIS)/Id_User, nama, nilai dan informasi terkait lainnya

2. Pengelolaan Nilai Siswa: Aplikasi ini memfasilitasi Staff TU untuk membuat, mengedit, menghapus maupun menampilkan data nilai siswa. Termasuk dalam fitur ini adalah pengelolaan nilai.

3. Autentikasi Pengguna: Aplikasi memiliki fitur login yang membedakan antara pengguna berdasarkan peran mereka, seperti staf akademik dan mahasiswa.


## Teknologi yang digunakan

- Bahasa Pemrograman Java: Bahasa utama yang digunakan dalam pengembangan aplikasi ini

- Lingkungan Pengembangan NetBeans IDE: Digunakan sebagai alat utama dalam proses pengembangan aplikasi.

- Sistem Manajemen Basis Data MySQL: Digunakan untuk menyimpan dan mengelola data siswa dan nilai siswa

## Struktur Proyek

- Direktor "src": berisi kode sumber aplikasi, termasuk paket Controller, Database, Model, dan View.

- Direktori "dist": Berisi file JAR yang dapat dijalankan bersama dengan library pihak ketiga yang diperlukan untuk menjalankan aplikasi.

- Direktori "nbproject": Berisi berkas konfigurasi proyek yang khusus untuk penggunaan NetBeans

Selain itu, proyek ini mencakup berkas SQL yang digunakan untuk membuat struktur basis data yang diperlukan untuk menyimpan informasi siswa dan nilai siswa.

## Cara Menjalankan Aplikasi
Untuk menjalankan aplikasi ini, Anda dapat menggunakan file JAR yang telah disediakan dalam direktori "dist". Pastikan untuk menyertakan semua library yang ada di direktori "dist/lib" dalam classpath aplikasi.

Aplikasi ini bertujuan mempermudah staf akademik/TU dalam mengelola data siswa dan nilai siswa, memungkinkan mereka untuk mencatat, memperbarui data akademik seperti nilai dengan cepat, dan menghasilkan laporan nilai serta transkrip akademik secara efisien. Selain itu, siswa juga dapat dengan mudah memantau perkembangan akademik mereka melalui aplikasi ini.

## Flowchart
![WhatsApp Image 2023-11-04 at 03 58 00_c127c466](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/03283f93-0f26-4a6c-9ae5-18dcdde4f337)

Flowchart dimulai dari user diminta untuk memilih menu login , terdapat 3 menu pilihan yaitu staff TU, siswa dan exit. Ketika user memilih menu staff TU maka user diminta untuk menginputkan nip dan password kemudian jika user salah menginputkan maka user diminta untuk menginput kan kembali, jika user berhasil login maka user akan ditampilkan menu tabel nilai yang berisi crud dari menu tersebut kemudian akan tersimpan didatabase.Kemudian jika pengguna memilih menu siswa maka pengguna diminta untuk menginputkan nis dan password, jika gagal maka pengguna akan diminta menginputkan kembali jika berhasil maka pengguna akan ditampilkan tabel nilai namun pengguna hanya bisa melihat tanpa bisa mengedit.

## Entity Relationship Diagram
### Logical ERD
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121924124/e9cb75a2-b0e3-43b3-84b6-1db92b2434f9)


### Relatioanal ERD
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121924124/ba797f0c-bd2e-4589-95d1-af965741a7a8)



## Hirarki kelas
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/1b1e4461-2985-46b5-9a9b-f32bbb96ba7d)

Hirarki Kelas adalah struktur kelas yang digunakan dalam program. Berikut adalah Hirarki Kelas dari Sistem Pengelolaan Data Nilai Siswa.

## Penjelasan Coding Program
Terdapat 3 package utama dalam program ini, yaitu:
- Database : berisi kelas yang digunakan untuk mengelola koneksi ke database dan mengambil data dari database.
- Gui : berisi kelas yang digunakan untuk membuat antarmuka pengguna.
- Image: berisi gambar yang digunakan dalam program.

### Database
#### Database.java
```java
package database;
import java.sql.*;

public class Database {
    public static Connection sql = null;

    protected static Statement statement;
    protected static PreparedStatement preparedStatement;
    protected static ResultSet resultSet;
        
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/haykal";
            sql = DriverManager.getConnection(url, "root", "");
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Failed to connect database!");
        }
        return sql;
    }

    public static void disconnect(){
        try {
            sql.close();
            System.out.println("Database disconnected!");
        } catch (SQLException e) {
            System.out.println("Failed to disconnect database!");
        }
    }
}

```
Pada kode diatas merupakan koneksi ke database yang digunakan untuk menghubungkan program dengan database yang telah dibuat. Pada kode diatas terdapat method connect() dan disconnect() yang digunakan untuk menghubungkan dan memutuskan koneksi ke database.

#### Nilai.java
```java
package database;

import java.sql.*;

public class Nilai {
    private int idNilai;
    private int nilai;
    private String predikat;
    private final String mataPelajaranKodeMapel;
    private final String siswaIdUser;
    private String staffTUIdUser;

    public Nilai(String predikat, int nilai, String mataPelajaranKodeMapel, String siswaIdUser, String staffTUIdUser) {
        this.idNilai = idNilai;
        this.nilai = nilai;
        this.predikat = predikat;
        this.mataPelajaranKodeMapel = mataPelajaranKodeMapel;
        this.siswaIdUser = siswaIdUser;
        this.staffTUIdUser = staffTUIdUser;
    }
    
    public Nilai(String siswaIdUser, String mataPelajaranKodeMapel){
        this.siswaIdUser = siswaIdUser;
        this.mataPelajaranKodeMapel = mataPelajaranKodeMapel;
    }
    
    public Nilai(String predikat, int nilai, String siswaIdUser, String mataPelajaranKodeMapel){
        this.predikat = predikat;
        this.nilai = nilai;
        this.siswaIdUser = siswaIdUser;
        this.mataPelajaranKodeMapel = mataPelajaranKodeMapel;
    }


    public int getIdNilai() {
        return idNilai;
    }

    public void setIdNilai(int idNilai) {
        this.idNilai = idNilai;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public boolean addNilai() {
        try {
            String query = "INSERT INTO nilai (nilai, predikat, mata_pelajaran_kode_mapel, siswa_id_user, staff_tu_id_user) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Database.connect().prepareStatement(query);
            preparedStatement.setInt(1, this.nilai);
            preparedStatement.setString(2, this.predikat);
            preparedStatement.setString(3, this.mataPelajaranKodeMapel);
            preparedStatement.setString(4, this.siswaIdUser);
            preparedStatement.setString(5, this.staffTUIdUser);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void showTranskipNilai() {
        try {
            Connection conn = Database.connect();
            String query = "SELECT n.id_nilai, n.predikat, n.MATA_PELAJARAN_kode_mapel, n.SISWA_id_user, " +
                    "u.id_user, u.nama, u.password, u.role " +
                    "FROM nilai AS n " +
                    "JOIN user AS u ON n.SISWA_id_user = u.id_user";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idNilai = resultSet.getInt("id_nilai");
                String predikat = resultSet.getString("predikat");
                int mataPelajaranKodeMapel = resultSet.getInt("MATA_PELAJARAN_kode_mapel");
                int siswaIdUser = resultSet.getInt("SISWA_id_user");

                System.out.println("ID Nilai: " + idNilai);
                System.out.println("Predikat: " + predikat);
                System.out.println("Kode Mapel: " + mataPelajaranKodeMapel);
                System.out.println("ID User Siswa: " + siswaIdUser);
            }

            conn.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNilai(){
        try {
            Connection conn = Database.connect();
            String query = "DELETE FROM nilai WHERE siswa_id_user = ? AND mata_pelajaran_kode_mapel = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, this.siswaIdUser);
            preparedStatement.setString(2, this.mataPelajaranKodeMapel);
            preparedStatement.executeUpdate();
            System.out.println("berhasil eksekusi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateNilai(){
        try {
            Connection conn = Database.connect();
            String query = "UPDATE nilai SET nilai = ?, predikat = ? WHERE siswa_id_user = ? AND mata_pelajaran_kode_mapel = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, this.nilai);
            preparedStatement.setString(2, this.predikat);
            preparedStatement.setString(3, this.siswaIdUser);
            preparedStatement.setString(4, this.mataPelajaranKodeMapel);
            preparedStatement.executeUpdate();
            System.out.println("berhasil eksekusi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

Pada kode diatas merupakan kelas Nilai yang digunakan untuk mengelola data nilai siswa. Pada kelas ini terdapat beberapa method yang digunakan untuk mengelola data nilai siswa seperti addNilai(), showTranskipNilai(), deleteNilai(), dan updateNilai().

#### Siswa.java
```java

package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Siswa extends User{
    private final String name;
    private final String kelas;
    private final String jenisKelamin;
    private final String siswaIDUser;

    public Siswa(String idUser, String password, String role, String name, String kelas, String jenisKelamin, String siswaIDUser){
        super(idUser, password, role);
        this.name = name;
        this.kelas = kelas;
        this.jenisKelamin = jenisKelamin;
        this.siswaIDUser = siswaIDUser;
    }

    public String getName(){
        return name;
    }

    public String getKelas(){
        return kelas;
    }

    public String getJenisKelamin(){
        return jenisKelamin;
    }

    public String getSiswaIDUser(){
        return siswaIDUser;
    }

    @Override
    public String getRole(){
        return "Siswa";
    }
    
    
    
}
```
Pada kode diatas merupakan kelas Siswa yang digunakan untuk mengelola data siswa. Pada kelas ini terdapat beberapa method yang digunakan untuk mengelola data siswa seperti getName(), getKelas(), getJenisKelamin(), getSiswaIDUser(), dan getRole().

#### User.java
```java
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class User {
    
    private String idUser;
    private String password;
    private String role;

    public User(String idUser, String password, String role) {
        this.idUser = idUser;
        this.password = password;
        this.role = role;
    }

    // Getter dan setter
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Method login menggunakan ORM
    public boolean login() {
        try {
            Connection conn = Database.connect();
            String query = "SELECT * FROM user WHERE id_user = ? AND password = ? AND role = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.getIdUser());
            statement.setString(2, this.getPassword());
            statement.setString(3, this.getRole());
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Kesalahan Koneksi Pada Database" );
            e.printStackTrace();
            // Tangani kesalahan koneksi atau query
        }
        JOptionPane.showMessageDialog(null,"Input Salah ! Mohon Coba Lagi" );
        return false; 
        
    }
}
```
Pada kode diatas merupakan kelas User yang digunakan untuk mengelola data user. Pada kelas ini terdapat beberapa method yang digunakan untuk mengelola data user seperti login(). Method login() digunakan untuk melakukan login ke dalam program.

## Penjelasan Output Program

### Halaman Login
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/e59eaa3a-53e2-4755-ba09-c7cf0d41ff07)

Pada halaman login terdapat 2 field dan 1 combo box. Field pertama digunakan untuk menginputkan id user, field kedua digunakan untuk menginputkan password, dan combo box digunakan untuk memilih role user. Terdapat 2 role user yaitu Staff TU dan Siswa. Jika user memilih role Staff TU maka user akan diarahkan ke halaman Staff TU, jika user memilih role Siswa maka user akan diarahkan ke halaman Siswa.

### Halaman Siswa
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/c5f5c303-6fbc-4710-a3bc-40cb1810a58b)

Pada halaman Siswa ketika kita menginput sebuah NIS maka akan muncul data nilai siswa tersebut. Pada halaman ini user hanya dapat melihat data nilai siswa tersebut, user tidak dapat mengedit data nilai siswa tersebut.

### Halaman Staff TU
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/14349fe3-73e7-4e71-887b-143a2a4cf7a8)

Pada halaman Staff TU terdapat 5 field yaitu nis, matematika, bahasa indonesia, bahasa inggirs, teori kejuruan

#### Menambahkan Data Nilai Siswa
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/a898cda8-4930-4369-90a7-b919f1f1b7c2)

Pada halaman Staff TU ketika kita menginput semua field lalu menekan tombol tambah maka data nilai siswa tersebut akan tersimpan di database.

![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/e6dcb585-e349-4c55-ac77-d0b769d69e80)

### Menghapus Data Nilai Siswa
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/a4d900f4-5435-4191-b530-95d11121cf2c)

Pada halaman Staff TU ketika mengselect nilai yang ada ditabel lalu menekan tombol delete maka otomatis data nilai siswa tersebut akan terhapus dari database.

### Mengupdate Data Nilai Siswa
![image](https://github.com/PA-PBOxDBD/PA-PBO-DBD-KELOMPOK-24/assets/121856034/e42ed8c3-d75b-4664-b096-6363bf3e59b8)

Pada halaman Staff TU ketika mengselect nilai yang ada ditabel lalu mengganti nilai sesuai mata pelajaran lalu menekan tombol update maka otomatis data nilai siswa tersebut akan terupdate di database.
