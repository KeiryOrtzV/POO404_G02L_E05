-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 25-09-2024 a las 23:32:44
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
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
(20, 16, 2, 1, 7.50);

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
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `fecha_pedido`, `estado`, `forma_pago`, `comentarios`, `total`, `comentarios_empleado`, `id_usuario`) VALUES
(1, '2024-09-25 16:09:29', 'PENDIENTE', 'PENDIENTE', '', 20.49, NULL, NULL),
(2, '2024-09-25 16:15:06', 'PENDIENTE', 'PENDIENTE', '', 79.94, NULL, NULL),
(3, '2024-09-25 16:19:40', 'PENDIENTE', 'PENDIENTE', '', 20.49, NULL, NULL),
(4, '2024-09-25 16:31:17', 'PENDIENTE', 'PENDIENTE', '', 12.99, NULL, NULL),
(5, '2024-09-25 16:53:14', 'PENDIENTE', 'PENDIENTE', '', 12.99, NULL, NULL),
(6, '2024-09-25 16:58:53', 'PENDIENTE', 'PENDIENTE', '', 7.50, NULL, NULL),
(7, '2024-09-25 17:04:23', 'PENDIENTE', 'PENDIENTE', '', 7.50, NULL, NULL),
(8, '2024-09-25 17:05:27', 'PENDIENTE', 'PENDIENTE', '', 52.97, NULL, NULL),
(9, '2024-09-25 17:06:49', 'PENDIENTE', 'PENDIENTE', '', 20.49, NULL, NULL),
(10, '2024-09-25 17:08:16', 'PENDIENTE', 'PENDIENTE', '', 20.49, NULL, NULL),
(11, '2024-09-25 17:19:47', 'PENDIENTE', 'PENDIENTE', '', 14.99, NULL, NULL),
(12, '2024-09-25 17:24:06', 'PENDIENTE', 'PENDIENTE', '', 20.49, NULL, NULL),
(13, '2024-09-25 17:27:29', 'PENDIENTE', 'PENDIENTE', '', 22.49, NULL, NULL),
(14, '2024-09-25 17:34:30', 'PENDIENTE', 'PENDIENTE', '', 20.49, NULL, NULL),
(15, '2024-09-25 17:35:34', 'PENDIENTE', 'PENDIENTE', '', 11.99, NULL, NULL),
(16, '2024-09-25 17:37:30', 'PENDIENTE', 'PENDIENTE', '', 20.49, NULL, NULL);

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
