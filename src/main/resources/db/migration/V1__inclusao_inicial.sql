create table cliente (id bigint not null auto_increment,
                      sexo varchar(1) not null,
                      cpf varchar(11) not null,
                      data_nascimento date not null,
                      email varchar(255) not null,
                      estado_civil varchar(255) not null,
                      nome varchar(255) not null,
                      status bit not null,
                      primary key (id)) engine=InnoDB;

insert into cliente (sexo, cpf, data_nascimento, email, estado_civil, nome, status) values ('M', '31999292929', '1989-03-03', 'atila.sistemas@gmail.com', 'S', 'Atila Augusto dos santos', 1);
