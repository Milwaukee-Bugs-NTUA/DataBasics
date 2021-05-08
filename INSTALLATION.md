# Installation Process

Following the steps mentioned bellow, you will be able to try this platform in your local computer. 
(It has been tested successfully in Linux and Windows machines only.)

## Prerequisites

* Install MySQL in your system and create database schema. You can import the entiry db, using the ddl files in the `SQL Database Dumps`. MySQL WorkBench is the easiest way to achive that.

* Install Java Runtime Enviroment / Java Development Kit (version 11) globally in your system.

* Install npm package manager and @angular/cli to your system.

## Running the platform

After cloning or downloading this repo to your local machine, navigate to the directory that you have chose, open two terminals and execute the following commands:

### Database - Backend Server communication configuration

Follow the commands bellow (Information for this step exist also inside the README.md file of the directory mentioned bellow):

```
cd DataBasics/back-end/src/main/resources/gr/ntua/ece/databases
cp app-default.properties app.properties # Or just copy this file manually
```
Finally put your db credentials in the app.properties file that you have created. The time zone of db and its data have been set to Europe/Athens (UTC+03:00).

### Running the Back-end Server

On the first terminal type and run the following commands:
``` 
cd Databasics/back-end
./gradlew apprun
```
The server listens at localhost:8765 (https protocol is required for the requests).

WARNING: If try to use gradle wrapper (./gradlew apprun command), without enabling the database server beforehand, the platform will not work and the back-end server will reply with a STATUS 503 response to every request.

### Running the Front-end Server

On the second terminal type and run the following commands:
``` 
cd Databasics/front-end
ng serve
```
If your trying to run the front-end server for the first time, run `npm install` inside the `front-end` directory first. The front-end server runs at localhost:4200.

### Trying the platform

Use any browser of your preference and navigate to page http://localhost:4200/ . Enjoy :)
