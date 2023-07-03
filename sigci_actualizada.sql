-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-07-2023 a las 11:46:48
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sigci`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbcita`
--

CREATE TABLE `tbcita` (
  `IDCita` int(11) NOT NULL,
  `IdTipoCita` int(25) NOT NULL,
  `IdMedico` int(25) NOT NULL,
  `IdUsuario` int(15) NOT NULL,
  `Fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbcita`
--

INSERT INTO `tbcita` (`IDCita`, `IdTipoCita`, `IdMedico`, `IdUsuario`, `Fecha`) VALUES
(1, 2, 1, 1, '2023-07-20'),
(2, 1, 2, 2, '2023-07-22'),
(3, 2, 5, 3, '2023-07-19'),
(4, 2, 6, 4, '2023-07-22'),
(5, 1, 4, 5, '2023-07-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbespecialidad`
--

CREATE TABLE `tbespecialidad` (
  `IDEspecialidad` int(11) NOT NULL,
  `Especialidad` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbespecialidad`
--

INSERT INTO `tbespecialidad` (`IDEspecialidad`, `Especialidad`) VALUES
(1, 'Medicina General'),
(2, 'Odontología');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbhorario`
--

CREATE TABLE `tbhorario` (
  `IdHorario` int(15) NOT NULL,
  `HorarioN` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbhorario`
--

INSERT INTO `tbhorario` (`IdHorario`, `HorarioN`) VALUES
(1, 'Temprano'),
(2, 'Tarde');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbmedico`
--

CREATE TABLE `tbmedico` (
  `IdMedico` int(15) NOT NULL,
  `NombreM` varchar(40) NOT NULL,
  `ApellidoM` varchar(40) NOT NULL,
  `IdEspecialidad` int(15) NOT NULL,
  `IdHorario` int(15) NOT NULL,
  `Dni` int(15) NOT NULL,
  `Consultorio` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbmedico`
--

INSERT INTO `tbmedico` (`IdMedico`, `NombreM`, `ApellidoM`, `IdEspecialidad`, `IdHorario`, `Dni`, `Consultorio`) VALUES
(1, 'Ayman ', 'Guardiola Garces', 1, 1, 78578987, 101),
(2, 'Rocio ', 'Toledo Quevedo', 1, 1, 78977891, 102),
(3, 'Jose Tomas ', 'Borja Ballester', 1, 2, 99887458, 103),
(4, 'Isidro ', 'Morilla Segui', 1, 2, 78977892, 104),
(5, 'Gustavo ', 'Belmonte Torre', 2, 1, 88779966, 105),
(6, 'Joseba Alfonso ', 'Asensio Rivero', 2, 1, 99888874, 106),
(7, 'Prueba3', 'Prueba3', 1, 1, 13246545, 101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbtipocita`
--

CREATE TABLE `tbtipocita` (
  `IdTipoCita` int(11) NOT NULL,
  `TipoCita` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbtipocita`
--

INSERT INTO `tbtipocita` (`IdTipoCita`, `TipoCita`) VALUES
(1, 'Presencial'),
(2, 'Remota');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbusuario`
--

CREATE TABLE `tbusuario` (
  `IDUsuario` int(11) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Apellido` varchar(40) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbusuario`
--

INSERT INTO `tbusuario` (`IDUsuario`, `Nombre`, `Apellido`, `DNI`, `Correo`, `Password`, `Direccion`) VALUES
(1, 'Ander', 'Zurita', 77889977, 'AnderZurita@gmail.com', 'Ander', 'Avenida Los Castillos, 309'),
(2, 'Emiliano ', 'Betancor', 26940327, 'EmilianoBetancor@gmail.com', 'Emiliano', 'Tomas Valle 650 - Los Olivos'),
(3, 'Mario ', 'Sanchis', 91776941, 'MarioSanchis@gmail.com', 'Mario', 'Jiron Apurimac, 1218'),
(4, 'Matias', 'Cabanillas Alcazar', 96075232, 'MatiasCabanillas@gmail.com', 'Matias', 'Recavarren 524 - Miraflores'),
(5, 'Admin', 'Admin', 11111111, 'admin@admin.com', 'Admin', 'Admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbcita`
--
ALTER TABLE `tbcita`
  ADD PRIMARY KEY (`IDCita`),
  ADD KEY `IdTipoCita` (`IdTipoCita`,`IdMedico`,`IdUsuario`),
  ADD KEY `IdUsuario` (`IdUsuario`),
  ADD KEY `IdMedico` (`IdMedico`);

--
-- Indices de la tabla `tbespecialidad`
--
ALTER TABLE `tbespecialidad`
  ADD PRIMARY KEY (`IDEspecialidad`);

--
-- Indices de la tabla `tbhorario`
--
ALTER TABLE `tbhorario`
  ADD PRIMARY KEY (`IdHorario`);

--
-- Indices de la tabla `tbmedico`
--
ALTER TABLE `tbmedico`
  ADD PRIMARY KEY (`IdMedico`),
  ADD KEY `IdEspecialidad` (`IdEspecialidad`,`IdHorario`),
  ADD KEY `IdHorario` (`IdHorario`);

--
-- Indices de la tabla `tbtipocita`
--
ALTER TABLE `tbtipocita`
  ADD PRIMARY KEY (`IdTipoCita`);

--
-- Indices de la tabla `tbusuario`
--
ALTER TABLE `tbusuario`
  ADD PRIMARY KEY (`IDUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbcita`
--
ALTER TABLE `tbcita`
  MODIFY `IDCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tbespecialidad`
--
ALTER TABLE `tbespecialidad`
  MODIFY `IDEspecialidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbhorario`
--
ALTER TABLE `tbhorario`
  MODIFY `IdHorario` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbmedico`
--
ALTER TABLE `tbmedico`
  MODIFY `IdMedico` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tbtipocita`
--
ALTER TABLE `tbtipocita`
  MODIFY `IdTipoCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbusuario`
--
ALTER TABLE `tbusuario`
  MODIFY `IDUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbcita`
--
ALTER TABLE `tbcita`
  ADD CONSTRAINT `tbcita_ibfk_2` FOREIGN KEY (`IdTipoCita`) REFERENCES `tbtipocita` (`IdTipoCita`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbcita_ibfk_3` FOREIGN KEY (`IdUsuario`) REFERENCES `tbusuario` (`IDUsuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbcita_ibfk_4` FOREIGN KEY (`IdMedico`) REFERENCES `tbmedico` (`IdMedico`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbmedico`
--
ALTER TABLE `tbmedico`
  ADD CONSTRAINT `tbmedico_ibfk_1` FOREIGN KEY (`IdEspecialidad`) REFERENCES `tbespecialidad` (`IDEspecialidad`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbmedico_ibfk_2` FOREIGN KEY (`IdHorario`) REFERENCES `tbhorario` (`IdHorario`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
