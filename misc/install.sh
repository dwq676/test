#!/bin/sh
#Date:2017/06/05
#Version:1.0.0
#Author:daiwq

DEPLOY_SPLITE='========================================================'

function show_table ()
{
    mysql -uquantil -pquantil@123456 -e "

    CREATE DATABASE IF NOT EXISTS account DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
    use account;
    #echo '+++++++++++++++++++++++++++++++++++++++'
    show tables;
    #echo '+++++++++++++++++++++++++++++++++++++++'
    "
}


sh /usr/local/account-api/scripts/install/install_pre.sh
echo $DEPLOY_SPLITE
sh /usr/local/account-api/scripts/install/install_jdk.sh
echo $DEPLOY_SPLITE
if [[ ! -z $(rpm -qa | grep mariadb) ]];
then
   echo "mariadb had existed."
else
   sh /usr/local/account-api/scripts/install/install_mariadb.sh
   echo $DEPLOY_SPLITE
   sh /usr/local/account-api/scripts/install/install_mariadb_init.sh
   echo $DEPLOY_SPLITE
   sh /usr/local/account-api/scripts/install/install_init_data.sh
fi
echo $DEPLOY_SPLITE
/usr/local/account-api/scripts/install/install_tomcat.sh


echo 'source /etc/profile'
#echo 'show the java version.........'
#java -verson
show_table
echo "Deploy successfully!"