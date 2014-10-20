#!/bin/sh
# This script installs Scala 2.11.2, and is mostly intented to be used if you're following this course
# in Cloud9 IDE - https://c9.io

sudo apt-get remove scala-library scala
wget http://www.scala-lang.org/files/archive/scala-2.11.2.deb
sudo dpkg -i scala-2.11.2.deb
sudo apt-get update
sudo apt-get install scala
