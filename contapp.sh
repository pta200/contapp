#!/bin/bash


JMX_OPTS=""
APP_OPTS=""
APP_HOME=""
JAVA_HOME=""
RETVAL=0

. /etc/rc.d/init.d/functions

export DB_URL=""

case "$1" in
	start)
		echo "start service...."
		nohup java -jar $APP_HOME/contapp-0.0.1-SNAPSHOT.jar > $APP_HOME/app.log 2>&1 &
		RETVAL=$?
	;;
	stop)
		echo "stop service...."
		kill $(ps aux | grep [c]ontapp | awk '{print $2}')
		RETVAL=$?
	;;
	*)
		echo "Usage $0 {start|stop}"
		exit 1
	;;
esac
#if [ $RETVAL -eq 0 ]; then
#	success
#else
#	failure
#fi
success
echo
exit 0