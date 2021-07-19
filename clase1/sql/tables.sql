create table usuarios (
   id varchar(36) not null, 
   apellido varchar(255), 
   domicilio varchar(255), 
   nombre varchar(255), 
   pais varchar(255), 
   salario integer, 
   tipo_de_usuario integer, 
primary key (id)) engine=InnoDB

