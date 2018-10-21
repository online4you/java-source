# --------------------------------------------------------
# Host:                         server00.online4youhotels.com
# Server version:               5.1.63-0+squeeze1
# Server OS:                    debian-linux-gnu
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2015-06-11 18:16:12
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping structure for table hotelan.hl_boardtypes
DROP TABLE IF EXISTS `hl_boardtypes`;
CREATE TABLE IF NOT EXISTS `hl_boardtypes` (
  `id` varchar(10) NOT NULL DEFAULT '',
  `lang` varchar(10) NOT NULL DEFAULT '',
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`lang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table hotelan.hl_boardtypes: 10 rows
DELETE FROM `hl_boardtypes`;
/*!40000 ALTER TABLE `hl_boardtypes` DISABLE KEYS */;
INSERT INTO `hl_boardtypes` (`id`, `lang`, `description`) VALUES
	('HH', 'es', 'Sólo Alojamiento'),
	('HD', 'es', 'Alojamiento y Desayuno'),
	('MP', 'es', 'Media Pensión'),
	('PC', 'es', 'Pensión Completa'),
	('AI', 'es', 'Todo Incluido'),
	('HH', 'en', 'Room Only'),
	('HD', 'en', 'Bed And Breakfast'),
	('MP', 'en', 'Half Board'),
	('PC', 'en', 'Full Board'),
	('AI', 'en', 'All Inclusive');
/*!40000 ALTER TABLE `hl_boardtypes` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
