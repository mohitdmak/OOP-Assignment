#!/bin/bash

# compile inside src dir
cd ./src

# move all binaries into bin
javac signupGUI.java && \
    mv *.class ../bin/

# run class and return
cd ../bin && \
    java signupGUI && \
    rm *.class && \
    cd ..

