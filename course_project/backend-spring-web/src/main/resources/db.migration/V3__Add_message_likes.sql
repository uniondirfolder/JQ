CREATE TABLE `message_likes` (
                                 `message_id` bigint NOT NULL,
                                 `user_id` bigint NOT NULL,
                                 PRIMARY KEY (`message_id`,`user_id`),
                                 KEY `user_id_fk` (`user_id`),
                                 CONSTRAINT `message_id_fk` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`),
                                 CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_subscriptions` (
                                      `subscriber_id` bigint NOT NULL,
                                      `channel_id` bigint NOT NULL,
                                      PRIMARY KEY (`channel_id`,`subscriber_id`),
                                      KEY `subscriber_id_fk` (`subscriber_id`),
                                      CONSTRAINT `channel_id_fk` FOREIGN KEY (`channel_id`) REFERENCES `app_user` (`id`),
                                      CONSTRAINT `subscriber_id_fk` FOREIGN KEY (`subscriber_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;