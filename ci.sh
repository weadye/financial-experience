#!/bin/bash
mvn clean package
scp target/financial-experience-0.0.1.jar root@$PORTIP:/home/wade/Downloads
