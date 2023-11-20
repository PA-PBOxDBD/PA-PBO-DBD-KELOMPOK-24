-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Nov 2023 pada 15.45
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `haykal`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mata_pelajaran`
--

CREATE TABLE `mata_pelajaran` (
  `kode_mapel` char(10) NOT NULL,
  `nama_mapel` varchar(20) NOT NULL,
  `durasi_mapel` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mata_pelajaran`
--

INSERT INTO `mata_pelajaran` (`kode_mapel`, `nama_mapel`, `durasi_mapel`) VALUES
('A1', 'Bahasa Indonesia', '77'),
('A2', 'Matematika', '55'),
('A3', 'Bahasa Inggris', '54'),
('A4', 'Teori Kejuruan', '78');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilai`
--

CREATE TABLE `nilai` (
  `id_nilai` int(11) NOT NULL,
  `nilai` int(11) NOT NULL,
  `predikat` varchar(10) NOT NULL,
  `mata_pelajaran_kode_mapel` char(10) NOT NULL,
  `siswa_id_user` char(10) NOT NULL,
  `staff_tu_id_user` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `id_user` char(10) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`id_user`, `kelas`, `jenis_kelamin`) VALUES
('2209116003', 'XII AP 1', 'Perempuan'),
('2209116006', 'XII TKJ 1', 'Laki-Laki'),
('2209116018', 'XII TKJ 2', 'Laki-Laki'),
('2209116042', 'XII TKJ 2', 'Laki-Laki');

-- --------------------------------------------------------

--
-- Struktur dari tabel `staff_tu`
--

CREATE TABLE `staff_tu` (
  `id_user` char(10) NOT NULL,
  `no_telp` char(12) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `staff_tu`
--

INSERT INTO `staff_tu` (`id_user`, `no_telp`, `email`) VALUES
('2209116033', '083312445617', 'doniarya@gmail.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` char(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama`, `password`, `role`) VALUES
('2209116003', 'Sandrina Aulia', '123', 'Siswa'),
('2209116006', 'Dinnuhoni Trahutomo', '123', 'Siswa'),
('2209116018', 'M. Haykal Fajjar Aulia', '123', 'Siswa'),
('2209116033', 'Doni Arya Rachmadi', '123', 'Staff'),
('2209116042', 'Muhammad Fauzan Ghifari', '123', 'Siswa');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mata_pelajaran`
--
ALTER TABLE `mata_pelajaran`
  ADD PRIMARY KEY (`kode_mapel`);

--
-- Indeks untuk tabel `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`id_nilai`),
  ADD KEY `nilai_mata_pelajaran_FK` (`mata_pelajaran_kode_mapel`),
  ADD KEY `nilai_siswa_FK` (`siswa_id_user`),
  ADD KEY `nilai_staff_tu_FK` (`staff_tu_id_user`);

--
-- Indeks untuk tabel `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`id_user`);

--
-- Indeks untuk tabel `staff_tu`
--
ALTER TABLE `staff_tu`
  ADD PRIMARY KEY (`id_user`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `nilai`
--
ALTER TABLE `nilai`
  MODIFY `id_nilai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `nilai_mata_pelajaran_FK` FOREIGN KEY (`mata_pelajaran_kode_mapel`) REFERENCES `mata_pelajaran` (`kode_mapel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `nilai_siswa_FK` FOREIGN KEY (`siswa_id_user`) REFERENCES `siswa` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `nilai_staff_tu_FK` FOREIGN KEY (`staff_tu_id_user`) REFERENCES `staff_tu` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `siswa`
--
ALTER TABLE `siswa`
  ADD CONSTRAINT `siswa_user_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `staff_tu`
--
ALTER TABLE `staff_tu`
  ADD CONSTRAINT `staff_tu_user_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
