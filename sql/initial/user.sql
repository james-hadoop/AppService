CREATE USER 'james'@'localhost' IDENTIFIED BY 'james';
CREATE USER 'james'@'%' IDENTIFIED BY 'james';

grant all privileges on *.* to 'james'@'localhost';
grant all privileges on *.* to 'james'@'%';