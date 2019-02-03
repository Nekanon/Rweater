#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa_starlabs \
    target/rweater-1.0-SNAPSHOT.jar \
    nek@192.168.0.107:/home/nek/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa_starlabs nek@192.168.0.107 << EOF

pgrep java | xargs kill -9
nohup java -jar rweater-1.0-SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'