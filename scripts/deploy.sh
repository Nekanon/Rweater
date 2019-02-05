#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i C:/Users/Evgen/.ssh/id_rsa \
    target/rweater-1.0-SNAPSHOT.jar \
    nek@192.168.56.102:/home/nek/

echo 'Restart server...'

ssh -i C:/Users/Evgen/.ssh/id_rsa nek@192.168.56.102 << EOF

     pgrep java | xargs kill -9
     nohup java -jar rweater-1.0-SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'