
create table student (
   pkz VARCHAR(30) NOT NULL,
   firstname VARCHAR(30) default NULL,
   surname  VARCHAR(30) default NULL,
   birthday DATE default NULL,
   PRIMARY KEY (pkz)
);