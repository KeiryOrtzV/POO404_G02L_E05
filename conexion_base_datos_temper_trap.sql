-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 26-09-2024 a las 01:43:30
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
-- Estructura de tabla para la tabla `detalles_pedido`
--

DROP TABLE IF EXISTS `detalles_pedido`;
CREATE TABLE IF NOT EXISTS `detalles_pedido` (
  `id_detalle` int NOT NULL AUTO_INCREMENT,
  `id_pedido` int NOT NULL,
  `id_plato` int NOT NULL,
  `cantidad` int NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `id_pedido` (`id_pedido`),
  KEY `id_plato` (`id_plato`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `detalles_pedido`
--

INSERT INTO `detalles_pedido` (`id_detalle`, `id_pedido`, `id_plato`, `cantidad`, `subtotal`) VALUES
(1, 7, 2, 1, 7.50),
(2, 8, 1, 1, 12.99),
(3, 8, 2, 1, 7.50),
(4, 8, 3, 1, 14.99),
(5, 8, 4, 1, 10.99),
(6, 8, 5, 1, 6.50),
(7, 9, 1, 1, 12.99),
(8, 9, 2, 1, 7.50),
(9, 10, 1, 1, 12.99),
(10, 10, 2, 1, 7.50),
(11, 11, 3, 1, 14.99),
(12, 12, 1, 1, 12.99),
(13, 12, 2, 1, 7.50),
(14, 13, 2, 1, 7.50),
(15, 13, 3, 1, 14.99),
(16, 14, 1, 1, 12.99),
(17, 14, 2, 1, 7.50),
(18, 15, 7, 1, 11.99),
(19, 16, 1, 1, 12.99),
(20, 16, 2, 1, 7.50),
(21, 17, 1, 1, 12.99),
(22, 17, 2, 1, 7.50),
(23, 18, 3, 1, 14.99),
(24, 18, 4, 1, 10.99),
(25, 18, 5, 1, 6.50),
(26, 19, 1, 1, 12.99),
(27, 19, 2, 1, 7.50),
(28, 19, 3, 1, 14.99),
(29, 20, 4, 1, 10.99),
(30, 20, 5, 1, 6.50),
(31, 21, 1, 1, 12.99),
(32, 21, 2, 1, 7.50),
(33, 21, 3, 1, 14.99),
(34, 22, 1, 1, 12.99),
(35, 22, 2, 1, 7.50),
(36, 22, 3, 1, 14.99),
(37, 22, 6, 1, 8.99),
(38, 22, 7, 1, 11.99),
(39, 22, 8, 1, 5.99),
(40, 23, 1, 1, 12.99),
(41, 23, 2, 1, 7.50),
(42, 23, 3, 1, 14.99),
(43, 23, 4, 1, 10.99),
(44, 23, 5, 1, 6.50),
(45, 23, 6, 1, 8.99),
(46, 23, 7, 1, 11.99),
(47, 23, 8, 1, 5.99),
(48, 24, 1, 1, 12.99),
(49, 24, 2, 1, 7.50),
(50, 25, 1, 1, 12.99),
(51, 25, 2, 1, 7.50),
(52, 25, 4, 1, 10.99),
(53, 25, 5, 1, 6.50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
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
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`id_plato`, `nombre_plato`, `descripcion`, `precio`, `disponibilidad`) VALUES
(1, 'Spaghetti a la pizza', 'Spaghetti con salsa bolognesa casera y queso parmesano.', 12.99, 1),
(2, 'Ensalada César', 'Lechuga fresca, crutones, queso parmesano y aderezo César.', 7.50, 1),
(3, 'Pollo a la Parrilla', 'Pechuga de pollo a la parrilla con guarnición de vegetales al vapor.', 14.99, 1),
(4, 'Pizza Margarita', 'Pizza con salsa de tomate, queso mozzarella y albahaca fresca.', 10.99, 1),
(5, 'Sopa de Tomate', 'Sopa cremosa de tomate con un toque de albahaca.', 6.50, 1),
(6, 'Tacos al Pastor', 'Tacos de cerdo marinado con piña, cilantro y cebolla.', 8.99, 1),
(7, 'Hamburguesa Clásica', 'Hamburguesa con carne de res, queso, lechuga, tomate y papas fritas.', 11.99, 1),
(8, 'Brownie con Helado', 'Brownie de chocolate servido con helado de vainilla.', 5.99, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_pedido` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` varchar(50) NOT NULL,
  `forma_pago` varchar(50) NOT NULL,
  `comentarios` text,
  `total` decimal(10,2) NOT NULL,
  `comentarios_empleado` text,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_empleado` (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `fecha_pedido`, `estado`, `forma_pago`, `comentarios`, `total`, `comentarios_empleado`, `id_usuario`) VALUES
(25, '2024-09-26 01:42:09', 'COMPLETADO', 'TARJETA', 'ricos', 37.98, NULL, NULL),
(21, '2024-09-26 01:39:11', 'COMPLETADO', 'EFECTIVO', 'ricos platos', 35.48, NULL, NULL),
(22, '2024-09-26 01:39:37', 'COMPLETADO', 'EFECTIVO', 'delicosos', 62.45, NULL, NULL),
(23, '2024-09-26 01:40:31', 'PENDIENTE', 'PENDIENTE', '', 79.94, NULL, NULL),
(24, '2024-09-26 01:40:55', 'COMPLETADO', 'EFECTIVO', 'Platos exquisitos', 20.49, NULL, NULL);

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
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
(11, 'lolo', 'lola1', 'empleado'),
(12, 'empleado1', '12345', 'empleado'),
(13, 'alexander', 'sapolio10', 'cliente'),
(14, 'alex', 'sapolio10', 'empleado');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
