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
    stage('Promote') {
      steps {
        input(message: 'Are you sure you want to promote this artifact to production?', id: 'promote_response', ok: 'Promote')
        echo 'This artifact has been promoted to production'
        waitUntil() {
          echo 'Promoting'
        }
        
      }
    }
  }
}