#!/bin/bash

# compile and move binaries to bin/
javac Game.java && \
    mv *.class ./bin/

# run class and return
cd ./bin && \
    java Game && \
    cd -

