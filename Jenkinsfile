pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''mvn clean
mvn package'''
      }
    }
  }
}