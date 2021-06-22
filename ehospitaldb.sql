-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 22, 2021 at 05:32 AM
-- Server version: 5.7.31
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ehospitaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `a_id` varchar(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  `pass` varchar(15) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`a_id`),
  UNIQUE KEY `phone_no` (`phone_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`a_id`, `name`, `phone_no`, `pass`, `address`, `email`) VALUES
('a5', 'Joel Kurien', '9856321456', 'joel', 'Kerala', '201951183@iiitvadodara.ac.in'),
('a1', 'Ankur Tambe', '9998252337', 'ankur', 'Surat', '201951025@iiitvadodara.ac.in'),
('a2', 'Dhruv Singla', '9465818638', 'dhruv', 'Bathinda', '201951196@iiitvadodara.ac.in'),
('a3', 'Aashwin Raj', '7424961792', 'aashwin', 'Jamshedpur', '201951001@iiitvadodara.ac.in'),
('a4', 'Rohith', '8374201931', 'rohith', 'Telangana', '201951051@iiitvadodara.ac.in');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `d_id` varchar(3) NOT NULL,
  `d_name` varchar(35) NOT NULL,
  `no_of_rooms` int(11) DEFAULT NULL,
  `no_of_halls` int(11) DEFAULT NULL,
  `no_of_consultancy_rooms` int(11) DEFAULT NULL,
  `no_of_beds` int(11) DEFAULT NULL,
  `beds_occupied` int(11) DEFAULT NULL,
  `patient_discharge_average` int(11) DEFAULT NULL,
  `patient_admissionrate_average` int(11) DEFAULT NULL,
  PRIMARY KEY (`d_id`),
  UNIQUE KEY `d_name` (`d_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`d_id`, `d_name`, `no_of_rooms`, `no_of_halls`, `no_of_consultancy_rooms`, `no_of_beds`, `beds_occupied`, `patient_discharge_average`, `patient_admissionrate_average`) VALUES
('d1', 'OPD', 1, 1, 1, 10, NULL, NULL, NULL),
('d2', 'Orthopaedics Department', 7, 3, 2, 35, 20, 7, 6),
('d3', 'Opthalmology Department', 2, 2, 0, 10, 3, 5, 4),
('d4', 'Cardiology Department', 7, 3, 2, 20, 9, 8, 7),
('d5', 'Psychiatry Department', 5, 5, 1, 25, 15, 13, 7),
('d6', 'Neurology Department', 7, 3, 2, 20, 15, 12, 10),
('d7', 'Dermatology Department', 16, 1, 3, 30, 22, 50, 40),
('d8', 'Radiology Department', 2, 0, 0, 5, 5, 20, 20);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `Doc_ID` varchar(5) NOT NULL,
  `Doc_Name` varchar(30) DEFAULT NULL,
  `salary` decimal(9,2) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `degree_level` varchar(10) NOT NULL,
  `years_exp` int(11) DEFAULT NULL,
  `specialization` varchar(30) DEFAULT NULL,
  `night_shift_start` time DEFAULT NULL,
  `night_shift_end` time DEFAULT NULL,
  `patients_attended` int(11) DEFAULT NULL,
  `d_id` varchar(3) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  `pass` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Doc_ID`),
  UNIQUE KEY `phone_no` (`phone_no`),
  KEY `d_id` (`d_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Doc_ID`, `Doc_Name`, `salary`, `age`, `degree_level`, `years_exp`, `specialization`, `night_shift_start`, `night_shift_end`, `patients_attended`, `d_id`, `phone_no`, `pass`) VALUES
('D1001', 'Aditi Musunur', '2000000.00', 45, 'MBBS', 7, 'General Physician', '03:00:00', '06:00:00', 15, 'd1', '7856423615', 'aditi'),
('D1002', 'Barsati Sandipa', '3500000.00', 23, 'MD', 9, 'Orthopaedician', '19:30:00', '02:00:00', 6, 'd2', '5698742158', 'barsati'),
('D1003', 'Dhritiman Salim', '2500000.00', 50, 'B.Med', 12, 'Opthalomoligist', '20:30:00', '00:00:00', 10, 'd3', '1546327896', 'dhritiman'),
('D1004', 'Hardeep Suksma', '2300000.00', 37, 'MBChB', 9, 'Cadiologist', '18:45:00', '20:30:00', 7, 'd4', '7896214368', 'hardeep'),
('D1005', 'Gopa Trilochana', '5600000.00', 39, 'MBBS', 6, 'Psychiatrist', '20:00:00', '01:00:00', 18, 'd5', '8964217897', 'gopa'),
('D1006', 'Alexander Thomas', '4500000.00', 39, 'B.Med', 8, 'Neurologist', '21:30:00', '02:00:00', 20, 'd6', '8654932147', 'alexander'),
('D1007', 'Mohammad Hussain', '5600000.00', 45, 'MD', 9, 'Dermatologist', '22:30:00', '04:00:00', 17, 'd7', '8563214757', 'mohammad'),
('D1008', 'Alladin Gini', '8900000.00', 29, 'MBChB', 6, 'Orthopaedician', '23:30:00', '05:15:00', 24, 'd2', '5632147896', 'alladin'),
('D1009', 'Vijai Sritharan', '2300000.00', 35, 'MBBS', 7, 'Psychiatrist', '00:00:00', '07:45:00', 12, 'd5', '6321475896', 'vijai'),
('D1010', 'Avidosa Vaisaki', '7500000.00', 40, 'MD', 9, 'Cardiologist', '01:00:00', '06:45:00', 30, 'd4', '7896541257', 'avidosa');

-- --------------------------------------------------------

--
-- Table structure for table `equipments`
--

DROP TABLE IF EXISTS `equipments`;
CREATE TABLE IF NOT EXISTS `equipments` (
  `ventilator_in_use` int(11) DEFAULT NULL,
  `beds_in_use` int(11) DEFAULT NULL,
  `oxygen_cylinders_in_use` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hr`
