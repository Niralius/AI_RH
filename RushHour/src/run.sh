#!/bin/sh

javac *.java

if [ "$#" -gt 1]; then
	java Main "$1" "$2"
else
	java Main "$1"
fi
