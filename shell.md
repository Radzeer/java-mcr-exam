```shell
docker run -d -e MYSQL_DATABASE=todolist -e MYSQL_USER=todo -e MYSQL_PASSWORD=todo -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3309:3306 --name todolist-mariadb mariadb
```