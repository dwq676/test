#!/bin/sh
#Date:2017/06/05
#Version:1.0.0
#Author:daiwq


function install_mariadb ()
{
    if [[ ! -z $(rpm -qa | grep expect) ]];
    then
       echo "expect had existed."
    else
       yum -y install expect
    fi

    if [[ ! -z $(rpm -qa | grep mariadb) ]];
    then
       echo "mariadb had existed."
    else
       yum -y install mariadb mariadb-server
       systemctl start mariadb
       systemctl enable mariadb
    fi
}

install_mariadb;
