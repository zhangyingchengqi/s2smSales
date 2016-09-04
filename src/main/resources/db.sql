
create database s2sm_sales;

       
--创建客户信息表
create table cus_customer
(
    cus_id int primary key auto_increment,
    cus_name varchar(100) not null,     
    cus_addr varchar(500) not null     
);


--创建产品信息表
create table sale_product(
   prod_id int primary key auto_increment,
   prod_name varchar(100) not null,        
   prod_price double not null         
);


--创建订单表
create table sale_order(
     odr_id int  primary key auto_increment,
     odr_customer_id int not null,           
     odr_customer_name varchar(100) not null,        
     odr_deliver_addr varchar(500) not null,         
     odr_order_date date not null,                    
     odr_deliver_date date not null,                  
     odr_status varchar(50)                           
);



--创建订单详细表
create table sale_order_line
(
   odl_id  int  primary key auto_increment,
   odl_order_id  int not null,              
   odl_product_name varchar(50),                   
   odl_product_price double  not null,           
   odl_product_count int not null                
);



--订单表与订单详细表的主外键关系
alter table sale_order_line
   add constraint FK_sale_order_line_id
      foreign key(odl_order_id) references sale_order(odr_id);
      
    
--测试数据  
insert into cus_customer(cus_name,cus_addr) values('中国工业集团','北京兴华门32号');
insert into cus_customer(cus_name,cus_addr) values('中国核工业集团','北京兴华门3333号');
--
insert into sale_product(prod_name,prod_price) values('GPS',3300.0);
insert into sale_product(prod_name,prod_price) values('安全电源',2345);



select * from cus_customer;