--

DROP TABLE IF EXISTS `hr`;
CREATE TABLE IF NOT EXISTS `hr` (
  `HR_ID` varchar(5) NOT NULL,
  `HR_Name` varchar(30) DEFAULT NULL,
  `Salary` decimal(6,1) DEFAULT NULL,
  `timing` time DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  `pass` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`HR_ID`),
  UNIQUE KEY `phone_no` (`phone_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr`
--

INSERT INTO `hr` (`HR_ID`, `HR_Name`, `Salary`, `timing`, `phone_no`, `pass`) VALUES
('H2001', 'Shila Ali', '10000.0', '05:30:00', '8632145796', 'shila'),
('H2002', 'Ali Trivedi', '12000.0', '12:30:00', '5486321478', 'ali'),
('H2003', 'Trivedi Kumar', '11000.0', '13:30:00', '6985475214', 'trivedi'),
('H2004', 'Kumar Prajapati', '13000.0', '14:30:00', '8754632145', 'kumar'),
('H2005', 'Prajapati Sahil', '14000.0', '09:00:00', '8754412548', 'prajapati'),
('H2006', 'Sahil Verma', '12000.0', '10:00:00', '8654932145', 'sahil'),
('H2007', 'Verma Shah', '10000.0', '07:00:00', '8654796321', 'verma'),
('H2008', 'Shah Rukh Khan', '12000.0', '01:00:00', '5632458791', 'shah');

-- --------------------------------------------------------

--
-- Table structure for table `junior_doc`
--

DROP TABLE IF EXISTS `junior_doc`;
CREATE TABLE IF NOT EXISTS `junior_doc` (
  `jun_ID` varchar(5) NOT NULL,
  `salary` decimal(8,2) DEFAULT NULL,
  `jun_Name` varchar(30) DEFAULT NULL,
  `qualifications` varchar(30) NOT NULL,
  `years_exp` int(11) DEFAULT '0',
  `night_shift_start` time DEFAULT NULL,
  `night_shift_end` time DEFAULT NULL,
  `d_id` varchar(3) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  `pass` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`jun_ID`),
  UNIQUE KEY `phone_no` (`phone_no`),
  KEY `d_id` (`d_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `junior_doc`
--

INSERT INTO `junior_doc` (`jun_ID`, `salary`, `jun_Name`, `qualifications`, `years_exp`, `night_shift_start`, `night_shift_end`, `d_id`, `phone_no`, `pass`) VALUES
('J1001', '120000.00', 'Priya Rahul', 'B.Med', 4, '18:30:00', '20:00:00', 'd2', '6148521579', 'priya'),
('J1002', '140000.00', 'Aditya Amit', 'B.Med', 5, '00:00:00', '07:45:00', 'd3', '9632458716', 'aditya'),
('J1003', '200000.00', 'Mahesh Mohit', 'BMBS', 7, '01:00:00', '06:45:00', 'd5', '8563214754', 'mahesh'),
('J1004', '360000.00', 'Ankit Shayam', 'MD', 3, '23:30:00', '05:15:00', 'd4', '8523647915', 'ankit'),
('J1005', '150000.00', 'Raj Arjun', 'DPM', 0, '22:30:00', '04:00:00', 'd4', '6247531546', 'raj'),
('J1006', '140000.00', 'Ankur Manoj', 'DO', 4, '21:30:00', '02:00:00', 'd2', '9854763215', 'ankur'),
('J1007', '420000.00', 'Vinay Parth', 'B.Med', 5, '20:30:00', '00:00:00', 'd5', '8962435417', 'vinay'),
('J1008', '560000.00', 'Vivek Aaditya', 'MBBCh', 1, '20:00:00', '01:00:00', 'd7', '5362147986', 'vivek'),
('J1009', '400000.00', 'Neeraj Kumar', 'B.Med', 2, '03:00:00', '06:00:00', 'd6', '9632415784', 'neeraj'),
('J1010', '120000.00', 'Abhinav Soham', 'B.Med', 3, '18:45:00', '20:30:00', 'd1', '7456321549', 'abhinav');

-- --------------------------------------------------------

--
-- Table structure for table `jun_relation`
--

DROP TABLE IF EXISTS `jun_relation`;
CREATE TABLE IF NOT EXISTS `jun_relation` (
  `jun_ID` varchar(5) NOT NULL,
  `doc_ID` varchar(5) NOT NULL,
  PRIMARY KEY (`jun_ID`,`doc_ID`),
  KEY `doc_ID` (`doc_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jun_relation`
--

INSERT INTO `jun_relation` (`jun_ID`, `doc_ID`) VALUES
('J1001', 'D1008'),
('J1002', 'D1003'),
('J1003', 'D1009'),
('J1004', 'D1010'),
('J1005', 'D1004'),
('J1006', 'D1002'),
('J1007', 'D1005'),
('J1008', 'D1007'),
('J1009', 'D1006'),
('J1010', 'D1001');

-- --------------------------------------------------------

--
-- Table structure for table `lab`
--

DROP TABLE IF EXISTS `lab`;
CREATE TABLE IF NOT EXISTS `lab` (
  `lab_no` varchar(7) NOT NULL,
  `no_of_equipments` int(11) DEFAULT NULL,
  `type_of_test` varchar(50) NOT NULL,
  PRIMARY KEY (`lab_no`,`type_of_test`),
  UNIQUE KEY `type_of_test` (`type_of_test`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab`
--

INSERT INTO `lab` (`lab_no`, `no_of_equipments`, `type_of_test`) VALUES
('l1', 5, 'X-ray Test'),
('l2', 2, 'Eye Examination'),
('l3', 4, 'MRI and CT'),
('l4', 1, 'Psychometric test'),
('l5', 3, 'Blood Test'),
('l6', 4, 'Diascopy'),
('l7', 2, 'Medical Test');

-- --------------------------------------------------------

--
-- Table structure for table `lab_d`
--

DROP TABLE IF EXISTS `lab_d`;
CREATE TABLE IF NOT EXISTS `lab_d` (
  `lab_no` varchar(7) NOT NULL,
  `d_id` varchar(3) NOT NULL,
  PRIMARY KEY (`lab_no`,`d_id`),
  KEY `d_id` (`d_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab_d`
--

INSERT INTO `lab_d` (`lab_no`, `d_id`) VALUES
('l1', 'd1'),
('l1', 'd2'),
('l1', 'd4'),
('l1', 'd6'),
('l1', 'd7'),
('l2', 'd3'),
('l3', 'd2'),
('l3', 'd4'),
('l3', 'd6'),
('l3', 'd8'),
('l4', 'd5'),
('l5', 'd1'),
('l6', 'd7'),
('l7', 'd1');

-- --------------------------------------------------------

--
-- Table structure for table `lab_relation`
--

DROP TABLE IF EXISTS `lab_relation`;
CREATE TABLE IF NOT EXISTS `lab_relation` (
  `tech_ID` varchar(5) DEFAULT NULL,
  `doc_ID` varchar(5) DEFAULT NULL,
  `jun_ID` varchar(5) DEFAULT NULL,
  KEY `jun_ID` (`jun_ID`,`doc_ID`),
  KEY `doc_ID` (`doc_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab_relation`
--

INSERT INTO `lab_relation` (`tech_ID`, `doc_ID`, `jun_ID`) VALUES
('L1001', 'D1008', 'J1001'),
('L1002', 'D1009', 'J1003'),
('L1003', 'D1003', 'J1002'),
('L1004', 'D1010', 'J1004'),
('L1005', 'D1005', 'J1007'),
('L1006', 'D1007', 'J1008'),
('L1007', 'D1001', 'J1010');

-- --------------------------------------------------------

--
-- Table structure for table `lab_tech`
--

DROP TABLE IF EXISTS `lab_tech`;
CREATE TABLE IF NOT EXISTS `lab_tech` (
  `tech_ID` varchar(5) NOT NULL,
  `tech_Name` varchar(30) DEFAULT NULL,
  `salary` decimal(8,2) DEFAULT NULL,
  `qualifications` varchar(30) NOT NULL,
  `lab_no` varchar(7) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`tech_ID`),
  KEY `lab_no` (`lab_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab_tech`
--

INSERT INTO `lab_tech` (`tech_ID`, `tech_Name`, `salary`, `qualifications`, `lab_no`, `phone_no`) VALUES
('L1001', 'Harini Mathur', '120000.00', 'BSc. Medical Lab', 'l1', '9994563279'),
('L1002', 'Denny King', '200000.00', 'BSc. Psychiatry', 'l4', '8624397514'),
('L1003', 'Sammy Kumar', '150000.00', 'BSc. Medical Lab', 'l2', '8652347851'),
('L1004', 'Ali Trivedi', '420000.00', 'BSc. Medical Lab', 'l3', '4236879514'),
('L1005', 'Trish Killu', '120000.00', 'BSc. Medical Lab', 'l4', '5630147896'),
('L1006', 'Samu Kishi', '300000.00', 'BSc. Medical Lab', 'l6', '8962541755'),
('L1007', 'Donaoel Kit', '250000.00', 'BSc. Medical Lab', 'l5', '7854696255');

-- --------------------------------------------------------

--
-- Table structure for table `maintenance`
--

DROP TABLE IF EXISTS `maintenance`;
CREATE TABLE IF NOT EXISTS `maintenance` (
  `Main_ID` varchar(5) NOT NULL,
  `Salary` decimal(6,1) DEFAULT NULL,
  `Main_Name` varchar(30) DEFAULT NULL,
  `Main_Type` varchar(20) NOT NULL,
  `Street` varchar(10) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Main_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maintenance`
--

INSERT INTO `maintenance` (`Main_ID`, `Salary`, `Main_Name`, `Main_Type`, `Street`, `City`, `phone_no`) VALUES
('M3001', '5000.0', 'Anita Kumar', 'Cleaner', 'Dadabhai', 'Mumbai', '7856394127'),
('M3002', '2500.0', 'Rajeev Gandhi', 'Electrician', 'Colaba', 'Mumbai', '5487632158'),
('M3003', '1500.0', 'Mohit Kumar', 'Security', 'Peddar', 'Mumbai', '9864735874'),
('M3004', '3200.0', 'Jain Singhla', 'Security', 'Bandra', 'Mumbai', '8964712365'),
('M3005', '4500.0', 'Mathur Trivedi', 'Peon', 'Pali Hill', 'Mumbai', '8963214567'),
('M3006', '1600.0', 'Abhijoy Mandel', 'Sample Man', 'Hill Road', 'Mumbai', '7548962145'),
('M3007', '1520.0', 'Divya Bhaji', 'Cleaner', 'Linking Rd', 'Mumbai', '8965478821');

-- --------------------------------------------------------

--
-- Table structure for table `medical_history_1`
--

DROP TABLE IF EXISTS `medical_history_1`;
CREATE TABLE IF NOT EXISTS `medical_history_1` (
  `p_id` varchar(8) NOT NULL,
  `previous_operations` varchar(50) DEFAULT NULL,
  `disability` varchar(50) DEFAULT NULL,
  `previous_conditions` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medical_history_1`
--

INSERT INTO `medical_history_1` (`p_id`, `previous_operations`, `disability`, `previous_conditions`) VALUES
('P2', 'bone replacement', '-', 'Bone fracture in left knee'),
('P4', 'stunt placement', '-', 'Heart patient'),
('P5', '-', '-', 'Record of psychiatry problems'),
('P6', 'Neurosurgery', '-', 'Hit hard on head'),
('P11', 'ECR', '-', 'Heart patient');

-- --------------------------------------------------------

--
-- Table structure for table `medical_history_2`
--

DROP TABLE IF EXISTS `medical_history_2`;
CREATE TABLE IF NOT EXISTS `medical_history_2` (
  `p_id` varchar(8) NOT NULL,
  `previous_disease` varchar(30) DEFAULT NULL,
  `time_span_of_disease` varchar(15) DEFAULT NULL,
  `previous_medication` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medical_history_2`
--

INSERT INTO `medical_history_2` (`p_id`, `previous_disease`, `time_span_of_disease`, `previous_medication`) VALUES
('P1', 'Common cold', '2-3 years', 'Sinarest'),
('P9', 'Bone ache', '2-3 years', 'Supplements'),
('P10', 'Eye dryness', '1 year', 'Lubricant'),
('P7', 'Skin infection', '1-1.5 years', 'Antibiotics'),
('P8', 'OCD', '2-3 years', 'Sessions');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `p_id` varchar(8) NOT NULL,
  `admission_status` varchar(16) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `p_name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `no_of_tests_conducted` int(11) DEFAULT NULL,
  `ongoing_medication` varchar(20) DEFAULT NULL,
  `phone_no` varchar(10) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `d_id` varchar(8) DEFAULT NULL,
  `time_of_admission` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`p_id`),
  KEY `d_id` (`d_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`p_id`, `admission_status`, `city`, `state`, `p_name`, `age`, `no_of_tests_conducted`, `ongoing_medication`, `phone_no`, `gender`, `d_id`, `time_of_admission`) VALUES
('P1', 'admitted', 'Bathinda', 'Punjab', 'Tipun', 34, 1, 'Surgery required', '9465814789', 'male', 'd1', '2020-11-25 12:54:50'),
('P2', 'not admitted', 'Bathinda', 'Punjab', 'Sony', 34, 5, 'Nothing required', '9588814789', 'male', 'd2', '2020-10-08 11:54:50'),
('P3', 'admitted', 'Ludhiana', 'Punjab', 'Kiran', 28, 4, 'Treatment required', '9588518989', 'male', 'd3', '2020-12-18 14:20:50'),
('P4', 'admitted', 'Amritsar', 'Punjab', 'Kamaljeet', 50, 1, 'Treatment required', '9584589789', 'female', 'd4', '2020-11-26 04:54:50'),
('P5', 'not admitted', 'Moga', 'Punjab', 'Sukhwinder', 45, 3, 'Nothing required', '9584589000', 'male', 'd5', '2020-12-16 11:54:10'),
('P6', 'not admitted', 'Patiala', 'Punjab', 'Sarabjeet', 20, 2, 'Nothing required', '9584587090', 'male', 'd6', '2020-12-23 20:34:50'),
('P7', 'admitted', 'Batala', 'Punjab', 'Jaswinder', 48, 6, 'Surgery required', '9875478945', 'female', 'd7', '2020-12-02 02:54:05'),
('P8', 'admitted', 'Rampura', 'Punjab', 'Harnoor', 54, 1, 'Surgery required', '9889745445', 'male', 'd6', '2020-11-25 12:54:50'),
('P9', 'admitted', 'Bhucho', 'Punjab', 'Kimal', 60, 4, 'Treatment required', '9812345445', 'female', 'd1', '2020-12-09 23:34:10'),
('P10', 'admitted', 'Ambala', 'Punjab', 'Lala', 40, 5, 'Treatment required', '9812965124', 'male', 'd3', '2020-12-18 07:34:50'),
('P11', 'not admitted', 'Barnala', 'Punjab', 'Lakki', 40, 5, 'Patient no more', '9812547124', 'male', 'd4', '2020-12-14 19:50:30'),
('P12', 'not admitted', 'Kotakpura', 'Punjab', 'Lala', 40, 5, 'Patient no more', '9812969924', 'male', 'd6', '2020-12-31 15:14:50');

-- --------------------------------------------------------

--
-- Table structure for table `posthumus`
--

DROP TABLE IF EXISTS `posthumus`;
CREATE TABLE IF NOT EXISTS `posthumus` (
  `id` varchar(10) NOT NULL,
  `p_id` varchar(8) DEFAULT NULL,
  `timingofdeath` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `age` int(11) DEFAULT NULL,
  `cause_of_death` varchar(15) DEFAULT NULL,
  `address` varchar(90) DEFAULT NULL,
  `guardian_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `p_id` (`p_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `posthumus`
--

INSERT INTO `posthumus` (`id`, `p_id`, `timingofdeath`, `age`, `cause_of_death`, `address`, `guardian_name`) VALUES
('ps1', 'P11', '2021-01-25 12:54:50', 71, 'Heart Attack', '#589, Addy nagar, Barnal', 'Gurpreet'),
('ps2', 'P12', '2020-12-26 13:34:50', 65, 'Electric shock', '#89, Sabna nagar, Kotakpura', 'Jasmeet');

-- --------------------------------------------------------

--
-- Table structure for table `test_report`
--

DROP TABLE IF EXISTS `test_report`;
CREATE TABLE IF NOT EXISTS `test_report` (
  `tr_id` varchar(7) NOT NULL,
  `test_type` varchar(50) DEFAULT NULL,
  `lab_no` varchar(7) DEFAULT NULL,
  `p_id` varchar(8) NOT NULL,
  PRIMARY KEY (`tr_id`,`p_id`),
  KEY `lab_no` (`lab_no`,`test_type`),
  KEY `p_id` (`p_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_report`
--

INSERT INTO `test_report` (`tr_id`, `test_type`, `lab_no`, `p_id`) VALUES
('tr1', 'Medical Test', 'l7', 'P1'),
('tr2', 'X-ray Test', 'l1', 'P2'),
('tr3', 'Eye Examination', 'l2', 'P3'),
('tr4', 'MRI and CT', 'l3', 'P4'),
('tr5', 'Psychometric Test', 'l4', 'P5'),
('tr6', 'MRI and CT', 'l3', 'P6'),
('tr7', 'Diascopy', 'l6', 'P7'),
('tr8', 'X-Ray Test', 'l1', 'P8'),
('tr9', 'Medical Test', 'l7', 'P9'),
('tr10', 'Eye Examination', 'l2', 'P10');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
