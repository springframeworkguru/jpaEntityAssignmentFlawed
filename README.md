# jpaEntityAssignmentFlawed
Final version after code review and code comparison still has some issues
1. Cannot create ORDER_DETAIL table:
2017-02-20 16:24:35.099 ERROR 6359 --- [  restartedMain] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000389: Unsuccessful: create table order_detail (id integer generated by default as identity, date_created timestamp not null, last_updated timestamp, version integer, quantity integer, order integer, product integer, primary key (id))
2017-02-20 16:24:35.099 ERROR 6359 --- [  restartedMain] org.hibernate.tool.hbm2ddl.SchemaExport  : Syntax error in SQL statement "CREATE TABLE ORDER_DETAIL (ID INTEGER GENERATED BY DEFAULT AS IDENTITY, DATE_CREATED TIMESTAMP NOT NULL, LAST_UPDATED TIMESTAMP, VERSION INTEGER, QUANTITY INTEGER, ORDER[*] INTEGER, PRODUCT INTEGER, PRIMARY KEY (ID)) "; expected "identifier"; SQL statement:
create table order_detail (id integer generated by default as identity, date_created timestamp not null, last_updated timestamp, version integer, quantity integer, order integer, product integer, primary key (id)) [42001-192]
2017-02-20 16:24:35.139 ERROR 6359 --- [  restartedMain] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000389: Unsuccessful: alter table order_detail add constraint FK4pjqrc8cputeqlyh0cpycvvpp foreign key (order) references order_header
2017-02-20 16:24:35.139 ERROR 6359 --- [  restartedMain] org.hibernate.tool.hbm2ddl.SchemaExport  : Syntax error in SQL statement "ALTER TABLE ORDER_DETAIL ADD CONSTRAINT FK4PJQRC8CPUTEQLYH0CPYCVVPP FOREIGN KEY (ORDER[*]) REFERENCES ORDER_HEADER "; expected "identifier"; SQL statement:
alter table order_detail add constraint FK4pjqrc8cputeqlyh0cpycvvpp foreign key (order) references order_header [42001-192]
2017-02-20 16:24:35.139 ERROR 6359 --- [  restartedMain] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000389: Unsuccessful: alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product
2017-02-20 16:24:35.139 ERROR 6359 --- [  restartedMain] org.hibernate.tool.hbm2ddl.SchemaExport  : Table "ORDER_DETAIL" not found; SQL statement:
alter table order_detail add constraint FKd9sf38t1yu7b0gbcg6iyet4pv foreign key (product) references product [42102-192]
2017-02-20 16:24:35.144  INFO 6359 --- [  restartedMain] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000230: Schema export complete
2. Build succeeds in spite of these H2 issues; but Delete Product no longer works consistently.
3. After Customer edits, the Customer List does not reflect the change.
4. Delete Customer not working.
5. Crash saving a changed User.
6. Delete User not working (ignored the delete request).
7. Noticed "sm-2" in addition to "col-sm-2" in some Thymeleaf templates. Is that needed or a typo?
8. The delete test in CustomerServiceJpaDaoImplTest failed (error committing transaction, unsaved transient instance)!
9. JpaIntegrationConfig is deprecated; could my workaround be causing the issues above?
10. I am including hamcrest.CoreMatchers (your code has hamcrest.Matchers); could that be causing issues? Not sure how CoreMatchers got there.
SEE MY EMAIL FOR LOG AND SCREEN SHOTS OF FAILED EXECUTABLE ISSUES.
