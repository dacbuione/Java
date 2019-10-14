create database java2 
use java2
go	

create table Student
(
	id int not null IDENTITY(1,1) primary key ,
	name nvarchar(50) null,
	age int,
);
create table Class
(
	id int IDENTITY(1,1) primary key,
	class_name nvarchar(50) null,

);
create table Student_Class(
	 id_student int,
	 id_class int,
	 CONSTRAINT FK_Student_CLass_Student FOREIGN key (id_student) REFERENCES Student(id),
	 CONSTRAINT FK_Student_Class_Class   FOREIGN key (id_class) REFERENCES Class(id),		
);

create table Dayoff(
	id int IDENTITY(1,1) primary key,
	id_student int ,
	dayoff date not null,
	CONSTRAINT Fk_Dayoff_Student FOREIGN key (id_student) REFERENCES Student(id),
);

Insert into Student(name,age)
values('nguyễn a','19')
Insert into Student(name,age)
values('trần a','19')
Insert into Student(name,age)
values('phạm a','19')

Insert into Class(class_name)
values('17T1')
Insert into Class(class_name)
values('17T2')
Insert into Class(class_name)
values('17T3')
Insert into Class(class_name)
values('17T4')


Insert into Dayoff(id_student,dayoff)
values('1','2019-09-20')
Insert into Dayoff(id_student,dayoff)
values('1','2019-12-12')
Insert into Dayoff(id_student,dayoff)
values('2','2019-09-20')
Insert into Dayoff(id_student,dayoff)
values('2','2019-12-12')
Insert into Dayoff(id_student,dayoff)
values('3','2019-12-10')
Insert into Dayoff(id_student,dayoff)
values('3','2019-12-11')


Select name as [Tên],class_name [Lớp],age [Tuổi], dayoff [Ngày Nghỉ]
from Student,Class,Dayoff
where (class_name = '17T1' or class_name='17T2') and (dayoff='2019-12-20' or dayoff= '2019-12-12');    


Select name as [Tên],class_name [Lớp],age [Tuổi], dayoff [Ngày Nghỉ]
from Student,Class,Dayoff
where (class_name = '17T4' or class_name = '17T3') and  (dayoff='2019-12-10' or dayoff= '2019-12-11');


