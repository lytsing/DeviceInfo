#!/bin/zsh
#
# Android Development on the Command Line, use Ant.
# Create by : Lytsing Huang
# Date: 2017-07-25
#

if [ $# != 1 ]; then
	echo "Usage: $0 [debug|release]";
	exit;
fi

PRJ=DeviceInfo
DATE=`date +%Y%m%d`
VER=1.0
NAME=$PRJ-$VER-$DATE
TARGET=android-24

android update project --path . --name $NAME -t $TARGET

ant $1

