create table itensCompra(
	id int auto_increment primary key,
    compra_id int,
    produto_id int,
    quantidade int,
    precoUnitario double,
    foreign key (compra_id) references compras (id),
    foreign key (produto_id) references produtos(id)
    );