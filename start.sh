#!/bin/bash

# compile and move binaries to bin/
javac signupGUI.java && \
    mv *.class ./bin/

# run class and return
cd ./bin && \
    java signupGUI && \
    rm *.class && \
    cd -

