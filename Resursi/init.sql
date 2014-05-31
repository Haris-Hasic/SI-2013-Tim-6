-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 31, 2014 at 08:17 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bazafdss`
--

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE IF NOT EXISTS `klijent` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAZIV` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `TIP` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `JIB` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `ADRESA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `MJESTO` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `TELEFON` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `WEB` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=21 ;

--
-- Table structure for table `uposlenik`
--

CREATE TABLE IF NOT EXISTS `uposlenik` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `PREZIME` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `JIB` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `ADRESA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `MJESTO` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `TELEFON` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `TIP` int(11) DEFAULT NULL,
  `USERNAME` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `PASSWORD` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `uposlenik`
--

INSERT INTO `uposlenik` (`ID`, `IME`, `PREZIME`, `JIB`, `ADRESA`, `MJESTO`, `TELEFON`, `EMAIL`, `TIP`, `USERNAME`, `PASSWORD`) VALUES
(1, 'admin', 'admin', '1504992173043', 'admin', 'admin', '+38732444555', 'admin@admin.com', 1, 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- --------------------------------------------------------

--
-- Table structure for table `uredjaj`
--

CREATE TABLE IF NOT EXISTS `uredjaj` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `JIBPROIZVODACA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `TIPUREDAJA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `IBFU` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `IBFM` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `KLIJENT` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_qr79q32gcm8m246hdbe9516r` (`KLIJENT`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=7 ;

--
-- Table structure for table `zadatak`
--

CREATE TABLE IF NOT EXISTS `zadatak` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ZAHTJEV` bigint(20) DEFAULT NULL,
  `SERVISER` bigint(20) DEFAULT NULL,
  `HITNOST` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `ZAVRSITIDO` date DEFAULT NULL,
  `ZAHTJEVPODNESEN` date DEFAULT NULL,
  `DONIJETIUREDJAJDO` date DEFAULT NULL,
  `ZAVRSEN` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_qwyg1ntm6l4bvf4d92vs8vp9s` (`ZAHTJEV`),
  KEY `FK_maac3lpjwq3lhhlij0jvdr87f` (`SERVISER`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=6 ;

--
-- Table structure for table `zahtjev`
--

CREATE TABLE IF NOT EXISTS `zahtjev` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UREDJAJ` bigint(20) DEFAULT NULL,
  `ZAHTJEVPODNESEN` date DEFAULT NULL,
  `ROK` date DEFAULT NULL,
  `ZAVRSEN` bit(1) DEFAULT NULL,
  `HITNO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_psn4if3ev7w09fn9y36gh2ndm` (`UREDJAJ`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=7 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `uredjaj`
--
ALTER TABLE `uredjaj`
  ADD CONSTRAINT `FK_qr79q32gcm8m246hdbe9516r` FOREIGN KEY (`KLIJENT`) REFERENCES `klijent` (`ID`);

--
-- Constraints for table `zadatak`
--
ALTER TABLE `zadatak`
  ADD CONSTRAINT `FK_maac3lpjwq3lhhlij0jvdr87f` FOREIGN KEY (`SERVISER`) REFERENCES `uposlenik` (`ID`),
  ADD CONSTRAINT `FK_qwyg1ntm6l4bvf4d92vs8vp9s` FOREIGN KEY (`ZAHTJEV`) REFERENCES `zahtjev` (`ID`);

--
-- Constraints for table `zahtjev`
--
ALTER TABLE `zahtjev`
  ADD CONSTRAINT `FK_psn4if3ev7w09fn9y36gh2ndm` FOREIGN KEY (`UREDJAJ`) REFERENCES `uredjaj` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
