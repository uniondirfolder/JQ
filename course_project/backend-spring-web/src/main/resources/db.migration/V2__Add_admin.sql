INSERT INTO `doc_chat`.`app_user`
(`id`,
 `activation_code`,
 `active`,
 `email`,
 `password`,
 `username`)
VALUES
    (1, NULL, true, 'admin@admin.com', '123', 'admin');

INSERT INTO `doc_chat`.`app_user_role`
(`user_id`,`roles`)
VALUES
    (1,'USER'), (1,'ADMIN');

INSERT INTO `doc_chat`.hibernate_sequence (next_val) VALUES (0);