set GRADLE_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,address=8090,server=y,suspend=n

call gradle tomcatRun

pause
