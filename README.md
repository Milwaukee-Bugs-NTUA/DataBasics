# Databases 2020: DataBasics platform
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

A detailed guide for the installation and testing of our platfom can be found on the `INSTALLATION.md` file

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

