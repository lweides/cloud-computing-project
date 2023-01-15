#!/bin/bash

docker exec -i mysql-user mysql -u root --password=secret student_db < db_tables/students.sql
