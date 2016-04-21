-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-04-2016 a las 00:07:36
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `valleycarga`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bodega`
--

CREATE TABLE `bodega` (
  `bodegaID` int(11) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `ciudadID` int(11) NOT NULL,
  `Telefono` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

CREATE TABLE `ciudades` (
  `ciudadID` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `departamentoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudades`
--

INSERT INTO `ciudades` (`ciudadID`, `nombre`, `departamentoID`) VALUES
(5, 'Leticia', 1),
(6, 'Medellín', 2),
(7, 'Arauca', 3),
(8, 'Barranquilla', 4),
(9, 'Cartagena', 5),
(10, 'Tunja', 6),
(11, 'Manizales', 7),
(12, 'Florencia', 8),
(13, 'Yopal', 9),
(14, 'Popayan', 10),
(15, 'Valledupar', 11),
(16, 'Quibdó', 12),
(17, 'Montería', 13),
(18, 'Bogota', 14),
(19, 'Puerto Inírida', 15),
(20, 'San José del Guaviare', 16),
(21, 'Neiva', 17),
(22, 'Riohacha', 18),
(23, 'Santa Marta', 19),
(24, 'Villavicencio', 20),
(25, 'Pasto', 21),
(26, 'Cúcuta', 22),
(27, 'Mocoa', 23),
(28, 'Armenia', 24),
(29, 'Pereira', 25),
(30, 'San Andres', 26),
(31, 'Bucaramanga', 27),
(32, 'Sincelejo', 28),
(33, 'Ibagué', 29),
(34, 'Cali', 30),
(35, 'Mitú', 31),
(36, 'Puerto Carreño', 32),
(37, 'Mitú', 31),
(38, 'Puerto Carreño', 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `departamentoID` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`departamentoID`, `nombre`) VALUES
(1, 'Amazonas'),
(2, 'Antioquia'),
(3, 'Arauca:'),
(4, 'Atlantico'),
(5, 'Bolivar'),
(6, 'Boyacá'),
(7, 'Caldas'),
(8, 'Caquetá'),
(9, 'Casanare'),
(10, 'Cauca'),
(11, 'Cesar'),
(12, 'Chocó'),
(13, 'Córdoba'),
(14, 'Cundinamarca'),
(15, 'Guainía'),
(16, 'Guaviare'),
(17, 'Huila'),
(18, 'La Guajira'),
(19, 'Magdalena'),
(20, 'Meta'),
(21, 'Nariño'),
(22, 'Norte de Santander'),
(23, 'Putumayo'),
(24, 'Quindio'),
(25, 'Risaralda'),
(26, 'San Andres y Providencia'),
(27, 'Santander'),
(28, 'Sucre'),
(29, 'Tolima'),
(30, 'Valle del Cauca'),
(31, 'Vaupés'),
(32, 'Vichada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `cedula` bigint(20) NOT NULL,
  `sucursalID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `facturaID` int(11) NOT NULL,
  `ciudad_origen` int(11) NOT NULL,
  `ciudad_destino` int(11) NOT NULL,
  `destinatario` bigint(20) NOT NULL,
  `remitente` bigint(20) NOT NULL,
  `paqueteID` int(11) NOT NULL,
  `valor` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `sucursal_origen` int(11) NOT NULL,
  `sucursal_destino` int(11) NOT NULL,
  `cajero` bigint(20) NOT NULL,
  `valor_declarado` int(11) NOT NULL,
  `tarifaID` int(11) NOT NULL,
  `forma_pago` varchar(30) NOT NULL,
  `tiempo_entrega` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_vehiculos`
--

CREATE TABLE `factura_vehiculos` (
  `facturaID` int(11) NOT NULL,
  `vehiculoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_paquete`
--

CREATE TABLE `historial_paquete` (
  `historial_PID` int(11) NOT NULL,
  `paqueteID` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `accion` varchar(30) NOT NULL,
  `usuario_a` bigint(20) NOT NULL,
  `estado_nuevo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_vehiculos`
--

CREATE TABLE `historial_vehiculos` (
  `historial_vID` int(11) NOT NULL,
  `vehiculoID` int(11) NOT NULL,
  `cedula` bigint(20) NOT NULL,
  `usuario_a` bigint(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `mensajeID` int(11) NOT NULL,
  `remitente` bigint(20) NOT NULL,
  `destinatario` bigint(20) NOT NULL,
  `mensaje` text NOT NULL,
  `estado_mensaje` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes`
--

