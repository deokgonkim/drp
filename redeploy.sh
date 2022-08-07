#!/bin/bash
mvn \
-Dtomcat.server.id=www.dgkim.net \
-Dtomcat.manager.url=https://www.dgkim.net/manager \
-e \
tomcat:redeploy
