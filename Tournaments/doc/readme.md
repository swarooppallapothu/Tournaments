DATABASE

execute 1,3

1) Execute following command on postgres console.
CREATE USER tournament WITH PASSWORD 'tournament';
CREATE DATABASE tournament ;
GRANT ALL PRIVILEGES ON DATABASE tournament TO tournament;
2) just in case. Don't execute now:
DROP DATABASE `tournament`;
DROP USER  'tournament';
3) Execute Following SQL file on postgres
doc\Tournament.sql

Now you should have initial database. If you would like to renew database state then execute 2,1,3
Administration login/password: admin/admin
User login/password: through signup procedure

GLASSFISH

4) modify database details on JPAConfig.java. Add the following:
    Open <Project_Folder>src\main\resources\META-INF\persistence.xml. Modify Db properties

5) launch server: run tomcat


