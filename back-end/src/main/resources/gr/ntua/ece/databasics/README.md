# JDBC Configuration Steps 
* Create a copy of tha app-default.properties file and place it here
* Change the fields username / password / database schema name in the aforamentioned file based and your database credentials
## Windows Specific users with other languages as system language (other than English)
If you have for example greek or any other language other than English as your system language, replace the dp.url line with 
```
db.url = jdbc:mysql://localhost/<your database schema>?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowLoadLocalInfile=true 
```