#!/bin/bash
#Date:2017/06/05
#Version:1.0.0
#Description:

accountPath='/usr/local/account-api/scripts';
installLogFile='/usr/local/account-api/scripts/install/install.log';


if [[ ! -z $(rpm -qa | grep wget) ]];
then
   echo "wget had existed."
else
   yum -y install wget
fi

if [[ ! -z $(rpm -qa | grep unzip) ]];
then
   echo "unzip had existed."
else
   yum -y install unzip
fi

if [[ ! -z $(rpm -qa | grep lsof) ]];
then
   echo "lsof had existed."
else
   yum -y install lsof
fi

# myDir
if [ ! -f "$installLogFile" ];
then
 touch "$installLogFile"
fi
