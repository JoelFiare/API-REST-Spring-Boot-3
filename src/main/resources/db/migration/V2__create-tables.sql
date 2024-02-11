CREATE TABLE IF NOT EXISTS `carrito`
(
    `id_carrito`  int(11) NOT NULL AUTO_INCREMENT,
    `id_usuario`  int(11)        DEFAULT NULL,
    `id_producto` int(11)        DEFAULT NULL,
    `cantidad`    int(11)        DEFAULT NULL,
    `total`       decimal(38, 2) DEFAULT NULL,
    `fecha`       date           DEFAULT NULL,
    PRIMARY KEY (`id_carrito`),
    KEY `id_usuario` (`id_usuario`),
    KEY `id_producto` (`id_producto`),
    CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
    CONSTRAINT `carrito_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `favoritos`
(
    `id_fav`      int(11) NOT NULL AUTO_INCREMENT,
    `id_usuario`  int(11) DEFAULT NULL,
    `id_producto` int(11) DEFAULT NULL,
    PRIMARY KEY (`id_fav`),
    KEY `id_usuario` (`id_usuario`),
    KEY `id_producto` (`id_producto`),
    CONSTRAINT `favoritos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
    CONSTRAINT `favoritos_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `imagen`
(
    `id_imagen` int(11) NOT NULL AUTO_INCREMENT,
    `mime`      varchar(255) DEFAULT NULL,
    `nombre`    varchar(255) DEFAULT NULL,
    `contenido` blob         DEFAULT NULL,
    PRIMARY KEY (`id_imagen`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `ordenes`
(
    `id_orden`    int(11) NOT NULL AUTO_INCREMENT,
    `id_carrito`  int(11)      DEFAULT NULL,
    `fecha_orden` date         DEFAULT NULL,
    `estado`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id_orden`),
    KEY `id_carrito` (`id_carrito`),
    CONSTRAINT `ordenes_ibfk_1` FOREIGN KEY (`id_carrito`) REFERENCES `carrito` (`id_carrito`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `producto`
(
    `id_producto`  int(11) NOT NULL AUTO_INCREMENT,
    `nombre`       varchar(255)   DEFAULT NULL,
    `categoria`    varchar(255)   DEFAULT NULL,
    `descripcion`  text           DEFAULT NULL,
    `precio`       decimal(38, 2) DEFAULT NULL,
    `imagen`       varchar(255)   DEFAULT NULL,
    `calificacion` decimal(38, 2) DEFAULT NULL,
    `favoritos`    int(11)        DEFAULT NULL,
    `stock`        int(11)        DEFAULT NULL,
    PRIMARY KEY (`id_producto`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `usuario`
(
    `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
    `username`   varchar(255) DEFAULT NULL,
    `email`      varchar(255) DEFAULT NULL,
    `password`   varchar(255) DEFAULT NULL,
    `id_imagen`  int(11)      DEFAULT NULL,
    PRIMARY KEY (`id_usuario`),
    KEY `id_imagen` (`id_imagen`),
    CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_imagen`) REFERENCES `imagen` (`id_imagen`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;