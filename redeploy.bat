
cls
call git pull
call mvn clean package
call java -Dspring.datasource.url=jdbc:mysql://localhost:3306/courses?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC -jar target\server-courses-1.0.jar