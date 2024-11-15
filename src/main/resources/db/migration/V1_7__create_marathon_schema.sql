-- Criação da sequência para `marathon`
CREATE OR REPLACE SEQUENCE `marathon_seq` 
START WITH 1 
MINVALUE 1 
MAXVALUE 9223372036854775806 
INCREMENT BY 1 
NOCACHE 
NOCYCLE 
ENGINE=InnoDB;

-- Definição da tabela `marathon`
CREATE TABLE IF NOT EXISTS `marathons` (
    `id` bigint(20) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    `date` date DEFAULT NULL,
    `location` varchar(255) DEFAULT NULL, -- Local do evento
    `duration` int(11) DEFAULT NULL,      -- Duração em minutos, por exemplo
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
