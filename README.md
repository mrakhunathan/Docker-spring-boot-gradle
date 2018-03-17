# Docker-spring-boot-gradle
Docker-spring-boot-gradle Skeleton

### Refresh Gradle Dependencies
./gradlew build  --refresh-dependencies -x test

### Build Your Gradle Project
gradle build -x test

### Run 'buildDocker' task defined in build.gradle
gradle buildDocker -x test

### List Docker Images to see if the newly built image is added
docker images

### Run the image in a container 
(7c45ceab4331 is the image id)
docker run -it 7c45ceab4331 /bin/bash

### In case if the above didn't work 
(7c45ceab4331 is the image id)
docker run -it 7c45ceab433

### Get Status of Running Containers
docker ps

### Get Status of Running Containers 
(61a4b41e4c2e is the id of container not image)
docker inspect --format '{{ .NetworkSettings.IPAddress }}' 61a4b41e4c2e


### Deleting the image (7c45ceab4331 is the image id)
docker rmi 7c45ceab4331

### In case if you are deploying a war inside a tomcat image 
(37f264a0f40f is the container id)
docker cp /home/rakhu/Desktop/sample.war 37f264a0f40f:/usr/local/tomcat/webapps