CREATE TABLE `paquetes` (
  `paqueteID` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `volumen` int(11) NOT NULL,
  `embalaje` varchar(30) NOT NULL,
  `detalle` varchar(30) NOT NULL,
  `tipo_paquete` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL,
  `vehiculoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE `perfil` (
  `perfilID` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `permisos` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`perfilID`, `tipo`, `descripcion`, `permisos`) VALUES
(1, 'Gerente', 'Administra el Sistema', 'Todos'),
(2, 'Coordinador de Rutas', 'Asigna Rutas', 'Consultar,Modificar,Eliminar '),
(3, 'Comercial ', 'Recibe paquetes', 'paquetes,registrar'),
(4, 'Conductor', 'Conduce un vehiculo', 'ver turnos'),
(5, 'Bodega', 'Administrar Paquetes', 'Paquetes'),
(6, 'Cliente', 'Enviar Paquetes', 'Paquetes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil_usuarios`
--

CREATE TABLE `perfil_usuarios` (
  `perfil_usuariosID` int(11) NOT NULL,
  `cedula` bigint(20) NOT NULL,
  `perfilID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `rutaID` int(12) NOT NULL,
  `ciudad_origen` int(11) NOT NULL,
  `ciudad_destino` int(11) NOT NULL,
  `Tiempo` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`rutaID`, `ciudad_origen`, `ciudad_destino`, `Tiempo`) VALUES
(1, 9, 10, '213');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE `sucursales` (
  `sucursalID` int(11) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `ciudadID` int(11) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `barrio` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`sucursalID`, `direccion`, `ciudadID`, `telefono`, `barrio`, `correo`, `nombre`) VALUES
(1, 'av 45 n° 34-89', 15, '3265489', 'quiroga', 'k.y.rp@hotmail.com', 'valley1'),
(2, 'diagonal 15 N 15-45', 6, '6258955', 'Leon Xlll', 'valleyCarga@gmail.com', 'moron'),
(3, 'Carrera 26 N64-51', 14, '2403084', 'Siete de Agosto', 'nd.gutierrezb@gmail.com', 'Agosto'),
(4, 'cra 3 n° 50-34', 13, '2569847', 'yoyo', 'tore.3@hotmail.com', 'acapulco'),
(5, 'Cl. 23 # 12-60', 12, '2544544', 'Mirandela', 'wjmb@gmail.com', 'Mirandela'),
(6, 'cragbsga', 12, '3265489', 'lipol', 'maria97@gmail.com', 'montecarlo'),
(7, 'diagonal 51 A #29 65 sur', 13, '2555658', 'yopal', 'nancyespinosa@gmail.com', 'Valley Cargo'),
(8, 'Calle 2 N98-65', 8, '2403084', '20 de Julio', 'enrique1279@gmail.com', 'Servientrega'),
(9, 'cra79A#78-55s', 5, '6952471', 'Bosa', 'suc1258@hotmail.com', 'valley Cargo'),
(10, 'Av 68 #12-25', 38, '7458969', 'EL dorado', 'dorado@valleycarga@gmail.com', 'Las brisas'),
(11, 'diagonal 15 N 15-90', 31, '7312968', 'Bosa', 'valleyCarga@gmail.com', 'BosaSegura'),
(12, 'diagonal 51 A #29 65 sur', 6, '3256985', 'medellin', 'valleycargo@hotmail.es', 'Valley Carga'),
(13, 'Cll 19A # 22 -10', 31, '3300215', 'La esperanza', 'la_esperanza@gmail.com', 'Sede La Esperanza'),
(14, 'Cl. 78 # 15-15', 9, '7474744', 'Mandalay', 'mandalay@gmail.com', 'Mandalay'),
(15, 'Trv 25 # 36 - 11', 15, '7458745', 'El Dorado', 'el_dorado@gmail.com', 'Sede El Dorado'),
(16, 'Calle 12 # 89-45', 8, '7318865', 'Puente', 'puente@gmail.com', 'puenteExplres'),
(17, 'Calle 130d N90-83', 14, '1234567', 'Chapinero', 'eduardoM@yahoo.com', 'Lourdes'),
(18, 'calle 74 b bis #8d 10', 8, '9854758', 'Barranquilla', 'valleycargas.a.s@outlook.com', 'valley carga S.A.S'),
(19, 'Cl. 45 #12-60', 16, '2548965', 'Castellana', 'louyo@hotmail.com', 'monserrate'),
(20, 'cra9este#45-19s', 18, '3205896985', 'La Gloria', 'suc4569@hotmail.com', 'EnviaLaGloria'),
(21, 'Cll 25 # 88-12', 36, '5520258', 'Centro', 'el-centro@gmail.com', 'Sede El Centro'),
(23, 'calle 55 a # 27 74 sur', 18, '2308159', 'San Vicente ferrer', 'valleysanvice@gmail.com', 'valley '),
(25, 'Kra 17 b este # 9-32 sur', 38, '3658741', 'Montecarlo', 'valleycargo@gmail.com', 'ValleyCargo'),
(26, 'Cl. 23 # 12-65', 13, '7458988', 'Centro', 'centrodeBogota@hotmail.com', 'SucuCentro'),
(27, 'Cra90 No 80b-45 sur', 21, '9854263', 'Porvenir', 'Carga@gmail.com', 'Carga s.a'),
(28, 'Cra 9 no. 22 - 72', 18, '8968510', 'Cedritos', 'cedritos@valleycargo.co', 'Cedritos Valley Cargo'),
(29, 'carrera 15 # 76-12', 12, '7145464', 'Madelena', 'madelena@valleycarga.com', 'madevalley'),
(30, 'Autopista norte 110', 18, '3197862112', 'Campo Alto', 'cristian504@hotmail.es', 'CargaMaxima'),
(31, 'Kra 52 # 21 - 10', 37, '2458741', 'Alqueria', 'rapidito@gmail.com', 'rapidito'),
(32, 'AV caracas # 11 15', 18, '7856469', 'San victorino', 'cargovalleySAN@gmail.com', 'SAN VICTORINO'),
(34, 'calle 19 V 68 sur', 18, '4795632', 'Estados Unidos', 'Envia0000@hotmail.com', 'Envia de la 72'),
(35, 'Calle 22-19', 11, '7896541', 'DelGuetto', 'enviosTL@hotmail.com', 'EnviosTonnyL'),
(36, 'calle68#54-45', 8, '72546879', 'salitre', 'carga@hotmail.com', 'andres'),
(37, 'avCalle68#45-96', 22, '9685474', 'Julio Flores', 'suc1478@gmail.com', 'Julio Flores'),
(38, 'Carrera 14 N22-10', 14, '87456512', 'Santafe', 'swimmingpool@hotmail.com', 'Satafe'),
(39, 'Cr 115 # 36 - 36', 14, '3320115', 'El Parque', 'sede_el_parque@gmail.com', 'Sede El Parque'),
(40, 'Clle 23 # 21 - 21', 35, '2369854', 'Chaparral', 'envia@gmail.com', 'Envia'),
(41, 'Diagonal 23 # 17 sur ', 18, '9857546', 'Santa lucia', 'Deprisa.._@hotmail.com', 'Deprisa '),
(42, 'calle 107 n 72-47 sur', 11, '7239839', 'Bosa El Recreo', 'WorldSystem@hotmail.com', 'World System'),
(43, 'Clle 23 # 21 - 21', 34, '2365874', 'Uribe', 'express@gmail.com', 'Express'),
(44, 'Cl. 23 # 12-60', 19, '7457878', 'San Victorino', 'Sanvi@gmail.com', 'Centro'),
(45, 'calle17#01-16', 33, '3170111108', 'Marsella', 'sec1701@hotmail.com', 'MarCargas'),
(46, 'Calle 15 V # 12-20', 6, '2103045', 'Chapinero', 'Envios@gmail.com', 'Sus envíos a tiempo'),
(47, 'Avcali23-45', 9, '23658947', 'Eduardosantos', 'taporteCordinador@hotmail.com', 'transporteCordinado'),
(48, 'avvillavicencio#54-89', 14, '5641235', 'casalinda', 'jeanshd@hotmail.com', 'jeanshd'),
(49, 'av caracas 1c 14', 35, '2842672', 'San Bernandino', 'ProgramacionAl100%@hotmail.com', 'Programacion De 12 a 12 '),
(50, 'calle 100 No.23-12', 5, '3153637689', 'chico', 'exitocien@gmail.com', 'El chico'),
(51, 'calle72#11-24', 8, '98563247', 'Chapinero', 'ColdTrans@gmail.com', 'coldtransporte'),
(52, 'Calle 85 # 25 N', 18, '9736214', 'Contador', 'Rol_Envios@gmail.com', 'Rol Envios'),
(53, 'Cra. 85 No. 72-34', 5, '3153637688', 'Chico', 'chico16@gmail.com', 'Exito15'),
(55, 'Cra. 15 #74-15', 8, ' 2178135', 'tintal', 'servi@hotmail.co', 'servicar'),
(56, 'Calle100#22-34', 35, '23658974', 'Cedritos', 'transferros@hotmail.com', 'transferrros'),
(57, 'calle 38  # 82 -55', 5, '2550536', 'ciudad kenedy', 'corrdi@hotmail.com', 'coordinadora');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifas`
--

CREATE TABLE `tarifas` (
  `tarifaID` int(11) NOT NULL,
  `rutaID` int(11) NOT NULL,
  `peso_min` int(11) NOT NULL,
  `valor` int(11) NOT NULL,
  `peso_max` int(11) NOT NULL,
  `dimension_min` int(11) NOT NULL,
  `dimension_max` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tarifas`
--

INSERT INTO `tarifas` (`tarifaID`, `rutaID`, `peso_min`, `valor`, `peso_max`, `dimension_min`, `dimension_max`) VALUES
(1, 1, 1, 15000, 100, 20, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `cedula` bigint(20) NOT NULL,
  `tipo_Documento` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `celular` varchar(30) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `correo` varchar(30) NOT NULL,
  `clave` varchar(35) NOT NULL,
  `ciudadID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`cedula`, `tipo_Documento`, `nombre`, `apellido`, `direccion`, `telefono`, `celular`, `fecha_nacimiento`, `correo`, `clave`, `ciudadID`) VALUES
(123456, 'C.C', 'ximena', 'largo', 'calle 106 n 62-45 sur', '2582142', '3114736335', '2000-04-15', 'ximenalargo@hotmail.com', 'ximena15', 15),
(951010, 'T.I', 'daniel', 'alvarez', 'calle 100 n 62-45 sur', '7233946', '3125045104', '1998-07-09', 'danielalvarez07@hotmail.com', 'daniel07', 18),
(1012105, 'C.C', 'maria', 'estrada', 'calle 106 n 62-45 sur', '2582426', '3203456870', '1998-10-09', 'mariaestrada@hotmail.com', 'maria10', 18),
(1234567, 'T.I', 'Linder', 'Sierra', 'Calle 72', '7213300', '3132681187', '1997-01-10', 'linder@gmail.com', '123', 18),
(7531569, 'C.C', 'lady', 'Ramos', 'diagonal 15 N 15-45', '7369985', '3009876535', '2000-05-03', 'lady@gmail.com', '123', 35),
(17189398, 'C.C', 'Hector ', 'Gutierrez', 'Calle 2 N98-65', '3645695', '3154112688', '1940-07-19', 'hectorGutierrez@hotmail.com', '789', 14),
(32693565, 'C.C', 'Julian', 'Casablancas', 'Trv 58 # 36-12 sur', '3300202', '3221159656', '1989-03-07', 'july@gmail.com', '123', 35),
(36987753, 'C.C', 'Marta ', 'Mora', 'Trv 35 # 21-33', '3652125', '3115223698', '1991-08-01', 'marta100@hotmail.com', 'marta123', 8),
(41799008, 'C.C', 'josefina ', 'Manrique Mejia', 'Calle 65 No.18c-23', '3612973', '3153622345', '1969-08-04', 'josefinaman999@gmail.com', 'haroldagamez', 5),
(41799010, 'C.C', 'Juan', 'SantaMaria', 'Callle 73No.45-35', '2725002', '31536223450', '1979-11-30', 'juansantamaria@gmail.com', '1234567', 5),
(41888009, 'C.C', 'Yennifer', 'Salamanca', 'cra.65 No. 13-12', '2743490', '320456789', '1985-08-03', 'yenifersalamanca@hotmail.com', '123456', 6),
(52302655, 'C.C', 'Luz Dary', 'Valbuena', 'cra79A#78-55s', '6952471', '3202892872', '1975-09-07', 'lvalbuena@javeriana.edu.co', 'lvalbuena08', 14),
(52534520, 'C.C', 'Nancy', 'Espinosa', 'calle 74 b bis #8d 09', '6591567', '3005470418', '1983-06-06', 'nancuespinosa@gmail.com', '789', 9),
(52658963, 'C.C', 'Miguel ', 'Vargas Suarez', 'cra 80 # 56-87', '7858596', '3112569865', '1971-10-04', 'miguel7@yahoo.com', '852', 6),
(52743822, 'C.C', 'Bety', 'Ramirez', 'Cra90 No 59b-45 su', '7459632', '3102268547', '1985-02-05', 'ramirezbety@08gmail.com', '9632', 23),
(53039798, 'T.I', 'Angelica', 'Espinosa', 'calle 74 b bis #8d 09', '6591567', '3112552214', '1990-12-18', 'angeespinosama@gmail.com', '147', 18),
(65478912, 'C.C', 'Laura', 'Rojas', 'diagonal 36 # 14-17', '7659865', '3009876535', '1995-02-05', 'Luara@gmail.com', 'laura123', 17),
(65753207, 'C.C', 'Luz', 'Oyola Sabogal', 'calle 38  # 82 -55', '2386545', '3214757845', '1970-07-03', 'luz@gmail.com', '789', 18),
(65787873, 'C.C', 'Araceli', 'Vega', 'Calle22 sur #12-43', '2803569', '3133749693', '1968-08-29', 'arabe@hotmail.com', '2345', 19),
(78256954, 'C.C', 'manuel', 'rodriguez', 'av 45 n° 34-89', '45269858', '3158964575', '1970-12-01', 'k.y.rp@gmail.com', '789456', 22),
(79559424, 'C.C', 'Enrique', 'Gutierrez', 'Calle 130d N90-83', '6826814', '3194567894', '1970-12-27', 'enrique1279@gmail.com', '963', 14),
(101022385, 'C.C', 'Juan Camilo', 'Veru Vega', 'avenida caracas 1c 14', '2801691', '3223583843', '1995-09-10', 'juanc.vega@gmail.com', '0000', 38),
(102454545, 'T.I', 'Ingrid Marcela', 'Lizarazo Beltran', 'Cl. 78 # 15-15', '7245689', '3132400859', '2008-11-23', 'IngridM@gmail.com', '4545', 31),
(105702886, 'C.C', 'Alberto', 'Perez', '4525 North Oracle Rd.', '4669898', '3256698877', '1996-10-04', 'alberto@mail.com', '123', 22),
(113259321, 'C.C', 'Camilo', 'Ortiz', 'Clle 23 # 21 - 21', '3698521', '310256987', '1992-12-19', 'camiloortiz@gmail.com', '258', 33),
(594567895, 'C.C', 'Eduardo', 'Mora', 'Carera 26 N64-51', '2403084', '3107778956', '1968-10-24', 'eduardoM@yahoo.com', '456', 17),
(789654032, 'C.C', 'Daniel ', 'Sanchez', 'Carrera 48 # 15-12 sur', '4550406', '3008562102', '1995-05-04', 'dani@hotmail.com', '123', 25),
(1000285396, 'T.I', 'Nicolas', 'Perez', 'calle2 Dig #13-26', '2681383', '3229845769', '2003-12-11', 'nicoli@gmail.com', '4569', 14),
(1007789541, 'C.C', 'Yessica', 'Ducuara ramirez', 'Diagonal 72 # 18 I 80 sur ', '7911661', '3132009721', '1997-05-25', 'ducuarajessica@gmail.com', 'D333', 18),
(1010039567, 'C.C', 'Alexander', 'Beltran', 'TRA. 23 no. 18 - 30', '5789843', '3210930000', '1977-06-14', 'abc@gmail.com', '09876', 17),
(1010223853, 'C.C', 'juan camilo', 'veru vega', 'Av Caracs 1c14', '2801691', '3223583843', '1995-09-11', 'juanc.vega97@gmail.com', '1234', 17),
(1011659874, 'T.I', 'Paola', 'Martinez', 'calle 74 b bis #8d 10', '6591567', '3133182848', '2003-01-18', 'jennymar@gmail.com', '456', 18),
(1012420681, 'C.C', 'Yuleidy', 'Cruz Valbuena', 'cra79A#78-55s', '6952471', '3127596909', '1995-08-03', 'leidycrux@hotmail.com', 'leidy18', 14),
(1012447300, 'C.C', 'Marlon', 'Nuñez', 'Calle 12', '12345', '3192517868', '1997-01-10', 'marlon@gmail.com', '123', 5),
(1012477856, 'C.C', 'marcela', 'castro', 'diagonal12#54-06', '7661502', '3124557889', '1992-10-07', 'marc@hotmail.com', '0000', 7),
(1013254784, 'C.C', 'Nicol', 'Rodriguez', 'Kra 52 # 21 - 10', '2852554', '3102643284', '1995-09-24', 'nicolrodriguez@gmial.com', '789', 24),
(1013628064, 'C.C', 'Liliana Maria', 'Rodriguez Suarez', 'Cl. 23 # 12-60', '4783211', '3113861915', '2016-12-11', 'lili_rs@', '1212', 14),
(1013628454, 'T.I', 'Gabriel', 'Gomez Diaz', 'Cl. 12 # 15-12', '4555555', '3114545454', '2002-11-10', 'gb.@hotmail.com', '4141', 16),
(1013666588, 'C.C', 'Fernanda', 'Contreras', 'Cra50 No80b-20 sur', '6985741', '3102569874', '1997-04-11', 'maria.fer115hotmail.com', '8520', 8),
(1013698521, 'C.C', 'Daniel', 'Velandia', 'Clle 85 # 23- 25', '325632', '311258741', '1990-03-09', 'danielvelandia@gmail.com', '741', 34),
(1015214545, 'C.C', 'Andres Camilo', 'Torres Muñoz', 'Cl. 45 #12-60', '4783278', '3153296547', '2003-11-11', 'y.g.j.@gmail.com', '7878', 38),
(1018501668, 'C.C', 'Oscar', 'Luis', 'calle 74 b bis #8d 09', '6591567', '3124782428', '1998-02-18', 'oscarluis54@gmail.com', '0310', 18),
(1020532159, 'T.I', 'Archel', 'Guzman', 'Cr 22 # 52 - 33 sur', '3369852', '3212256325', '2000-03-09', 'archel@gmail.com', '123', 28),
(1020563020, 'C.C', 'Camilo', 'Molina', 'Cll 102 # 12 -55 ', '3300159', '3132002157', '1995-01-10', 'camilo_molina@gmail.com', 'camilo159', 36),
(1023654897, 'C.C', 'maria ', 'perez', 'cra 3 n° 50-34', '3265489', '3205694758', '1985-08-24', 'k.y.rp97@gmail.com', '123456', 21),
(1023906170, 'C.C', 'David ', 'Gutierrez', 'Carrera 9c N30b-22', '3645695', '3102793705', '0092-02-18', 'nd.gutierrezb@gmail.com', '123', 10),
(1023931732, 'C.C', 'Karen', 'Bocanegra', 'Kra 17 b este # 9-32 sur', '2802805', '3112732952', '1994-03-15', 'karenbocanegra94@gmail.com', '123', 14),
(1023931733, 'C.C', 'Yulied', 'Castellanos', 'Kra 20 # 9-33 ', '2333446', '3123128375', '1995-12-09', 'kiracontreras@gmail.com', '456', 6),
(1023960834, 'C.C', 'kelly', 'ramirez', 'cragbsga', '3631440', '3015268947', '1997-06-04', 'k.y.rp@hotmail.com', '123456', 14),
(1024570388, 'C.C', 'miguel', 'mogollon', '4525 North Oracle Rd.', '4555555', '3212204444', '1990-10-03', 'micorreo@mail.com', '123', 14),
(1025369789, 'C.C', 'Arley', 'Cortez', 'calle25#96-45', '5897632', '312589698', '1994-12-04', 'Arley@hotmail.com', '123456', 8),
(1025560366, 'C.C', 'Andres', 'Arias', 'carrera 15 # 76-12', '3663265', '3102015589', '1993-10-11', 'ariasa@gmail.com', '123', 30),
(1028668306, 'C.C', 'Johan Andres', 'Ruiz Mendez', 'calle 11 # 65 -98', '4565656', '3125658965', '1991-08-25', 'andres26@gmail.com', '2626', 13),
(1029305486, 'C.C.', 'Wilson ', 'Lopez', 'CRA 94 no. 10 - 15', '8962414', '3204857392', '1993-09-24', 'wl@gmail.com', '35741', 20),
(1029355203, 'C.C', 'Samuel', 'Beltran', 'Cll 50B no. 23 - 43', '6256788', '3204857362', '1986-07-24', 'sb@gmail.com', '36987', 20),
(1030604157, 'C.C', 'Leidy Johanna', 'Murillo Oyola', 'cra 80 # 38 c -14', '4037278', '3102808328', '1996-01-13', 'lmurillo79@yahoo.com', '123', 14),
(1030617171, 'C.C', 'Luis Eduardo', 'Ruiz Hernandez', 'calle 100 # 98-65', '4052856', '3105698956', '1993-11-09', 'luisruiz10@', '896', 32),
(1033769693, 'C.C', 'Juan', 'Beltran', 'calle64#16-32', '5661655', '3112578964', '1996-11-03', 'juan@hotmail.com', '1111', 14),
(1033804473, 'C.C', 'Tatiana', 'Rincon', 'diagonal 51 A #29 65 sur', '3895090', '3143646393', '1998-02-18', 'tatianarincon310@gmail.com', '1003', 18),
(1036985642, 'C.C', 'Jhon', 'Gonzalez', 'Diagonal 35 N 18 - 2A', '5329812', '3190271833', '1995-09-05', 'Jhonfgg@gmail.com', '3132', 18),
(1084933000, 'C.C', 'Angie ', 'Beltran', 'CLL 80 no. 60 - 20', '3256788', '3122222222', '1995-10-01', 'ajb@gmail.com', '1234', 5),
(1203569752, 'T.I', 'Carlos', 'Useche', 'cra 4 n° 56-78', '2569847', '3148659752', '1990-10-16', 'ndgutierrez@gmail.com', '123456', 18),
(1203698526, 'C.C', 'Carlos', 'Camacho', 'Cll 52 # 56 - 10', '3256985', '3211234567', '2002-09-30', 'carlos123@gmail.com', '123', 14),
(1233894806, 'C.C', 'Cristiam', 'Ortiz', 'Calle 54 # 80-p', '6549821', '3102089221', '1997-12-11', 'cristian504@hotmail.es', '131231312', 6),
(1233894808, 'C.C', 'Andres', 'Castro', 'Cra80 No 40b-35 sur', '7589632', '3102253436', '1997-03-08', 'andres@gmail.com', '4563', 23),
(8579546213, 'C.C', 'Brayan ', 'Duarte', 'Calle 68 # 17 28', '5648794', '3125468974', '1996-03-02', 'duartebrayan@gmail.com', '6333', 18),
(8972641345, 'C.C', 'Camilo ', 'Jimenez', 'calle 72 # 15 29', '6549710', '3100007895', '1994-09-25', 'camilo@gmail.com', 'cami33', 6),
(8975642318, 'C.C', 'Julian', 'Amador', 'calle 22 # 34 12', '4879642', '3168957845', '1985-12-02', 'julian123@gmail.com', '7895', 12),
(15237895426, 'C.C', 'Anserdon', 'Morales', 'calle 67 # 12 28', '4589612', '3107894562', '1995-06-08', 'anderson16@gmail.com', '579456', 8),
(94050912345, 'T.I', 'Marvel', 'Ruiz', 'avcalle68#45-15', '7896521', '311568974', '1999-02-23', 'Marvel', 'mar456', 38),
(94111003968, 'T.I', 'angela', 'cardona', 'transversal13#05-06', '7133296', '3223879783', '1989-08-25', 'ang@hotmail.com', '3333', 10),
(95040806416, 'T.I', 'Yuly', 'Pedraza', 'trans4#45-9', '8963258', '320568974', '1997-12-31', 'Yuly', 'yu123', 28),
(97111513922, 'T.I', 'jorge', 'rojas', 'calle 107 n 72-47 sur', '7239839', '3213998749', '1997-11-14', 'stivenrojas1997@outlook.es', 'stiven15', 16),
(97111513928, 'T.I', 'Jorge', 'Rojas', 'carrera127#73-45', '5489763', '3213998749', '1997-11-14', 'stevenrojas1997@outlook.es', '123456', 11),
(97784226894, 'T.I', 'carlos', 'marin', 'calle56#75-64', '7315694', '3154221456', '2000-12-23', 'carlos', '4444', 16),
(99091814354, 'T.I', 'Luisa ', 'Espejo', 'Cra100 No 50b-45 sur', '7384013', '3102274957', '1999-09-17', 'lfespejo18gmail.com', '1234', 10),
(187945638965, 'C.C', 'laura', 'pico', 'calle52#123-67', '8745693', '322154789', '1993-02-08', 'lauraP@hotmail.com', '4587', 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `vehiculoID` int(11) NOT NULL,
  `placa` varchar(30) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`vehiculoID`, `placa`, `marca`, `modelo`, `estado`) VALUES
(2, 'BJI-806', 'Hyundai', '2005', 'Disponible'),
(3, 'LMZ-785', 'chevrolet', '2003', 'Disponible'),
(4, 'SXM-729', 'Toyota', '2017', 'Disponible'),
(5, 'TYU 567', 'Nissan', '2000', 'Disponible'),
(6, 'BNG-521', 'HYUNDAY', '2015', 'ocupado'),
(7, 'jpc874', 'chevrolet', '2000', 'disponible'),
(8, 'RTY 102', 'Toyota', '2013', 'En Transito'),
(9, 'GOD-666', 'PORSHE', '2000', 'Disponible'),
(10, 'BTS-700', 'jeep', '2016', 'En Transito'),
(11, 'bzx423', 'audi', 'audi a5 ', 'en transito'),
(12, 'GHH 546', 'Mazda', '2001', 'Disponible'),
(13, 'MGD321', 'Nissan', '2010', 'Disponible'),
(14, 'DBZ-365', 'Toyota', '2002', 'Disponible'),
(15, 'SAM201', 'Audi', 'audi6', 'Disponible'),
(16, 'MDR-787', 'NISSAN', '2015', 'En Transito'),
(17, 'ASD-123', 'Chevrolet', '2013', 'No disponible'),
(18, 'abc123', 'BMW', 'bmw Serie 1', 'Disponible'),
(19, 'SDG  368', 'Renault', '2005', 'Transito'),
(20, 'MQN-631', 'chevrolet', '2015', 'Disponible'),
(21, 'Q6e-9q9', 'HYUNDAY', '2017', 'Disponible'),
(22, 'gtu668', 'nissan', '2016', 'En transito'),
(23, 'TLR-895', 'Mercedez Benz', '2016', 'Transito'),
(24, 'GUI-123', 'Chana', '2015', 'No Disponible'),
(25, 'SNK-636', 'Chevrolet', '2014', 'No Disponible'),
(26, 'WZH-156', 'ford', '1990', 'Ocupado'),
(27, 'DER-456', 'Renoult', '2015', 'Disponible'),
(28, 'ACD', 'Hyundai', '2016', 'En transito'),
(29, 'TrB210', 'Mercedes-Benz', '2000', 'En transito'),
(30, 'DGF 716', 'Mercedez', '2015', 'Disponible'),
(31, 'FHD-987', 'mazda', '2015', 'En Transito'),
(32, 'pou154', '2013', 'toyota', 'no disponible'),
(33, 'MDC789', 'Toyota', '2016', 'En transito'),
(34, 'CVY0000', 'RENAULT', '2003', 'Transito'),
(35, 'mwm125', 'Porsche', 'Boxter 2005', 'Disponible'),
(36, 'ASD-123', 'Audi', '2010', 'En Transito'),
(37, 'SAO-159', 'Nissan', '2006', 'En Transito'),
(38, 'MJO-528', 'RENAULT', '2014', 'No Disponible'),
(39, 'ASD_219', 'Ssuki', '2000', '2011'),
(40, 'trs579', 'foton', '2005', 'disponible'),
(41, 'TIO-789', 'Kia', '2012', 'En Transiito'),
(42, 'FGH', 'Fiat', '1995', 'Disponible'),
(43, 'SCM555', 'Jaguar', 'Jaguar Xf', 'En Transito'),
(44, 'MYL-058', 'Toyota', '2015', 'Disponible'),
(45, 'por552', 'fiat', '2012', 'en transito'),
(46, 'KBR163', 'Renauld', '2011', 'No disponible'),
(47, 'ACL369', 'Kia', '2015', 'Disponible'),
(48, 'LIK-566', 'fuso', '2015', 'Disponible'),
(49, 'AER-234', 'Renoult', '2012', 'en trnsito'),
(50, 'BNM-258', 'Hyundai', '2003', 'Taller'),
(51, 'HMG4278', 'MERCEDES-BENZ', '2013', 'Disponible'),
(52, 'YJC-171', 'Volvo', '2001', 'Disponible'),
(53, 'MJH-852', 'mercedes-benz', '2016', 'Disponible'),
(54, 'MNB213', 'Kia', '2014', 'Disponible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos_usuarios`
--

CREATE TABLE `vehiculos_usuarios` (
  `vehiculoID` int(11) NOT NULL,
  `cedulaID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bodega`
--
ALTER TABLE `bodega`
  ADD PRIMARY KEY (`bodegaID`),
  ADD KEY `ciudadID` (`ciudadID`);

--
-- Indices de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD PRIMARY KEY (`ciudadID`),
  ADD KEY `departamentoID` (`departamentoID`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`departamentoID`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`cedula`,`sucursalID`),
  ADD KEY `sucursalID` (`sucursalID`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`facturaID`),
  ADD KEY `paqueteID` (`paqueteID`),
  ADD KEY `ciudad_origen` (`ciudad_origen`),
  ADD KEY `ciudad_destino` (`ciudad_destino`),
  ADD KEY `tarifaID` (`tarifaID`),
  ADD KEY `sucursal_origen` (`sucursal_origen`),
  ADD KEY `sucursal_destino` (`sucursal_destino`),
  ADD KEY `destinatario` (`destinatario`),
  ADD KEY `remitente` (`remitente`),
  ADD KEY `cajero` (`cajero`);

--
-- Indices de la tabla `factura_vehiculos`
--
ALTER TABLE `factura_vehiculos`
  ADD PRIMARY KEY (`facturaID`,`vehiculoID`),
  ADD KEY `vehiculoID` (`vehiculoID`);

--
-- Indices de la tabla `historial_paquete`
--
ALTER TABLE `historial_paquete`
  ADD PRIMARY KEY (`historial_PID`),
  ADD KEY `paqueteID` (`paqueteID`),
  ADD KEY `usuario_a` (`usuario_a`);

--
-- Indices de la tabla `historial_vehiculos`
--
ALTER TABLE `historial_vehiculos`
  ADD PRIMARY KEY (`historial_vID`),
  ADD KEY `vehiculoID` (`vehiculoID`),
  ADD KEY `cedula` (`cedula`),
  ADD KEY `usuario_a` (`usuario_a`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`mensajeID`),
  ADD KEY `remitente` (`remitente`),
  ADD KEY `destinatario` (`destinatario`);

--
-- Indices de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD PRIMARY KEY (`paqueteID`),
  ADD KEY `vehiculoID` (`vehiculoID`);

--
-- Indices de la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`perfilID`);

--
-- Indices de la tabla `perfil_usuarios`
--
ALTER TABLE `perfil_usuarios`
  ADD PRIMARY KEY (`perfil_usuariosID`),
  ADD KEY `cedula` (`cedula`),
  ADD KEY `perfilID` (`perfilID`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`rutaID`),
  ADD KEY `ciudad_origen` (`ciudad_origen`),
  ADD KEY `ciudad_destino` (`ciudad_destino`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`sucursalID`),
  ADD KEY `ciudadID` (`ciudadID`);

--
-- Indices de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD PRIMARY KEY (`tarifaID`),
  ADD KEY `rutaID` (`rutaID`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `ciudadID` (`ciudadID`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`vehiculoID`);

--
-- Indices de la tabla `vehiculos_usuarios`
--
ALTER TABLE `vehiculos_usuarios`
  ADD PRIMARY KEY (`vehiculoID`,`cedulaID`),
  ADD KEY `cedulaID` (`cedulaID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bodega`
--
ALTER TABLE `bodega`
  MODIFY `bodegaID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  MODIFY `ciudadID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  MODIFY `departamentoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `facturaID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `historial_vehiculos`
--
ALTER TABLE `historial_vehiculos`
  MODIFY `historial_vID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `mensajeID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `paqueteID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `perfil`
--
ALTER TABLE `perfil`
  MODIFY `perfilID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `perfil_usuarios`
--
ALTER TABLE `perfil_usuarios`
  MODIFY `perfil_usuariosID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `rutaID` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  MODIFY `sucursalID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  MODIFY `tarifaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  MODIFY `vehiculoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bodega`
--
ALTER TABLE `bodega`
  ADD CONSTRAINT `bodega_ibfk_1` FOREIGN KEY (`ciudadID`) REFERENCES `ciudades` (`ciudadID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD CONSTRAINT `ciudades_ibfk_1` FOREIGN KEY (`departamentoID`) REFERENCES `departamentos` (`departamentoID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`sucursalID`) REFERENCES `sucursales` (`sucursalID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`paqueteID`) REFERENCES `paquetes` (`paqueteID`),
  ADD CONSTRAINT `factura_ibfk_10` FOREIGN KEY (`ciudad_origen`) REFERENCES `ciudades` (`ciudadID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_11` FOREIGN KEY (`ciudad_destino`) REFERENCES `ciudades` (`ciudadID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_4` FOREIGN KEY (`tarifaID`) REFERENCES `tarifas` (`tarifaID`),
  ADD CONSTRAINT `factura_ibfk_5` FOREIGN KEY (`sucursal_origen`) REFERENCES `sucursales` (`sucursalID`),
  ADD CONSTRAINT `factura_ibfk_6` FOREIGN KEY (`sucursal_destino`) REFERENCES `sucursales` (`sucursalID`),
  ADD CONSTRAINT `factura_ibfk_7` FOREIGN KEY (`destinatario`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_8` FOREIGN KEY (`remitente`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_9` FOREIGN KEY (`cajero`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura_vehiculos`
--
ALTER TABLE `factura_vehiculos`
  ADD CONSTRAINT `factura_vehiculos_ibfk_1` FOREIGN KEY (`facturaID`) REFERENCES `factura` (`facturaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_vehiculos_ibfk_2` FOREIGN KEY (`vehiculoID`) REFERENCES `vehiculos` (`vehiculoID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `historial_paquete`
--
ALTER TABLE `historial_paquete`
  ADD CONSTRAINT `historial_paquete_ibfk_1` FOREIGN KEY (`paqueteID`) REFERENCES `paquetes` (`paqueteID`),
  ADD CONSTRAINT `historial_paquete_ibfk_2` FOREIGN KEY (`usuario_a`) REFERENCES `usuarios` (`cedula`),
  ADD CONSTRAINT `historial_paquete_ibfk_3` FOREIGN KEY (`usuario_a`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `historial_vehiculos`
--
ALTER TABLE `historial_vehiculos`
  ADD CONSTRAINT `historial_vehiculos_ibfk_1` FOREIGN KEY (`vehiculoID`) REFERENCES `vehiculos` (`vehiculoID`),
  ADD CONSTRAINT `historial_vehiculos_ibfk_2` FOREIGN KEY (`cedula`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `mensajes_ibfk_1` FOREIGN KEY (`remitente`) REFERENCES `usuarios` (`cedula`),
  ADD CONSTRAINT `mensajes_ibfk_2` FOREIGN KEY (`destinatario`) REFERENCES `usuarios` (`cedula`);

--
-- Filtros para la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD CONSTRAINT `paquetes_ibfk_1` FOREIGN KEY (`vehiculoID`) REFERENCES `vehiculos` (`vehiculoID`);

--
-- Filtros para la tabla `perfil_usuarios`
--
ALTER TABLE `perfil_usuarios`
  ADD CONSTRAINT `perfil_usuarios_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `perfil_usuarios_ibfk_2` FOREIGN KEY (`perfilID`) REFERENCES `perfil` (`perfilID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD CONSTRAINT `rutas_ibfk_1` FOREIGN KEY (`ciudad_origen`) REFERENCES `ciudades` (`ciudadID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rutas_ibfk_2` FOREIGN KEY (`ciudad_destino`) REFERENCES `ciudades` (`ciudadID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD CONSTRAINT `sucursales_ibfk_3` FOREIGN KEY (`ciudadID`) REFERENCES `ciudades` (`ciudadID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD CONSTRAINT `tarifas_ibfk_1` FOREIGN KEY (`rutaID`) REFERENCES `rutas` (`rutaID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`ciudadID`) REFERENCES `ciudades` (`ciudadID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculos_usuarios`
--
ALTER TABLE `vehiculos_usuarios`
  ADD CONSTRAINT `vehiculos_usuarios_ibfk_1` FOREIGN KEY (`vehiculoID`) REFERENCES `vehiculos` (`vehiculoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vehiculos_usuarios_ibfk_2` FOREIGN KEY (`cedulaID`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
