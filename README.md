# Databases 2020: DataBasics platform
[![MySQL](https://img.shields.io/badge/MySQL-8.0.24-9cf.svg)](https://www.mysql.com/)
[![Java](https://img.shields.io/badge/Java-11-yellow.svg)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![Angular](https://img.shields.io/badge/AngularCLI-9.1.15-red.svg)](https://angular.io/)
[![TypeScript](https://img.shields.io/badge/TypeScript-3.8.3-blue.svg)](https://www.typescriptlang.org/)
[![Charts](https://img.shields.io/badge/Charts-ng2charts-blueviolet.svg)](https://www.typescriptlang.org/)<br/>
[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/Milwaukee-Bugs-NTUA/DataBasics/blob/master/LICENSE)
[![Open Source Love svg2](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/)

School of Electrical & Computer Engineering, NTUA<br/>
Project for the course [Databases](https://www.ece.ntua.gr/en/undergraduate/courses/flow/2), Spring Semester 2020

This repo was created for version control of the project implemented during Database course in the department of Electrical & Computer Engireering School, NTUA. The main goal was the construction of a data management platform of a virtual store. Further information can be found in the [related pdf file](https://github.com/Milwaukee-Bugs-NTUA/DataBasics/blob/master/Project_2020.pdf) (in greek).

## Directory Structure

For the directories of this project, we choose the structure mentioned above:

* The source code for the back-end is located in the folder `back-end`.
* The source code for the data-model is located in the folder `data-model`.
* Files for the ER-model are located in the folder `ER`.
* The folder `SQL Database Dumps` containes files for generating the database and its test data.
* The source code for the front-end is locate in the folder `front-end`.

As far as the dump files are concerned, we do not recommend you to include them in your project repos. However, we did just for presentation purposes to the teachers of this class.


## Installation Process

A detailed guide for the installation and testing of our platfom can be found inside the `INSTALLATION.md` file

## Technologies used

In this project we implemented several different techonologies and frameworks. 

* The build tool that we used was Gradle.
* To implement the database we specifically used MySQL.
* To achieve communication between the database and the back-end we used the spring JDBC.
* For the back-end server we used Jetty Server and Java Servlets from the Restlet Framework.
* The implementation of the back-end and data-model was written in Java 11.
* The implementation of the front-end was written in TypeScript/HTML5/CSS using the Angular Framework v.9, relying mainly on Angular Material.
* Our package manager was npm 
* The diagrams used were based on Ng2-Charts directives.

