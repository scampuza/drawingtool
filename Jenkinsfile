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
        junit 'target/surefire-reports/*'
      }
    }
    stage('Publish') {
      steps {
        archiveArtifacts 'target/*.jar'
      }
    }
  }
}