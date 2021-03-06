# drawingtool
drawing tool is an application designed for drawing simple forms in a canvas, like lines, rectangles

## Getting Started

This application is designed to be run on any platform which supports Java 8.  

### Prerequisites

In order to successfuly compile, build, test and run the drawingtool application, you need to install the following tools on your machine:

- Java JDK 1.8, which you can download from the following URL: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- Apache Maven 3.x, which you can download from the following URL https://maven.apache.org/download.cgi

- Git Client, from https://git-scm.com/download/win


### Installing

- You need to clone this git repository with the command:

```
git clone https://github.com/scampuza/drawingtool.git
```

- Then, you need to set the JAVA_HOME environment variable to the folder where you installed Java 8 JDK,and adjust the PATH variable to include the Java 1.8 installation:

Linux:

```
  export JAVA_HOME=/opt/java/jdk1.8.0_111
  export PATH=$JAVA_HOME/bin:$PATH
```
- Then, you need to set the MAVEN_HOME environment variable to the folder where you installed Maven 

Linux:  

```
  export MAVEN_HOME=/opt/apache-maven-3.3.9
```

- After that, you have to cd into the drawingtool folder (the git repository cloned).

Linux: 

```
  cd drawingtool/
```
- If everything went right, you should be able to compile, build, test and run the drawingtool application:

To generate the JAR package:  

```
  cd drawingtool/
  mvn package
```

## Running the tests

To execute the automated unit tests: 

```
  cd drawingtool/
  mvn test
```

## Running the standalone JAR application

If you want to run the JAR generated with "mvn package", you may follow the following steps:

```
  cd drawingtool/target
  java -jar drawingtool-1.0.0-SNAPSHOT.jar

```
## Using the application

 You can type ? or h as a command for getting help about how to use the application..

## Built With

* Eclipse Neon - IDE
* JUnit - Testing Framework
* Maven - Build and Testing Automation
* Java 8

## Authors

* **Santiago Campuzano Vallejo** - *Initial work* - (https://github.com/scampuza)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

