#!/bin/bash
docker build -t swift ./src/swift && docker run -v `pwd`:/opt/source -it swift /bin/bash
