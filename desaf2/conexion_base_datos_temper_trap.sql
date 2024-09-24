-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-09-2024 a las 00:36:26
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `conexion_base_datos_temper_trap`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` text,
  `password` varchar(255) DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `email`, `telefono`, `direccion`, `password`, `fecha_registro`) VALUES
(1, 'John Doe', 'john.doe@example.com', '555-1234', '123 Elm St, Springfield', 'password123', '2024-09-23 06:00:00'),
(2, 'Jane Smith', 'jane.smith@example.com', '555-5678', '456 Oak Ave, Metropolis', 'securePass987', '2024-09-23 06:00:00'),
(3, 'Carlos Pérez', 'carlos.perez@example.com', '555-2345', '789 Pine Rd, Gotham', 'password456', '2024-09-23 06:00:00'),
(4, 'Linda Nguyen', 'linda.nguyen@example.com', '555-3456', '101 Maple Dr, Star City', 'mypassword789', '2024-09-23 06:00:00'),
(5, 'Akira Tanaka', 'akira.tanaka@example.com', '555-4567', '202 Birch St, Central City', 'securePassword321', '2024-09-23 06:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

DROP TABLE IF EXISTS `detalle_pedido`;
CREATE TABLE IF NOT EXISTS `detalle_pedido` (
  `id_detalle` int NOT NULL AUTO_INCREMENT,
  `id_pedido` int DEFAULT NULL,
  `id_plato` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `id_pedido` (`id_pedido`),
  KEY `id_plato` (`id_plato`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` enum('cocinero','mesero','repartidor','administrador') NOT NULL,
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `id_plato` int NOT NULL AUTO_INCREMENT,
  `nombre_plato` varchar(100) DEFAULT NULL,
  `descripcion` text,
  `precio` decimal(10,2) DEFAULT NULL,
  `disponibilidad` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_plato`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL,
  `fecha_pedido` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` enum('aceptado','en_proceso','entregado_repartidor','entregado_cliente') DEFAULT 'aceptado',
  `forma_pago` enum('tarjeta','efectivo') NOT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `comentario_empleado` text,
  PRIMARY KEY (`id_pedido`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `rol` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `contraseña`, `rol`) VALUES
(10, 'cliente4', 'sapolio10', 'cliente'),
(2, 'ana_cliente', 'abcde', 'cliente'),
(3, 'pedro_empleado', 'admin123', 'empleado'),
(4, 'maria_empleado', 'passempleado', 'empleado'),
(5, 'cliente1', 'pass123', 'cliente'),
(6, 'cliente2', 'pass456', 'cliente'),
(7, 'cliente3', 'pass789', 'cliente'),
(8, 'empleado1', 'emp123', 'empleado'),
(9, 'empleado2', 'emp456', 'empleado'),
(11, 'lolo', 'lola1', 'empleado');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
