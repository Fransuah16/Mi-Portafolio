-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 08-02-2024 a las 00:39:50
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbfarmacia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Dni` int(8) NOT NULL,
  `Nombre` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `Apellido` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `Estado` bit(1) NOT NULL,
  `Id_Venta` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Dni`, `Nombre`, `Apellido`, `Estado`, `Id_Venta`) VALUES
(44443333, 'Juancho Enrique', 'Gutierrez Guiterrez', b'1', 2),
(72735986, 'Eduardiño Comercio', 'Estrativilos copio', b'1', 1),
(789456123, 'Gaspacho', 'Gutierrez', b'0', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `Id_F` int(15) NOT NULL,
  `Dni_Clie` int(8) NOT NULL,
  `Id_Prod` int(3) NOT NULL,
  `Id_Trab` int(15) NOT NULL,
  `Monedero_Ahorro` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`Id_F`, `Dni_Clie`, `Id_Prod`, `Id_Trab`, `Monedero_Ahorro`) VALUES
(1, 72735986, 123, 1, 'SI'),
(2, 44443333, 564, 2, 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `Id_P` int(3) NOT NULL,
  `Nombre` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `Precio` int(15) NOT NULL,
  `Marca` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `Estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`Id_P`, `Nombre`, `Precio`, `Marca`, `Estado`) VALUES
(123, 'Talco Para Pies', 200, 'Huggies', b'1'),
(564, 'Cera Lujosa', 56, 'Gorila', b'0'),
(777, 'Humectante', 500, 'Avon', b'0'),
(888, 'Shampoo PURA VIDA', 66, 'Elive', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `Id_T` int(11) NOT NULL,
  `Dni_T` int(11) NOT NULL,
  `Nombre` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `Apellidos` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `Cargo` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `Estado` int(11) NOT NULL,
  `Telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`Id_T`, `Dni_T`, `Nombre`, `Apellidos`, `Cargo`, `Estado`, `Telefono`) VALUES
(1, 78896512, 'Felices Tristin', 'Chicomin Espinoza', 'Operador', 1, 789456123),
(2, 55556892, 'Panfila', 'Estrella FLores', 'Operador', 1, 111234951);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Dni`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`Id_F`),
  ADD KEY `Dni_C1` (`Dni_Clie`),
  ADD KEY `Id_P2` (`Id_Prod`),
  ADD KEY `Id_T1` (`Id_Trab`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`Id_P`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`Id_T`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Dni` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=789456124;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `Id_F` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `Id_P` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=889;

--
-- AUTO_INCREMENT de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  MODIFY `Id_T` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`Dni_Clie`) REFERENCES `cliente` (`Dni`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`Id_Prod`) REFERENCES `producto` (`Id_P`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_3` FOREIGN KEY (`Id_Trab`) REFERENCES `trabajadores` (`Id_T`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
