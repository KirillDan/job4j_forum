[![Build Status](https://travis-ci.org/KirillDan/job4j_forum.svg?branch=master)](https://travis-ci.org/KirillDan/job4j_forum)
[![codecov](https://codecov.io/gh/KirillDan/job4j_forum/branch/develop/graph/badge.svg?token=MLS0UI3CT8)](https://codecov.io/gh/KirillDan/job4j_forum)
<br/>
# Проект "Форум".

### О проекте
Ссылка на проект Heroku - https://frozen-peak-80021.herokuapp.com/.

Использованные технологии в проекте:

- клиентская часть: HTML, CSS, JS.
- серверная часть: Spring Boot, Spring Security, Spring Data, Junit, liquibase

### Сборка

Необходимо создать базу данных forum в СУБД PostgreSQL и указать параметры в файле src/main/resources/application-dev.properties:
```
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/forum
spring.datasource.username=postgres
spring.datasource.password=123
```

Cобрать maven проект: mvn package

Запуск: java -jar target/forum-1.jar

### Использование

* Регистрация

![registration](images/registration.png)

* Вход

![login](images/login.png)

* Главная страница

![index](images/index.png)

* Создание поста

![create](images/create.png)

* Страница поста

![post](images/post.png)

* Страница Изменения поста

![update](images/update.png)

* logout

![logout](images/logout.png)

### Контакты

* Skype: live:.cid.8f17c3f8d147e77

