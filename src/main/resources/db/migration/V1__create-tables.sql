-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: c16-47-n-java
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
                           `id_carrito` int(11) NOT NULL AUTO_INCREMENT,
                           `id_usuario` int(11) DEFAULT NULL,
                           `id_producto` int(11) DEFAULT NULL,
                           `cantidad` int(11) DEFAULT NULL,
                           `total` decimal(38,2) DEFAULT NULL,
                           `fecha` date DEFAULT NULL,
                           PRIMARY KEY (`id_carrito`),
                           KEY `id_usuario` (`id_usuario`),
                           KEY `id_producto` (`id_producto`),
                           CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
                           CONSTRAINT `carrito_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `favoritos`
--

DROP TABLE IF EXISTS `favoritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favoritos` (
                             `id_fav` int(11) NOT NULL AUTO_INCREMENT,
                             `id_usuario` int(11) DEFAULT NULL,
                             `id_producto` int(11) DEFAULT NULL,
                             PRIMARY KEY (`id_fav`),
                             KEY `id_usuario` (`id_usuario`),
                             KEY `id_producto` (`id_producto`),
                             CONSTRAINT `favoritos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
                             CONSTRAINT `favoritos_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
                          `id_imagen` int(11) NOT NULL AUTO_INCREMENT,
                          `mime` varchar(255) DEFAULT NULL,
                          `nombre` varchar(255) DEFAULT NULL,
                          `contenido` blob DEFAULT NULL,
                          PRIMARY KEY (`id_imagen`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenes` (
                           `id_orden` int(11) NOT NULL AUTO_INCREMENT,
                           `id_carrito` int(11) DEFAULT NULL,
                           `fecha_orden` date DEFAULT NULL,
                           `estado` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id_orden`),
                           KEY `id_carrito` (`id_carrito`),
                           CONSTRAINT `ordenes_ibfk_1` FOREIGN KEY (`id_carrito`) REFERENCES `carrito` (`id_carrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
                            `id_producto` int(11) NOT NULL AUTO_INCREMENT,
                            `nombre` varchar(255) DEFAULT NULL,
                            `categoria` varchar(255) DEFAULT NULL,
                            `descripcion` text DEFAULT NULL,
                            `precio` decimal(38,2) DEFAULT NULL,
                            `imagen` varchar(255) DEFAULT NULL,
                            `calificacion` decimal(38,2) DEFAULT NULL,
                            `favoritos` int(11) DEFAULT NULL,
                            `stock` int(11) DEFAULT NULL,
                            PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
                           `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
                           `username` varchar(255) DEFAULT NULL,
                           `email` varchar(255) DEFAULT NULL,
                           `password` varchar(255) DEFAULT NULL,
                           `id_imagen` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id_usuario`),
                           KEY `id_imagen` (`id_imagen`),
                           CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_imagen`) REFERENCES `imagen` (`id_imagen`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-11 13:06:03
