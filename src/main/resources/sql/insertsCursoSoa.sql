CREATE TABLE devsoa.employee
( emp_id       NUMBER NOT NULL,
  emp_name     VARCHAR2(200) NOT NULL,
  emp_alias    VARCHAR2(100),
  emp_password VARCHAR2(50),
  emp_dni      VARCHAR2(11),
  emp_email    VARCHAR2(100),  
  CONSTRAINT emp_pk PRIMARY KEY (emp_id)
);

CREATE TABLE devsoa.task
( task_id            NUMBER NOT NULL,
  task_name          VARCHAR2(250) NOT NULL,
  emp_id             NUMBER,
  task_dateini       DATE,
  task_date_end      DATE,
  task_status        NUMBER,   -- 0 No iniciada, 1 En proceso, 2 Finalizada  
  CONSTRAINT task_pk PRIMARY KEY (task_id)
);


-- Creacion de seccuencias 
CREATE SEQUENCE devsoa.emp_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 CREATE SEQUENCE devsoa.task_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

--Insert Table employee
insert into devsoa.employee(emp_id, emp_name, emp_alias, emp_password, emp_dni, emp_email)
       values (devsoa.emp_seq.nextval,'Luis Santiago Salas','lsalas01','12345','12345678901','lsa01@tot.com');
insert into devsoa.employee(emp_id, emp_name, emp_alias, emp_password, emp_dni, emp_email)
       values (devsoa.emp_seq.nextval,'Liliana Jaramillo Torres','ljaramillo01','54321','54321678901','ljara01@jata.com'); 
--Insert Table task
insert into devsoa.task(task_id, task_name, emp_id, task_dateini, task_date_end, task_status)
       values (devsoa.task_seq.nextval,'Instalar Windows 8',1,sysdate,trunc(sysdate) + 3,0);       
insert into devsoa.task(task_id, task_name, emp_id, task_dateini, task_date_end, task_status)
       values (devsoa.task_seq.nextval,'Instalar Office 2013',1,trunc(sysdate)+4,trunc(sysdate)+7,0);    
insert into devsoa.task(task_id, task_name, emp_id, task_dateini, task_date_end, task_status)
       values (devsoa.task_seq.nextval,'Instalar Oracle 11g',2,sysdate,trunc(sysdate)+2,0);        
COMMIT;                  
