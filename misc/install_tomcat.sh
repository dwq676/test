#!/bin/sh
#Date:2017/06/05
#Version:1.0.0
#Author:daiwq

export JAVA_HOME=/usr/local/java/jdk1.8.0_131
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$JAVA_HOME/bin:$PATH

TOMCAT_PATH='/usr/local/java/apache-tomcat-8.0.44'
JAVA_PATH='/usr/local/java/'
TOMCAT_NAME='apache-tomcat-8.0.44.tar.gz'
function install_tomcat()
{
    if [ ! -d "$TOMCAT_PATH" ];
    then
        if [ ! -f "$TOMCAT_NAME" ];
        then
            wget http://softrepo.qtlcdn.com/third_party/java/apache-tomcat-8.0.44.tar.gz
        fi

        tar -zxvf "$TOMCAT_NAME" -C "$JAVA_PATH"

        rm -rf $TOMCAT_PATH"/webapps/docs"
        echo "rm -rf "$TOMCAT_PATH"/webapps/docs"

        rm -rf $TOMCAT_PATH"/webapps/ROOT"
        echo "rm -rf "$TOMCAT_PATH"/webapps/ROOT"

        mkdir $TOMCAT_PATH"/webapps/ROOT"
        echo "mkdir "$TOMCAT_PATH"/webapps/ROOT"

        unzip  /usr/local/account-api/softwares/account.war -d $TOMCAT_PATH"/webapps/ROOT/"

        sh $TOMCAT_PATH"/bin/startup.sh"
        echo "tomcat had started...."

    else
        echo "tomcat had existed"
    fi
}

if [ ! -d "$TOMCAT_PATH" ];
then
   install_tomcat
fi

