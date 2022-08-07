call mvn ^
-Dtomcat.server.id=www.dgkim.net ^
-Dtomcat.manager.url=https://www.dgkim.net/manager1 ^
-e ^
tomcat:redeploy
call mvn ^
-Dtomcat.server.id=www.dgkim.net ^
-Dtomcat.manager.url=https://www.dgkim.net/manager2 ^
-e ^
tomcat:redeploy
