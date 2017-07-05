pipeline {
  agent {
    docker {
      image 'docker.io/mfriedenhagen/docker-maven'
    }
    
  }
  stages {
    stage('Build') {
      steps {
        sh '''mvn clean
mvn package'''
      }
    }
  }
}