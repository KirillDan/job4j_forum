insert into posts (name) values ('О чем этот форум?');
insert into posts (name) values ('Правила форума.');

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, password, authority_id)
values ('root', '$2a$10$Pkp7RE0inziQeYLmoQERiOQoB0cegl.AyXBzIwgyuv0L6SjcQNx5C',
(select id from authorities where authority = 'ROLE_ADMIN'));