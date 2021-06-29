create schema StudentSystem;

use StudentSystem;

create table Student
(
	Sno char(20) primary key,
    Sname char(10),
    Smajor char(10),
    Ssex char(10),
    Sage int
);

create table Course
(
	Cno char(20) primary key,
    Cname char(10)
);

create table SC 
(
	Sno char(20),
    Cno char(20),
    Grade int,
    primary key(Sno, Cno),
    foreign key(Sno) references Student(Sno) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(Cno) references Course(Cno) ON DELETE CASCADE ON UPDATE CASCADE
);