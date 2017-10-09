CREATE USER 'james'@'localhost' IDENDIFIED BY 'james';
CREATE USER 'james'@'%' IDENDIFIED BY 'james';

grant all privileges on *.* to 'james'@'localhost';
grant all privileges on *.* to 'james'@'%';