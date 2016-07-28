#!/bin/sh
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8) 

bazel test src/java/multiply-test
bazel run src/java/multiply-main

bazel test src/rust/multiplier_test
bazel run src/rust/multiplier_main

#move this to bazel if possible
npm install && npm test
