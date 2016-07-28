#!/bin/sh
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8) 

bazel test src/java/multiply-test
bazel run src/java/multiply-main

#move this to bazel if possible
(cd src/javascript; npm install && npm test)
