# Docker-spring-boot-gradle
Docker-spring-boot-gradle Skeleton

#Refresh Gradle Dependencies
./gradlew build  --refresh-dependencies -x test

#Build Your Gradle Project
gradle build -x test

#Run 'buildDocker' task defined in build.gradle
gradle buildDocker -x test

#List Docker Images to see if the newly built image is added
docker images

#Run the image in a container (7c45ceab4331 is the image id)
docker run -it 7c45ceab4331 /bin/bash

#In case if the above didn't work (7c45ceab4331 is the image id)
docker run -it 7c45ceab433