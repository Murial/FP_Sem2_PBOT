-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 06, 2020 at 08:56 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grosir`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `idBarang` int(5) NOT NULL,
  `namaBarang` varchar(50) NOT NULL,
  `satuanBarang` varchar(20) NOT NULL,
  `hargaBarang` int(10) NOT NULL,
  `stokBarang` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`idBarang`, `namaBarang`, `satuanBarang`, `hargaBarang`, `stokBarang`) VALUES
(1, 'Minyak Goreng 1 Liter', 'Bungkus', 12000, 5),
(2, 'sabun cuci', 'bungkus', 15000, 5),
(3, 'Susu Kotak', 'Pack', 50000, 10);

-- --------------------------------------------------------

--
-- Table structure for table `beli`
--

CREATE TABLE `beli` (
  `idBeli` int(5) NOT NULL,
  `idBarang` int(5) NOT NULL,
  `idSupplier` int(5) NOT NULL,
  `tglBeli` datetime NOT NULL,
  `jmlBeli` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idCustomer` int(5) NOT NULL,
  `namaCustomer` varchar(50) NOT NULL,
  `alamatCustomer` varchar(100) NOT NULL,
  `telpCustomer` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jual`
--

CREATE TABLE `jual` (
  `idJual` int(5) NOT NULL,
  `idBarang` int(5) NOT NULL,
  `idCustomer` int(5) NOT NULL,
  `tglJual` datetime NOT NULL,
  `jmlJual` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `idSupplier` int(5) NOT NULL,
  `namaSupplier` varchar(50) NOT NULL,
  `alamatSupplier` varchar(100) NOT NULL,
  `telpSupplier` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`idBarang`),
  ADD KEY `idBarang` (`idBarang`);

--
-- Indexes for table `beli`
--
ALTER TABLE `beli`
  ADD PRIMARY KEY (`idBeli`),
  ADD KEY `idBeli` (`idBeli`),
  ADD KEY `idBarang` (`idBarang`),
  ADD KEY `idSupplier` (`idSupplier`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCustomer`),
  ADD KEY `idCustomer` (`idCustomer`);

--
-- Indexes for table `jual`
--
ALTER TABLE `jual`
  ADD PRIMARY KEY (`idJual`),
  ADD KEY `idJual` (`idJual`),
  ADD KEY `idBarang` (`idBarang`),
  ADD KEY `idCustomer` (`idCustomer`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`idSupplier`),
  ADD KEY `idSupplier` (`idSupplier`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `beli`
--
ALTER TABLE `beli`
  ADD CONSTRAINT `beli_ibfk_1` FOREIGN KEY (`idSupplier`) REFERENCES `supplier` (`idSupplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `beli_ibfk_2` FOREIGN KEY (`idBarang`) REFERENCES `barang` (`idBarang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `jual`
--
ALTER TABLE `jual`
  ADD CONSTRAINT `jual_ibfk_1` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jual_ibfk_2` FOREIGN KEY (`idBarang`) REFERENCES `barang` (`idBarang`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
