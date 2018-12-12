
cls
call git pull
call mvn clean package
call java -Dspring.datasource.url=jdbc:mysql://localhost:3306/courses?useSSL=false -jar target\server-courses-1.0.jar