create table cart (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), product_count integer, product_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), description TEXT, large_category varchar(255), limit_count integer, price integer, product_name varchar(255), product_status integer, purchase_count integer, rate_avg integer, sale_rate integer, shipping_cost integer, shipping_due_date integer, title_img varchar(255), total_count integer, user_id bigint, primary key (id)) engine=InnoDB
create table review (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), content TEXT, rate integer, title varchar(255), product_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), email varchar(255) not null, name varchar(255) not null, picture varchar(255), role varchar(255) not null, primary key (id)) engine=InnoDB
create table recently_viewed_product (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), product_id bigint, user_id bigint, primary key (id)) engine=InnoDB
create table qnapost (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), content TEXT, title varchar(255), product_id bigint, super_qna_post_id bigint, user_id bigint, primary key (id)) engine=InnoDB

alter table cart add constraint FK3d704slv66tw6x5hmbm6p2x3u foreign key (product_id) references product (id)
alter table cart add constraint FKl70asp4l4w0jmbm1tqyofho4o foreign key (user_id) references user (id)
alter table product add constraint FK979liw4xk18ncpl87u4tygx2u foreign key (user_id) references user (id)
alter table review add constraint FKiyof1sindb9qiqr9o8npj8klt foreign key (product_id) references product (id)
alter table review add constraint FKiyf57dy48lyiftdrf7y87rnxi foreign key (user_id) references user (id)
alter table recently_viewed_product add constraint FKh722183wyny8uu59uml38qvd7 foreign key (product_id) references product (id)
alter table recently_viewed_product add constraint FKqc13dojocmy73f3fmalidcdiy foreign key (user_id) references user (id)
alter table qnapost add constraint FK4m1x42su2x168ne0h8wv0e9mg foreign key (product_id) references product (id)
alter table qnapost add constraint FKgi0k69f6ox2f3sou68utg0d7p foreign key (super_qna_post_id) references qnapost (id)
alter table qnapost add constraint FKissyk9klje5414fpl74t2vmxj foreign key (user_id) references user (id)