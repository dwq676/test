#!/bin/sh

LOG_FILE='/usr/local/account-api/scripts/install/install.log'
JAVA_PATH="/usr/local/java"
JDK_PATH='/usr/local/java/jdk1.8.0_131'
JDK_SOFTWARE_FILE='jdk-8u131-linux-x64.tar.gz'
JDK_SOFTWARE_PATH='/usr/local/account-api/softwares'


function install_jdk()
{
    #echo '1111'
    if [ ! -f "$JDK_SOFTWARE_FILE" ];
    then
       wget  http://softrepo.qtlcdn.com/third_party/java/jdk-8u131-linux-x64.tar.gz
    fi

    if [ ! -d "$JAVA_PATH" ];
    then
       mkdir "$JAVA_PATH"
    fi

    #if [ ! -d "$JDK_PATH" ];
    #then
    #  mkdir "$JDK_PATH"
    #fi

    tar -zxvf "$JDK_SOFTWARE_FILE" -C "$JAVA_PATH"
    # /etc/profile
    echo 'export JAVA_HOME=/usr/local/java/jdk1.8.0_131'  |tee -a  /etc/profile ~/.bashrc ~/.bash_profile ../../conf/my.conf
    echo 'export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar' |tee -a  /etc/profile ~/.bashrc ~/.bash_profile ../../conf/my.conf
    echo 'export PATH=$JAVA_HOME/bin:$PATH' |tee -a  /etc/profile ~/.bashrc ~/.bash_profile ../../conf/my.conf

}

# myDir
if [ ! -d "$JDK_PATH" ];
then
   install_jdk
fi

.  /etc/profile
.  ~/.bashrc
.  ~/.bash_profile
. ../../conf/my.conf
#if [ -r ~/.profile ]; then . ~/.profile; fi
#case "$-" in *i*) if [ -r ~/.bashrc ]; then . ~/.bashrc; fi;; esac
