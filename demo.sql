create database USER_CENTER;
use USER_CENTER;
create table role_table(
Role_Id int(11) NOT NULL AUTO_INCREMENT,
Role_Name  varchar(50) not null,
Role_Level varchar(50) not null,
 PRIMARY KEY (Role_Id) USING BTREE
);
create table Authority_table(
Authority_Id int(11) NOT NULL AUTO_INCREMENT,
Authority_Name varchar(50) not null,
  PRIMARY KEY (Authority_Id) USING BTREE
);
create table Role_Authority_table(
Role_Authority_Id int(11) NOT NULL AUTO_INCREMENT,
Role_Id int(11) NOT NULL,
Authority_Id int(11) NOT NULL ,
 PRIMARY KEY (Role_Authority_Id) USING BTREE,
FOREIGN KEY (Role_Id) REFERENCES role_table(Role_Id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (Authority_Id) REFERENCES Authority_table(Authority_Id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table user_table(
Phone  int(11) NOT NULL UNIQUE,
Password varchar(50) not null,
Affiliation varchar(50) not null,
Username varchar(50) not null,
Role_Id int(11) NOT NULL,
Is_Delete tinyint(1) default 0,
Is_Login tinyint(1) default 0,
FOREIGN KEY (Role_Id) REFERENCES role_table(Role_Id),
  PRIMARY KEY (Phone) USING BTREE
);

create table Login_table(
Access_id int(11) NOT NULL  AUTO_INCREMENT,
Phone  int(11) NOT NULL,
Mac varchar(50) not null,
Address varchar(50) not null,
Point_X varchar(50) not null,
Point_Y varchar(50) not null,
Datetime datetime not null,
 PRIMARY KEY (Access_id) USING BTREE,
 FOREIGN KEY (Phone) REFERENCES user_table(Phone) ON DELETE CASCADE ON UPDATE CASCADE
);

create table Three_Login_table(
Access_id int(11) NOT NULL  AUTO_INCREMENT,
Phone  int(11) NOT NULL,
Mac varchar(50) not null,
Address varchar(50) not null,
Datetime datetime not null,
 PRIMARY KEY (Access_id) USING BTREE,
 FOREIGN KEY (Phone) REFERENCES user_table(Phone) ON DELETE CASCADE ON UPDATE CASCADE
);