-- phpMyAdmin SQL Dump
-- this is for Mysql
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 19, 2010 at 01:51 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
DROP DATABASE IF EXISTS `security`;
create database security;
use security;
--
-- Database: `security`
--

-- --------------------------------------------------------

--
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
CREATE TABLE IF NOT EXISTS `applications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_name` char(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `application_name` (`application_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=57 ;

--
-- Dumping data for table `applications`
--

INSERT INTO `applications` (`id`, `application_name`) VALUES
(55, 'AcceptableBO'),
(23, 'APEXMenu'),
(34, 'ApparelSizeCategory'),
(20, 'AutoCurveForecast'),
(16, 'BrandParents'),
(17, 'Brands'),
(19, 'BusinessRuleMaintenance'),
(10, 'ColorParent'),
(1, 'ColorParentMatches'),
(2, 'Colors'),
(3, 'CoopPotential'),
(28, 'CostMasterMaintenance'),
(32, 'Departments'),
(33, 'Discounts'),
(4, 'Fabric'),
(5, 'FabricTexture'),
(12, 'HeelHeightRange'),
(11, 'HeelHeights'),
(25, 'HelpdeskInventory'),
(15, 'HeroColor'),
(35, 'ImageSeqs'),
(36, 'ImageSizes'),
(8, 'ItemColorActual'),
(37, 'Itemgender'),
(14, 'ItemLifestyle'),
(13, 'ItemSubstyles'),
(38, 'ItemXMatrixes'),
(39, 'ItemXParent'),
(40, 'ItemXParentMatches'),
(41, 'ItemXS'),
(42, 'ItemXSumSizes'),
(43, 'ItemYMatrixes'),
(44, 'ItemYParent'),
(53, 'ItemYParentMatches'),
(45, 'ItemYS'),
(46, 'ItemYSumSize'),
(31, 'ListControl-1.2.1'),
(6, 'MarkDownRules'),
(47, 'MatrixLayouts'),
(48, 'MatrixTypes'),
(9, 'OfferExclusions'),
(24, 'OrderTally'),
(27, 'PhotoMaster'),
(7, 'PrimaryUpper'),
(22, 'ProductionMenu'),
(29, 'PromotionalCostsMaintenance'),
(26, 'Run Control'),
(49, 'SalesVentures'),
(50, 'SourceCodeTypes'),
(51, 'StatusCodes'),
(54, 'SwatchSizes'),
(18, 'SylogsReports'),
(30, 'TestMasterUpdate'),
(52, 'TitleTypes'),
(56, 'UPC DATA'),
(21, 'UpdateNetOrigFrcst');

-- --------------------------------------------------------

--
-- Table structure for table `application_groups`
--

DROP TABLE IF EXISTS `application_groups`;
CREATE TABLE IF NOT EXISTS `application_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_app` (`group_id`,`application_id`),
  KEY `application_id` (`application_id`),
  KEY `group_id` (`group_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=172 ;

--
-- Dumping data for table `application_groups`
--

INSERT INTO `application_groups` (`id`, `application_id`, `group_id`) VALUES
(130, 26, 1),
(131, 27, 1),
(132, 28, 1),
(133, 29, 1),
(134, 30, 1),
(135, 31, 1),
(121, 9, 2),
(160, 56, 2),
(111, 16, 3),
(112, 17, 3),
(127, 16, 4),
(128, 17, 4),
(161, 1, 5),
(129, 15, 5),
(171, 19, 5),
(113, 1, 6),
(114, 2, 6),
(115, 3, 6),
(116, 4, 6),
(117, 5, 6),
(118, 6, 6),
(119, 7, 6),
(120, 8, 6),
(105, 9, 6),
(106, 10, 6),
(107, 11, 6),
(108, 12, 6),
(109, 13, 6),
(110, 14, 6),
(168, 19, 6),
(122, 10, 7),
(123, 11, 7),
(124, 12, 7),
(125, 13, 7),
(126, 14, 7),
(136, 32, 7),
(137, 33, 7),
(138, 34, 7),
(139, 35, 7),
(140, 36, 7),
(141, 37, 7),
(142, 38, 7),
(143, 39, 7),
(144, 40, 7),
(145, 41, 7),
(146, 42, 7),
(147, 43, 7),
(148, 44, 7),
(149, 45, 7),
(150, 46, 7),
(151, 47, 7),
(152, 48, 7),
(153, 49, 7),
(154, 50, 7),
(155, 51, 7),
(156, 52, 7),
(157, 53, 7),
(158, 54, 7),
(159, 55, 7),
(97, 1, 8),
(98, 2, 8),
(99, 3, 8),
(100, 4, 8),
(101, 5, 8),
(102, 6, 8),
(103, 7, 8),
(104, 8, 8),
(170, 19, 9);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` char(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_name` (`group_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `group_name`) VALUES
(8, 'BrandEdit'),
(6, 'BrandUsers'),
(9, 'ExclusionsUsers'),
(5, 'HeroColor'),
(3, 'ItemUsers'),
(4, 'Merchandisers'),
(1, 'PowerBuilder'),
(7, 'PowerUsers'),
(2, 'UPC');

-- --------------------------------------------------------

--
-- Table structure for table `group_assignments`
--

DROP TABLE IF EXISTS `group_assignments`;
CREATE TABLE IF NOT EXISTS `group_assignments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_user` (`group_id`,`user_id`),
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=133 ;

--
-- Dumping data for table `group_assignments`
--

INSERT INTO `group_assignments` (`id`, `user_id`, `group_id`) VALUES
(2, 'ale', 1),
(3, 'ayb', 1),
(4, 'blz', 1),
(5, 'cad', 1),
(19, 'clh', 1),
(6, 'djb', 1),
(7, 'djl', 1),
(18, 'dra', 1),
(8, 'eas', 1),
(9, 'jhm', 1),
(10, 'jms', 1),
(11, 'kjc', 1),
(12, 'lsb', 1),
(13, 'lxz', 1),
(14, 'lyb', 1),
(15, 'mab', 1),
(16, 'mkm', 1),
(17, 'oper', 1),
(1, 'sgrana', 1),
(20, 'slg', 1),
(23, 'jpd', 2),
(22, 'lmb', 2),
(21, 'lsb', 2),
(45, 'alb', 3),
(44, 'ale', 3),
(33, 'alm', 3),
(32, 'brw', 3),
(31, 'chs', 3),
(30, 'cjj', 3),
(29, 'cmb', 3),
(28, 'dcj', 3),
(27, 'dgk', 3),
(26, 'djb', 3),
(25, 'dxj', 3),
(43, 'gas', 3),
(126, 'gaw', 3),
(41, 'jpd', 3),
(40, 'jrk', 3),
(39, 'kag', 3),
(38, 'lmn', 3),
(37, 'lmz', 3),
(36, 'lyb', 3),
(35, 'mnj', 3),
(34, 'pmg', 3),
(24, 'slg', 3),
(46, 'smg', 3),
(47, 'srm', 3),
(48, 'alb', 4),
(49, 'brw', 4),
(50, 'cjj', 4),
(51, 'dxj', 4),
(52, 'jrk', 4),
(53, 'kag', 4),
(54, 'pmg', 4),
(55, 'alm', 5),
(56, 'cmb', 5),
(57, 'jpd', 5),
(58, 'lmn', 5),
(59, 'srm', 5),
(67, 'alb', 6),
(66, 'ale', 6),
(65, 'brw', 6),
(64, 'chs', 6),
(63, 'cjj', 6),
(62, 'dcj', 6),
(61, 'dgk', 6),
(60, 'djb', 6),
(79, 'dxj', 6),
(78, 'gas', 6),
(76, 'jpd', 6),
(75, 'jrk', 6),
(74, 'kag', 6),
(73, 'lmz', 6),
(72, 'lyb', 6),
(71, 'mnj', 6),
(70, 'pmg', 6),
(69, 'slg', 6),
(68, 'smg', 6),
(85, 'ale', 7),
(84, 'chs', 7),
(83, 'dcj', 7),
(82, 'dgk', 7),
(81, 'djb', 7),
(80, 'gas', 7),
(128, 'gaw', 7),
(129, 'jhm', 7),
(130, 'jms', 7),
(90, 'jpd', 7),
(89, 'lmz', 7),
(88, 'lyb', 7),
(87, 'slg', 7),
(86, 'smg', 7),
(97, 'ale', 8),
(96, 'chs', 8),
(95, 'dcj', 8),
(94, 'dgk', 8),
(93, 'djb', 8),
(92, 'gas', 8),
(103, 'jpd', 8),
(102, 'lmz', 8),
(101, 'lyb', 8),
(100, 'mnj', 8),
(99, 'slg', 8),
(98, 'smg', 8),
(110, 'ale', 9),
(109, 'alm', 9),
(132, 'cmb', 9),
(107, 'dcj', 9),
(106, 'dgk', 9),
(105, 'djb', 9),
(116, 'jpd', 9),
(115, 'lmn', 9),
(114, 'lyb', 9),
(113, 'slg', 9),
(112, 'smg', 9),
(111, 'srm', 9);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `UserID` varchar(20) NOT NULL,
  `username` char(20) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `username`) VALUES
('alb', 'April Jones'),
('ale', 'Angie Smith'),
('alm', 'Andrea Thompson'),
('ayb', 'Alissa Alpha'),
('blz', 'Brenda Beta'),
('brw', 'Billy Gamma'),
('cad', 'Cyndy Delta'),
('chs', 'Christina Epsilson'),
('cjj', 'Carol Japell'),
('clh', 'Carrie Hurley-Marker'),
('cmb', 'Cathy Becker'),
('dcj', 'Dawn Powell'),
('dgk', 'Dave Buster'),
('djb', 'Dave Blandingsworth'),
('djl', 'Debra Lawson'),
('dra', 'Dan Alpaca'),
('dxj', 'Drew Jewison'),
('eas', 'Liz Samuels'),
('gas', 'Gen Spaeth'),
('gaw', 'George Wolefenstein'),
('jhm', 'Jane Maryson'),
('jms', 'Janie Bettysborth'),
('jpd', 'Joel Deign'),
('jrk', 'John Kip'),
('kag', 'Kim Brassworkth'),
('kjc', 'Kathy Constantine'),
('lmb', 'Lisa Blossom'),
('lmn', 'Lana Nebbish'),
('lmz', 'Luann Zap'),
('lsb', 'Lucille Betson'),
('lxz', 'Lynn Ziglier'),
('lyb', 'Logan Boson'),
('mab', 'Marietta Ballon'),
('mkm', 'Mary Mattson'),
('mnj', 'Michelle Johnson'),
('oper', 'Olga PE Robeson'),
('pmg', 'Paula Ganymede'),
('sgrana', 'Sara Grandstand'),
('slg', 'Sam Garfnarf'),
('smg', 'Sue Glendale'),
('srm', 'Shannon Missouri');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application_groups`
--
ALTER TABLE `application_groups`
  ADD CONSTRAINT `application_groups_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  ADD CONSTRAINT `application_groups_ibfk_2` FOREIGN KEY (`application_id`) REFERENCES `applications` (`id`);

--
-- Constraints for table `group_assignments`
--
ALTER TABLE `group_assignments`
  ADD CONSTRAINT `group_assignments_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  ADD CONSTRAINT `group_assignments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`UserID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
