drop table OCRD;
drop table OITW;
create table OCRD( Id INT NOT NULL, Name VARCHAR(100), TaxId VARCHAR(40), PRIMARY KEY (Id,Name));
create table OITW( ItemCode VARCHAR(100) NOT NULL, WhsCode VARCHAR(100) NOT NULL, PRIMARY KEY (ItemCode,WhsCode));
insert into OCRD(Id, Name, TaxId) values(1,'name1','taxid1');
insert into OCRD(Id,Name, TaxId) values(2,'name2','taxid2');