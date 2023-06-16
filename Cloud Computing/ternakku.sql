-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 34.101.184.157
-- Waktu pembuatan: 10 Jun 2023 pada 10.01
-- Versi server: 5.7.40-google-log
-- Versi PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ternakku`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `disease_details`
--

CREATE TABLE `disease_details` (
  `disease_name` varchar(255) NOT NULL,
  `disease_detail` text NOT NULL,
  `handling_method` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `disease_details`
--

INSERT INTO `disease_details` (`disease_name`, `disease_detail`, `handling_method`) VALUES
('Cocciodiosis', 'Coccidiosis adalah penyakit parasit umum pada unggas yang disebabkan oleh protozoa dari genus Eimeria. Penyakit ini mempengaruhi saluran pencernaan dan dapat menyebabkan diare, penurunan berat badan, dan penurunan produksi telur.', 'Untuk mengelola Coccidiosis, penting untuk menjaga kebersihan yang baik di tempat pemeliharaan unggas, menyediakan air minum yang bersih, dan menggunakan obat anticoccidial yang sesuai.'),
('Healthy Chickens', 'Ayam Anda terlihat sehat.', 'Terus berikan nutrisi yang tepat, air bersih, dan jaga kebersihan yang baik untuk memastikan kesehatan mereka.'),
('Healthy Cows', 'Sapi Anda terlihat sehat.', 'Terus berikan nutrisi yang tepat, air bersih, dan jaga kebersihan yang baik untuk memastikan kesehatan mereka.'),
('Lumpy Cows', 'Penyakit sapi berbintik, juga dikenal sebagai Penyakit Kulit Berbintik Bovine (LSD), adalah penyakit viral yang mempengaruhi sapi. Penyakit ini ditandai dengan demam, nodul kulit, dan pembengkakan.', 'Untuk mengelola penyakit sapi berbintik, penting untuk mengisolasi hewan yang terinfeksi, menerapkan langkah pengendalian vektor, dan memberikan perawatan suportif. Konsultasikan dengan dokter hewan untuk opsi pengobatan yang spesifik.'),
('Salmonella', 'Salmonella adalah infeksi bakteri yang dapat mempengaruhi unggas maupun ternak. Penyakit ini dapat menyebabkan diare, dehidrasi, dan dalam kasus yang parah, kematian.', 'Untuk mengelola infeksi Salmonella, penting untuk menjaga kebersihan yang baik, menyediakan air minum yang bersih, dan menerapkan langkah biosekuriti. Pemberian antibiotik yang sesuai mungkin diperlukan setelah berkonsultasi dengan dokter hewan.');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users_disease_history`
--

CREATE TABLE `users_disease_history` (
  `userId` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `disease_name` varchar(255) NOT NULL,
  `img_url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `users_disease_history`
--

INSERT INTO `users_disease_history` (`userId`, `name`, `disease_name`, `img_url`) VALUES
('testtt', 'Khawaril', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230606195458.jpeg'),
('test', 'Khawaril', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230606224000.jpeg'),
('test', 'Khawaril', 'Healthy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230606224023.jpeg'),
('test', 'Khawaril', 'Healthy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230606224047.jpeg'),
('j2xmuBl9nRchu1Zp4AmJvcV3XUE2', 'wahyu test', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230607025042.jpeg'),
('j2xmuBl9nRchu1Zp4AmJvcV3XUE2', 'wahyu test', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230607025053.jpeg'),
('j2xmuBl9nRchu1Zp4AmJvcV3XUE2', 'wahyu test', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230607162108.jpeg'),
('SyjP8O3FUaaM7NSkGbryBd5URdz2', 'wahyu test2', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230607162234.jpeg'),
('SyjP8O3FUaaM7NSkGbryBd5URdz2', 'wahyu test2', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230607162246.jpeg'),
('XXbeFeKdqFW6qLFZBBxgWeE5XXj2', 'wahyu2', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230607164925.jpeg'),
('XXbeFeKdqFW6qLFZBBxgWeE5XXj2', 'wahyu2', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230607164935.jpeg'),
('fsOD0t1NWIgTlczO7AIEzeY9Rxy2', 'rifgi', 'Cocciodiosis', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230608041741.jpeg'),
('fsOD0t1NWIgTlczO7AIEzeY9Rxy2', 'rifgi', 'Cocciodiosis', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230608041752.jpeg'),
('fsOD0t1NWIgTlczO7AIEzeY9Rxy2', 'rifgi', 'Lumpy Cows', 'https://storage.googleapis.com/ternakku-predict-backend/predict-image-tmp/image_20230608063454.jpeg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
