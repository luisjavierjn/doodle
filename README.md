MOTIVATION
------------------
a) what motivated your technologies choices,
when I saw the json file, I realized that I had semi structured data, besides there is a requirement for searching into the data, so the obvious choice was MongoDB, a database document oriented. I am Java Backend Developer so that is my natural choice about the language, and finally docker-compose is pretty easy

b) how you tackled the task
First I made the development of the java-mongo project and after that I started with the docker stuffs. Regarding to docker, I first did all the steps using conventional docker instructions and then I ended up doing the docker-compose.yml file

sudo docker network create exam_luis_net

sudo docker run --name spring-demo-mongo --network=exam_luis_net -v /home/exam/mongo_data:/data/db -v /home/exam/json_files:/json_data -d mongo 

sudo docker build -t exam-luis-image . # execute from the folder javamongo

sudo docker run --name exam-luis-container --network=exam_luis_net -p 8080:8080 -d exam-luis-image

sudo docker logs exam-luis-container

sudo docker exec -it exam-luis-mongo bash # in another terminal

mongoimport -d doodle -c polls --jsonArray /json_data/Doodle.json

c) what you would do differently were you given more time, 
Upload the project to AWS

d) what you would differently a second time around
Maybe I would include more specifications about the network used by the containers instead of leave it to default

e) others related
I used 3 containers, 2 of them are for deploying the application, it include a container for MongoDB and another for the Spring Boot project which I created from an image that I made starting from an standard openjdk image and my jar file. These two container are using docker-compose. The other container is a MongoDB instance that run just once in background to upload data to the MongoDB instance of the application. This container is built with a Dockerfile
By the way, the source project has the .git folder inside and have some junit tests

HOW TO
------------

**** Design an API endpoint to list all polls created by a user
○ Data should be fetched from the database
○ The endpoint should return a list of polls in JSON format
○ The API should support text search
○ The API should support filtering on the creation date (e.g. return all polls
created after 1 January 1970)

All the requirements are accomplished and I send you a json file from postman with all end points

In order to kick off the services please go inside the folder javamongo and run the following sentence:

sudo docker-compose up

Others useful sentences are the following:

sudo docker-compose config --services
sudo docker-compose ps
sudo docker-compose start
sudo docker-compose stop
sudo docker-compose down

**** Provide a way to import the JSON polls into one of the above containerized
databases. We will use this to populate the database before running your project *****

I created an image just for uploding the data to the project. So you first start the project with docker-compose and afterward create this image so then you can always run a container to upload a Doodle.json file

sudo docker build -t load-json  .
sudo docker run -d --rm --network=javamongo_default load-json

To test the communication you can go inside the container and run the same command that is in the Dockerfile

sudo docker run -it --network=javamongo_default load-json bash

