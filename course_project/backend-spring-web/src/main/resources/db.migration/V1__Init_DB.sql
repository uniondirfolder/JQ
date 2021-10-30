CREATE TABLE `app_user`
(
    `id`              bigint NOT NULL,
    `activation_code` varchar(255) DEFAULT NULL,
    `active`          bit(1) NOT NULL,
    `email`           varchar(255) DEFAULT NULL,
    `password`        varchar(255) NOT NULL,
    `username`        varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `app_user_role`
(
    `user_id` bigint NOT NULL,
    `roles`   varchar(255) DEFAULT NULL,
    KEY       `app_user_app_user_role_fk` (`user_id`),
    CONSTRAINT `app_user_app_user_role_fk` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `message`
(
    `id`       bigint NOT NULL,
    `filename` varchar(255) NOT NULL,
    `tag`      varchar(255) NOT NULL,
    `text`     varchar(2048) NOT NULL,
    `user_id`  bigint       DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY        `message_user_fk` (`user_id`),
    CONSTRAINT `message_user_fk` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;