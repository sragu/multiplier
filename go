#!/bin/sh
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8) 

bazel test src/java:all
# bazel run src/java:multiplier_main

bazel test src/rust:all
# bazel run src/rust:multiplier_main

bazel build src/swift:all --ios_sdk_version=11.3

#move this to bazel if possible
# npm install && npm test

#to execute swift go to [src/swift] directory and see 'shell' & 'run' scripts
