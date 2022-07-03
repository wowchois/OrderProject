INSERT INTO menu (`name`,`price`) values ('아메리카노',2500);
INSERT INTO menu (`name`,`price`) values ('카페라떼',3500);
INSERT INTO menu (`name`,`price`) values ('바닐라라떼',4000);
INSERT INTO menu (`name`,`price`) values ('연유라떼',4000);
INSERT INTO menu (`name`,`price`) values ('자몽에이드',5000);
INSERT INTO menu (`name`,`price`) values ('레몬에이드',5000);
INSERT INTO menu (`name`,`price`) values ('아포카토',5500);

INSERT INTO users(`id`,`points`) values (1,10000);
INSERT INTO users(`id`,`points`) values (2,5000);
INSERT INTO users(`id`,`points`) values (3,0);

INSERT INTO orders(`order_user_id`,`menu_id`,`created_date`) values (1,1,timestampadd(day, -8, now()));
INSERT INTO orders(`order_user_id`,`menu_id`,`created_date`) values (1,1,timestampadd(day, -7, now()));
INSERT INTO orders(`order_user_id`,`menu_id`,`created_date`) values (1,2,timestampadd(day, -6, now()));
INSERT INTO orders(`order_user_id`,`menu_id`,`created_date`) values (3,5,timestampadd(day, -4, now()));
INSERT INTO orders(`order_user_id`,`menu_id`,`created_date`) values (2,1,timestampadd(day, -3, now()));
INSERT INTO orders(`order_user_id`,`menu_id`,`created_date`) values (2,4,timestampadd(day, -3, now()));
