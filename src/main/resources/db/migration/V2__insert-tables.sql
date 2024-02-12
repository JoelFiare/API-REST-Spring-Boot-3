INSERT INTO `imagen` (`id_imagen`, `mime`, `nombre`, `contenido`)
VALUES (1, 'image/jpeg', 'paisaje.jpg', 0x1F8C0200B28C010064),
       (2, 'image/png', 'logo.png', 0x1F8C0200DE720100CC),
       (3, 'image/gif', 'animacion.gif', 0x1F8C0200DE720100CC),
       (4, 'image/jpeg', 'perfil.jpg', 0x1F8C0200B28C010064),
       (5, 'image/svg+xml', 'icono.svg', 0x1F8C0200B28C010064)
ON DUPLICATE KEY UPDATE `id_imagen` = VALUES(`id_imagen`),
                        `mime`      = VALUES(`mime`),
                        `nombre`    = VALUES(`nombre`),
                        `contenido` = VALUES(`contenido`);

INSERT INTO `usuario` (`id_usuario`, `username`, `email`, `password`, `id_imagen`)
VALUES (1, '2 sudio ddd', '2user2@dev.com', '2321', 1),
       (2, 'e321312312', 'dsadasd@dev.com', '32112', 2),
       (3, '3213213', 'dsadasd@dev.com', '32112', 3)
ON DUPLICATE KEY UPDATE `id_usuario` = VALUES(`id_usuario`),
                        `username`   = VALUES(`username`),
                        `email`      = VALUES(`email`),
                        `password`   = VALUES(`password`),
                        `id_imagen`  = VALUES(`id_imagen`);