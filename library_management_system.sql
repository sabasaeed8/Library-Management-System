-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2021 at 01:40 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library management system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID` int(50) NOT NULL,
  `Name` text NOT NULL,
  `FatherName` text NOT NULL,
  `DOB` date NOT NULL,
  `ContactNo` bigint(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `Name`, `FatherName`, `DOB`, `ContactNo`, `Email`, `Username`, `Password`, `Address`) VALUES
(24, 'alaya', 'roheen', '2000-03-17', 03210000000, 'alayaroheen97@gmail.com', 'alaya', 'roheen', 'lahore');


-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Author` varchar(50) NOT NULL,
  `Edition` int(11) NOT NULL,
  `Publisher` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ID`, `Name`, `Author`, `Edition`, `Publisher`, `Quantity`) VALUES
(24, 'oop', 'Umer', 1, 'Waseem', 8),
(25, 'laca', 'Ahmad', 2, 'Shuraim', 8),
(26, 'dld', 'saeed', 2, 'ahmed', 8),
(27, 'dm', 'saba', 4, 'mubeen', 2),
(28, 'pak study', 'anum', 2, 'sajid', 7),
(29, 'urdu', 'usman', 3, 'rehman', 8),
(30, 'kjkljk', 'kkjk', 3, 'lkl;kl;', 4);

-- --------------------------------------------------------

--
-- Table structure for table `delstudents`
--

CREATE TABLE `delstudents` (
  `ID` int(50) NOT NULL,
  `Name` text NOT NULL,
  `FatherName` text NOT NULL,
  `DOB` varchar(50) NOT NULL,
  `Department` varchar(255) NOT NULL,
  `RollNo` varchar(255) NOT NULL,
  `ContactNo` bigint(50) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `issuebook`
--

CREATE TABLE `issuebook` (
  `IssueId` int(50) NOT NULL,
  `AdminId` int(50) NOT NULL,
  `BookId` int(50) NOT NULL,
  `BookName` varchar(50) NOT NULL,
  `StudentId` int(50) NOT NULL,
  `StudentName` text NOT NULL,
  `RollNo` varchar(50) NOT NULL,
  `ContactNo` bigint(50) NOT NULL,
  `IssueDate` varchar(50) NOT NULL,
  `DueDate` varchar(50) NOT NULL,
  `IsReturned` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issuebook`
--



-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE `returnbook` (
  `AdminId` int(255) NOT NULL,
  `BookId` int(255) NOT NULL,
  `BookName` varchar(255) NOT NULL,
  `StudentId` int(255) NOT NULL,
  `StudentName` text NOT NULL,
  `RollNo` varchar(255) NOT NULL,
  `ContactNo` bigint(50) NOT NULL,
  `IssueDate` varchar(50) NOT NULL,
  `DueDate` varchar(50) NOT NULL,
  `ReturnDate` varchar(50) NOT NULL,
  `Fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `returnbook`
--



-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `FatherName` text NOT NULL,
  `DOB` date NOT NULL,
  `Department` varchar(50) NOT NULL,
  `RollNo` varchar(50) NOT NULL,
  `ContactNo` bigint(50) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`ID`, `Name`, `FatherName`, `DOB`, `Department`, `RollNo`, `ContactNo`, `Email`, `Username`, `Password`, `Address`) VALUES
(5, 'marriam', 'salman', '2021-03-25', 'Computer Science', '2019-CE-15', 03210000000, 'marriamsalman@gmail.com', 'marriam', '12345', 'lahore');


--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `issuebook`
--
ALTER TABLE `issuebook`
  ADD PRIMARY KEY (`IssueId`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID` (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `issuebook`
--
ALTER TABLE `issuebook`
  MODIFY `IssueId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
