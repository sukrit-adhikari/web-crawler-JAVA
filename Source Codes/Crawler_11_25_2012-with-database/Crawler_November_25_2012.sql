-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 25, 2012 at 05:21 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `crawler`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_found_in_webpage_url`
--

CREATE TABLE IF NOT EXISTS `tbl_found_in_webpage_url` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `webpage_id` int(5) NOT NULL,
  `found_in_webpage_url` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tbl_found_in_webpage_url`
--


-- --------------------------------------------------------

--
-- Table structure for table `tbl_found_in_webpage_url_backup`
--

CREATE TABLE IF NOT EXISTS `tbl_found_in_webpage_url_backup` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `webpage_id` int(5) NOT NULL,
  `found_in_webpage_url` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tbl_found_in_webpage_url_backup`
--


-- --------------------------------------------------------

--
-- Table structure for table `tbl_webpage`
--

CREATE TABLE IF NOT EXISTS `tbl_webpage` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `webpage_url` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tbl_webpage`
--


-- --------------------------------------------------------

--
-- Table structure for table `tbl_webpage_backup`
--

CREATE TABLE IF NOT EXISTS `tbl_webpage_backup` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `webpage_url` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tbl_webpage_backup`
--

