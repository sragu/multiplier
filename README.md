# multiplier
multiplication using peasant tables

Reference - http://mathforum.org/dr.math/faq/faq.peasant.html

## Languages

 [Java](src/java), [Rust](src/rust), [JavaScript](src/javascript), [Swift3](src/swift)
 
## Approach

 * straight forward implementation of the algorithm.
 * source and tests in same directory where possible
 * leaned towards [Generator](https://en.wikipedia.org/wiki/Generator_%28computer_programming%29) where available, or Iterator otherwise
 
## Build

 * Uses [Bazel](http://www.bazel.io) for building java/rust
 * Uses npm for building javascript
 * Uses Swift Package Manager for Swift (on linux w/ docker)
 
## Start

 * Get Bazel installed - `brew install bazel`
 * Get NodeJs installed - `brew install node`
 * Run `./go`
 
## Miscellaneous
 
  * Swift - under src/swift, you will find start/run scripts which will help to execute Swift code/tests
