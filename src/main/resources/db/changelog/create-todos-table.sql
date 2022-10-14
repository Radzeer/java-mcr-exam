create table todos(id bigint auto_increment, description varchar(255), deadline datetime, importance varchar(25), status varchar(25), user_id bigint, primary key (id));
alter table todos add constraint FK_users foreign key (user_id) references users(id);
