#!/bin/sh

X_SHIFT=${1?0}
Y_SHIFT=${2?14}
H_RES=${3}
V_RES=${4}

xsetroot -solid '#EFEEEE'

if [[ $(xdotool search --onlyvisible --name emulator) ]];
then
        ID=$(xdotool search --onlyvisible --name emulator)
        xdotool windowmove $ID $X_SHIFT $Y_SHIFT;
        xdotool windowsize $ID $H_RES $V_RES;
        echo "success";
else
        echo "fail";
fi
