# --------------------------------------------------------
# Host:                         server00.online4youhotels.com
# Server version:               5.1.63-0+squeeze1
# Server OS:                    debian-linux-gnu
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2015-06-11 18:16:30
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

# Data exporting was unselected.


# Dumping structure for table hotelan.hl_cathegories
DROP TABLE IF EXISTS `hl_cathegories`;
CREATE TABLE IF NOT EXISTS `hl_cathegories` (
  `id` int(10) NOT NULL DEFAULT '0',
  `lang` varchar(10) NOT NULL DEFAULT '',
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`lang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table hotelan.hl_destinations
DROP TABLE IF EXISTS `hl_destinations`;
CREATE TABLE IF NOT EXISTS `hl_destinations` (
  `id` int(10) NOT NULL DEFAULT '0',
  `lang` varchar(10) NOT NULL DEFAULT '',
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`lang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table hotelan.hl_hotels
DROP TABLE IF EXISTS `hl_hotels`;
CREATE TABLE IF NOT EXISTS `hl_hotels` (
  `id` int(10) NOT NULL DEFAULT '0',
  `lang` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(500) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `typeDes` varchar(250) DEFAULT NULL,
  `catId` int(11) DEFAULT NULL,
  `catDes` varchar(250) DEFAULT NULL,
  `destinationId` int(11) DEFAULT NULL,
  `destinationDes` varchar(250) DEFAULT NULL,
  `zoneId` int(11) DEFAULT NULL,
  `zoneDes` varchar(250) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `zipCode` varchar(50) DEFAULT NULL,
  `region` varchar(500) DEFAULT NULL,
  `country` varchar(250) DEFAULT NULL,
  `telephone` varchar(250) DEFAULT NULL,
  `fax` varchar(250) DEFAULT NULL,
  `web` varchar(250) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `acces` longtext,
  `details` longtext,
  `mainImg` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`,`lang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table hotelan.hl_hotelsimages
DROP TABLE IF EXISTS `hl_hotelsimages`;
CREATE TABLE IF NOT EXISTS `hl_hotelsimages` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `hotelid` int(10) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table hotelan.hl_hoteltypes
DROP TABLE IF EXISTS `hl_hoteltypes`;
CREATE TABLE IF NOT EXISTS `hl_hoteltypes` (
  `id` varchar(10) NOT NULL DEFAULT '0',
  `lang` varchar(10) NOT NULL DEFAULT '',
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`lang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table hotelan.hl_roomtypes
DROP TABLE IF EXISTS `hl_roomtypes`;
CREATE TABLE IF NOT EXISTS `hl_roomtypes` (
  `id` int(10) NOT NULL DEFAULT '0',
  `lang` varchar(10) NOT NULL DEFAULT '',
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`lang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table hotelan.hl_zones
DROP TABLE IF EXISTS `hl_zones`;
CREATE TABLE IF NOT EXISTS `hl_zones` (
  `id` int(10) NOT NULL DEFAULT '0',
  `lang` varchar(10) NOT NULL DEFAULT '',
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`lang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
