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
        junit 'target/surefire-reports/*.xml'
      }
    }
    stage('Publish') {
      steps {
        archiveArtifacts 'target/*.jar'
        mail(subject: 'drawing-tool-publish', body: 'drawing-tool-publish ', from: 'scampuza@gmail.com', to: 'scampuza@gmail.com')
      }
    }
  }
}