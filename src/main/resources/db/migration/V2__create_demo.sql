CREATE TABLE `demo`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `name`         varchar(100) NOT NULL,
    `created_at`   DATETIME     NOT NULL,
    `updated_at`   DATETIME     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
