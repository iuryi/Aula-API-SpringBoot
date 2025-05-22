create table compras (
	id int auto_increment primary key,
    data_compra datetime DEFAULT CURRENT_DATE,
    pessoa_id BIGINT,
	foreign key (pessoa_id) references table_name (id)
);