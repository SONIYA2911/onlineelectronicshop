

create table user_register(name varchar2(20)not null,email_id varchar2(30),password varchar2(20),constraint pk_user primary key(email_id));
desc user_register;
select*from user_register;
alter table user_register modify email_id not null; 
alter table user_register modify password not null;


desc user_register;





-----component table
create table component_info(component_id varchar2(30),component_category_Id varchar2(30)not null,component_name varchar2(100),description varchar2(500),
             standard_cost number(10,2),list_price number(10,2),constraint pk_comid primary key(component_id));
             
-----customer details table

create table customer_details(customer_id varchar2(30)not null,customer_name varchar2(50),address varchar2(100),mobile_number varchar2(2),credit_limit number,
constraint pk_cusid primary key (customer_id));

----employee table
create table employees(employee_id varchar2(30)not null,first_name varchar2(30),last_name varchar2(30),employee_email varchar2(30),phone_number number(20),hire_date date,salary number,
job_title varchar2(30),constraint pk_ed primary key (employee_id));

---order items table

create table order_items(order_id varchar2(30),component_id varchar2(30),component_id varchar2(30),quantity int,unit_price number,
constraint fk_oid foreign key(order_id) references order_details(order_id),
constraint fk_comid foreign key(component_id) references component_info(component_id));
----order details table
create table order_details(order_id varchar2(30)not null,customer_id varchar2(30),component_category_id varchar2(50),user_id varchar2(3),address varchar2(100),
city varchar2(30),mobile_number number,salesman_id varchar2(20),
status varchar2(30),order_date date,constraint pk_oid primary key(order_id),
Constraint fk_cusid FOREIGN KEY(customer_id) References customer_details(customer_id));

----suppliers table
create table suppliers(supplier_id varchar(3),supplier_name varchar(30) NOT NULL,sup_address varchar(50),sup_mobile_number number NOT NULL,sup_email varchar(15),
CONSTRAINT pk_supid PRIMARY KEY(supplier_id));
create table login(user_name varchar2(20) not null,password varchar2(20));
insert into login values('soniya','sonyvrvs');
select*from login;
desc login;


create table register(reg_user_name varchar2(20)not null,reg_email varchar2(30),reg_password varchar2(20),constraint pk_reg primary key(reg_email));
select*from register;