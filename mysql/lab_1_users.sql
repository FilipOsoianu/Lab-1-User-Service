CREATE DATABASE  IF NOT EXISTS `lab_1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lab_1`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: lab_1
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (19,'laurentiu','Ceban','ionCena@fafa.com','0031-02-10'),(20,'laurentiu','Ciocan','laure@te_vreau.com','1998-07-06'),(21,'laurentiu','Ceban','ionCena@fafa.com','0031-02-10'),(22,'laurentiu','Ceban','ionCena@fafa.com','0031-02-10'),(23,'laurentiu','Ceban','ionCena@fafa.com','0031-02-10'),(24,'laurentiu','Ceban','ionCena@fafa.com','0031-02-10'),(25,'laurentiu','Ciocan','laure@te_vreau.com','1998-07-06'),(26,'laurentiu','Ceban','ionCena@fafa.com','0031-02-10'),(27,'laurentiu','Ceban','ionCena@fafa.com','0031-02-10'),(28,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(29,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(30,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(31,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(32,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(33,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(34,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(35,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(36,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(37,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(38,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(39,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(40,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(41,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(42,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(43,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(44,'laurentiu','ciocan','ionCena@fafa.com','0031-02-10'),(47,'laurentiu','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(48,'laurentiu','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(49,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(50,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(51,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(52,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(53,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(54,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(55,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','1989-09-25'),(56,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','1989-09-25'),(57,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','1989-09-25'),(58,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','1989-09-25'),(59,'laurentdadadadaiu','ciocan','ionCendadaaa@fafa.com','1989-09-25'),(60,'dadafa','ciocan','ionCendadaaa@fafa.com','1989-09-25'),(61,'dadafa','ciocan','ionCendadaaa@fafa.com','1989-09-25'),(62,'dadafa','ciocan','ionCendadaaa@fafa.com','1989-09-25'),(63,'dadafa','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(64,'dadafa','ciocan','ionCendadaaa@fafa.com','0031-02-10'),(65,'dadafa','cidadocan','ionCendadaaa@fafa.com','1989-09-25'),(66,'dadafa','cidadocan','ionCendadaaa@fafa.com','1989-09-25'),(67,'dadafa','cidadocan','ionCendadaaa@fafa.com','1989-09-25'),(68,'dadafa','cidadocan','ionCendadaaa@fafa.com','1989-09-23'),(69,'dadafa','cidadocan','ionCendadaaa@fafa.com','1989-09-23'),(70,'dadafa','cidadocan','ionCendadaaa@fafa.com','1989-09-23');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-18 17:57:57
