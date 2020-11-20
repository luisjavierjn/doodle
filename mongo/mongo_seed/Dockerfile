FROM mongo

RUN mkdir -p ~/json_files
COPY Doodle.json /json_files/Doodle.json
CMD mongoimport --host spring-demo-mongo --db doodle --collection polls --type json --file /json_files/Doodle.json --jsonArray

