-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: lab_crudrep
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `experience` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (3,'Дубовик Юрій Іванович',18,1),(4,'Самойлов Петро Андрійович',23,5),(5,'Гак Марина Миколаївна',25,5),(6,'Моршин Катерина Петрівна',22,3),(7,'Ступка Богдан Богданович',23,5),(8,'Антимійчук Микола Павлович',19,1),(9,'Блажчук Максим Олександрович',18,1),(10,'Бордюжан Борис Борисович',18,1),(12,'Дашкевич Каріна Андріївна',26,8),(13,'Блажчук Павло Олександрович',24,6),(14,'Бузілов Олексій Валентинович',19,1);
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist_and_genre`
--

DROP TABLE IF EXISTS `artist_and_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist_and_genre` (
  `id_artist` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_artist`,`genre`),
  KEY `fk_Artist_and_genre_Artist1_idx` (`id_artist`),
  KEY `id_genre_idx` (`genre`),
  CONSTRAINT `fk_Artist_and_genre_Artist1` FOREIGN KEY (`id_artist`) REFERENCES `artist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist_and_genre`
--

LOCK TABLES `artist_and_genre` WRITE;
/*!40000 ALTER TABLE `artist_and_genre` DISABLE KEYS */;
INSERT INTO `artist_and_genre` VALUES (4,'Драма'),(5,'Драма'),(5,'Комедія'),(5,'Мелодрама'),(6,'Квартет'),(7,'Драма'),(7,'Комедія'),(7,'Мелодрама'),(7,'Мюзикл'),(8,'Пейзаж'),(9,'Мюзикл'),(9,'Пародія'),(10,'Драма'),(12,'Пейзаж'),(12,'Портрет'),(12,'Скульптура'),(13,'Драма');
/*!40000 ALTER TABLE `artist_and_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist_and_impresario`
--

DROP TABLE IF EXISTS `artist_and_impresario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist_and_impresario` (
  `id_artist` int(11) NOT NULL,
  `id_impresario` int(11) NOT NULL,
  KEY `FKq28v9bmt3q0shq7b3k6523ln5` (`id_impresario`),
  KEY `FK7sjw0yqfdwe5mvju1xrdl6cvq` (`id_artist`),
  CONSTRAINT `FK4uepsgfxru6rqeakdj04v880l` FOREIGN KEY (`id_artist`) REFERENCES `artist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKq28v9bmt3q0shq7b3k6523ln5` FOREIGN KEY (`id_impresario`) REFERENCES `impresario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist_and_impresario`
--

LOCK TABLES `artist_and_impresario` WRITE;
/*!40000 ALTER TABLE `artist_and_impresario` DISABLE KEYS */;
INSERT INTO `artist_and_impresario` VALUES (5,1),(6,1),(7,2),(7,3),(8,8),(9,3),(10,8),(13,3),(13,4),(13,1);
/*!40000 ALTER TABLE `artist_and_impresario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `screen_size` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,'Кінотеатр \"Парасолька\"','вул. Перша 1',100),(2,'Кінопалац \"Великий\"','вул. Друга 2',120),(3,'Кінотеатр \"Мудрець\"','вул. Третя 3',130),(4,'Кінотеатр \"Ум\"','вул. Четверта 4',120),(5,'Кінотеатр \"Стандарт\"','вул. П\'ята 5',115),(6,'Кінотеатр \"Преміум\"','вул. Шоста 6',150),(7,'Кінотеатр \"Де-Люкс\"','вул. Сьома 7',200),(8,'Кінотеатр \"Домашній\"','площа Перша 1',140),(9,'Кінотеатр \"Міський\"','площа Друга 2',160),(10,'Кінопалац \"Ssaas\"','площа Третя 3',125),(11,'Кінотеатр \"Чернівці\"','вул. Героїв 6',100);
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinema_movie`
--

DROP TABLE IF EXISTS `cinema_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinema_movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `id_cinema` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmf659148l3lex7eopquvpxcdg` (`id_cinema`),
  CONSTRAINT `FKmf659148l3lex7eopquvpxcdg` FOREIGN KEY (`id_cinema`) REFERENCES `cinema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema_movie`
--

LOCK TABLES `cinema_movie` WRITE;
/*!40000 ALTER TABLE `cinema_movie` DISABLE KEYS */;
INSERT INTO `cinema_movie` VALUES (1,'Перший фільм','Фентезі',3,'2018-04-04'),(2,'Другий фільм','Комедія',2,'2018-05-04'),(3,'Третій фільм','Боєвик',3,'2018-03-04'),(4,'Четвертий фільм','Фантастика',4,'2018-02-18'),(5,'П\'ятий фільм','Детектив',5,'2018-02-21'),(6,'Шостий фільм','Тріллер',6,'2018-02-25'),(7,'Сьомий фільм','Детектив',7,'2018-02-23'),(8,'Восьмий фільм','Фантастика',8,'2018-02-27'),(9,'Дев\'ятий фільм','Комедія',9,'2018-02-10'),(10,'Десятфівий фільм','Боєвик',10,'2018-02-15');
/*!40000 ALTER TABLE `cinema_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert_hall`
--

DROP TABLE IF EXISTS `concert_hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concert_hall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert_hall`
--

LOCK TABLES `concert_hall` WRITE;
/*!40000 ALTER TABLE `concert_hall` DISABLE KEYS */;
INSERT INTO `concert_hall` VALUES (1,'Майданчик \"Перший\"','вул. Майданчиків 1',60),(2,'Майданчик \"Другий\"','вул. Майданчиків 2',70),(3,'Майданчик \"Третій\"','вул. Майданчиків 3',80),(4,'Майданчик \"Четвертий\"','вул. Майданчиків 4',90),(5,'Майданчик \"П\'ятий\"','вул. Майданчиків 5',100),(6,'Майданчик \"Шостий\"','вул. Майданчиків 6',110),(7,'Майданчик \"Сьомий\"','вул. Майданчиків 6',50),(8,'Майданчик \"Восьмий\"','вул. Майданчиків 7',60),(9,'Майданчик \"Дев\'ятий\"','вул. Майданчиків 8',70),(11,'Топ площадка','вул. Манки 4',100);
/*!40000 ALTER TABLE `concert_hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert_in_hall`
--

DROP TABLE IF EXISTS `concert_in_hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concert_in_hall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_concert_hall` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_organizer` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKij76yqo721c3flef45uk1gkvg` (`id_concert_hall`),
  KEY `FKddjadr8eiu7b0a8gpqrdtfm0u` (`id_organizer`),
  CONSTRAINT `FKddjadr8eiu7b0a8gpqrdtfm0u` FOREIGN KEY (`id_organizer`) REFERENCES `organizer` (`id`),
  CONSTRAINT `FKij76yqo721c3flef45uk1gkvg` FOREIGN KEY (`id_concert_hall`) REFERENCES `concert_hall` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert_in_hall`
--

LOCK TABLES `concert_in_hall` WRITE;
/*!40000 ALTER TABLE `concert_in_hall` DISABLE KEYS */;
INSERT INTO `concert_in_hall` VALUES (1,1,'Концерт №1',1,'2018-02-01'),(2,1,'Концерт №2',1,'2018-02-03'),(3,1,'Концерт №3',1,'2018-02-04'),(4,2,'Концерт №4',4,'2018-02-06'),(5,2,'Концерт №5',5,'2018-02-10'),(6,3,'Концерт №6',6,'2018-02-12'),(7,3,'Концерт №7',7,'2018-02-14'),(8,4,'Концерт №8',4,'2018-02-15'),(9,4,'Концерт №9',9,'2018-02-18'),(10,5,'Концерт №10',4,'2018-02-21'),(11,5,'Концерт №11',11,'2018-02-23'),(12,6,'Концерт №12',12,'2018-02-23'),(13,7,'Концерт №13',13,'2018-02-24'),(14,8,'Концерт №14',13,'2018-02-25');
/*!40000 ALTER TABLE `concert_in_hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contest_in_palace`
--

DROP TABLE IF EXISTS `contest_in_palace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contest_in_palace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_palace` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_organizer` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3oo78o4mqi2kw7lqk7597xxnj` (`id_organizer`),
  KEY `FKe9u3lf4it7s5w1dkyswgmiyj4` (`id_palace`),
  CONSTRAINT `FK3oo78o4mqi2kw7lqk7597xxnj` FOREIGN KEY (`id_organizer`) REFERENCES `organizer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKe9u3lf4it7s5w1dkyswgmiyj4` FOREIGN KEY (`id_palace`) REFERENCES `culture_palace` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contest_in_palace`
--

LOCK TABLES `contest_in_palace` WRITE;
/*!40000 ALTER TABLE `contest_in_palace` DISABLE KEYS */;
INSERT INTO `contest_in_palace` VALUES (1,1,'Конкурс-виставка \"Натюрморт\"',1,'2018-01-20'),(2,2,'Конкурс-виставка \"Різьблення\"',2,'2018-01-25'),(3,3,'Конкурс \"Портрет\"',3,'2018-02-01'),(4,4,'Конкурс \"Пейзаж\"',4,'2018-02-05'),(5,5,'Конкурс \"Диво-історія\"',5,'2018-02-10'),(6,1,'Конкурс \"Шрек\"',5,'2018-05-24');
/*!40000 ALTER TABLE `contest_in_palace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contest_results`
--

DROP TABLE IF EXISTS `contest_results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contest_results` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artist_id` int(11) NOT NULL,
  `contest_id` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `is_winner` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK19do3begd9bkyj92c8ykcmj6f` (`artist_id`),
  KEY `FKdxjl0iufu6hf7t7i5xj1omdmr` (`contest_id`),
  CONSTRAINT `FK19do3begd9bkyj92c8ykcmj6f` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`),
  CONSTRAINT `FKdxjl0iufu6hf7t7i5xj1omdmr` FOREIGN KEY (`contest_id`) REFERENCES `contest_in_palace` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contest_results`
--

LOCK TABLES `contest_results` WRITE;
/*!40000 ALTER TABLE `contest_results` DISABLE KEYS */;
INSERT INTO `contest_results` VALUES (10,3,1,1,'y'),(11,4,1,2,'y'),(12,5,1,3,'y'),(13,6,1,4,'n'),(14,7,1,5,'n');
/*!40000 ALTER TABLE `contest_results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `culture_palace`
--

DROP TABLE IF EXISTS `culture_palace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `culture_palace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `culture_palace`
--

LOCK TABLES `culture_palace` WRITE;
/*!40000 ALTER TABLE `culture_palace` DISABLE KEYS */;
INSERT INTO `culture_palace` VALUES (1,'Палац \"Диво\"','вул. Палаців 1',60),(2,'Палац \"Мальви\"','вул. Палаців 2',70),(3,'Палац \"Неймовірний\"','вул. Палаців 3',60),(4,'Палац \"Чудовий\"','вул. Палаців 4',50),(5,'Палац \"Фантазія\"','вул. Палаців 5',70),(6,'Культурний центр \"Магія\"','вул. Палаців 6',150),(7,'Культурний центр \"Історичний\"','вул. Палаців 7',60),(8,'Палац \"Стрибок у минуле\"','вул. Палаців 8',90),(9,'Культурний центр \"Мальовничий\"','вул. Палаців 9',70),(10,'Палац \"Одинокий\"','вул. Палаців 10',60);
/*!40000 ALTER TABLE `culture_palace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impresario`
--

DROP TABLE IF EXISTS `impresario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impresario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `experience` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impresario`
--

LOCK TABLES `impresario` WRITE;
/*!40000 ALTER TABLE `impresario` DISABLE KEYS */;
INSERT INTO `impresario` VALUES (1,'Бабенко Петро Михайлович',25,5),(2,'Димитрук Світлана Вікторівна',25,5),(3,'Ягоненко Микола Іванович',25,5),(4,'Дрінь Ярослав Михайлович',25,5),(5,'Столяр Іван Андрійович',25,5),(6,'Мур Дмитро Павлович',25,5),(7,'Стус Василь Семенович',25,5),(8,'Шевченко Ярослав Степанович',25,5),(9,'Шевчук Надія Іванівна',25,5),(10,'Степаненко Степан Степанович',25,5),(11,'Дмитренко Дмитро Дмитрович',25,5),(12,'Сковорода Олександр Максимович',25,5),(13,'Як Андрій Павлович',25,5);
/*!40000 ALTER TABLE `impresario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impresario_and_genre`
--

DROP TABLE IF EXISTS `impresario_and_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impresario_and_genre` (
  `id_impresario` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_impresario`,`genre`),
  CONSTRAINT `FKl3s0y63uasd85yr8pv11c4ci3` FOREIGN KEY (`id_impresario`) REFERENCES `impresario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impresario_and_genre`
--

LOCK TABLES `impresario_and_genre` WRITE;
/*!40000 ALTER TABLE `impresario_and_genre` DISABLE KEYS */;
INSERT INTO `impresario_and_genre` VALUES (1,'Драма'),(1,'Комедія'),(1,'Мелодрама'),(2,'Мелодрама'),(3,'Комедія'),(4,'Тріллер'),(5,'Мюзикл'),(7,'Мюзикл'),(7,'Фентезі'),(8,'Комедія'),(10,'Драма'),(11,'Мелодрама'),(11,'Мюзикл'),(12,'Мелодрама'),(13,'Драма');
/*!40000 ALTER TABLE `impresario_and_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizer`
--

DROP TABLE IF EXISTS `organizer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `experience` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizer`
--

LOCK TABLES `organizer` WRITE;
/*!40000 ALTER TABLE `organizer` DISABLE KEYS */;
INSERT INTO `organizer` VALUES (1,'Нестійко Марина Василівна',25,NULL),(2,'Марик Степан Васильович',25,NULL),(3,'Гринюк Денис Денисович',25,NULL),(4,'Деранчук Станіслав Ігоревич',25,NULL),(5,'Ігорчук Ігор Ігоревич',25,NULL),(6,'Стопанко Андрій Андрійович',25,NULL),(7,'Павленко Степан Павлович',25,NULL),(8,'Блунчук Лариса Іванівна',25,NULL),(9,'Торба Олексій Валентинович',25,NULL),(10,'Жаба Микола Андрійович',25,NULL),(11,'Санта Марія Григоріївна',25,NULL),(12,'Дмитриченко Ксенія Леонідівна',25,NULL),(13,'Дунай Григорій Васильович',25,NULL),(14,'Мельничук Євген Євгенійович',25,NULL);
/*!40000 ALTER TABLE `organizer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theatre`
--

DROP TABLE IF EXISTS `theatre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theatre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatre`
--

LOCK TABLES `theatre` WRITE;
/*!40000 ALTER TABLE `theatre` DISABLE KEYS */;
INSERT INTO `theatre` VALUES (1,'Театр \"Кобила\"','площа Театральна 1',50),(2,'Театр \"Класний\"','площа Театральна 1',60),(3,'Театр \"Класичний\"','площа Театральна 1',70),(4,'Театр \"Лісовик\"','площа Театральна 2',80),(5,'Театр \"Дивовижа\"','площа Театральна 3',90),(6,'Театр \"Ластівка\"','площа Театральна 4',100),(7,'Театр \"Гром\"','площа Театральна 5',90),(8,'Театр \"Молнія\"','площа Театральна 6',80),(9,'Театр \"Вогонь\"','площа Театральна 7',70),(10,'Театр \"На крихті льоду\"','площа Театральна 8',60);
/*!40000 ALTER TABLE `theatre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theatre_performance`
--

DROP TABLE IF EXISTS `theatre_performance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theatre_performance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `id_theatre` int(11) NOT NULL,
  `id_organizer` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlh1clln5x1tqwwi447vgqavej` (`id_organizer`),
  KEY `FKl1pjmx3fb24o8uop84b3kb23j` (`id_theatre`),
  CONSTRAINT `FKl1pjmx3fb24o8uop84b3kb23j` FOREIGN KEY (`id_theatre`) REFERENCES `theatre` (`id`),
  CONSTRAINT `FKlh1clln5x1tqwwi447vgqavej` FOREIGN KEY (`id_organizer`) REFERENCES `organizer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatre_performance`
--

LOCK TABLES `theatre_performance` WRITE;
/*!40000 ALTER TABLE `theatre_performance` DISABLE KEYS */;
INSERT INTO `theatre_performance` VALUES (1,'Перший виступ',1,1,'2018-02-14'),(2,'Другий виступ',2,1,'2018-01-27'),(3,'Третій виступ',3,2,'2018-02-04'),(4,'Четвертий виступ',4,3,'2018-02-07'),(5,'П\'ятий виступ',5,4,'2018-01-23'),(6,'Шостий виступ',6,5,'2018-03-02'),(7,'Сьомий виступ',7,6,'2018-03-03'),(8,'Восьмий виступ',8,7,'2018-03-04'),(9,'asdasd',1,1,'2018-04-20'),(11,'kokokoko',7,12,'2018-04-12');
/*!40000 ALTER TABLE `theatre_performance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-29  7:25:27
