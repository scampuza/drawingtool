pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''mvn clean
mvn package'''
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Publish') {
      steps {
        archiveArtifacts 'target/*.jar'
      }
    }
  }
}