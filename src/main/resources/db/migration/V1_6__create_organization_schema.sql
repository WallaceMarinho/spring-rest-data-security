CREATE TABLE IF NOT EXISTS `organization` (
    `id` bigint(20) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    `address` varchar(255) DEFAULT NULL,  -- Exemplo de campo adicional
    `created_date` timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
