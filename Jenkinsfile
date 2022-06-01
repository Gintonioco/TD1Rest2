pipeline {
  agent any
  
  tools {
    maven "M3"
  }
  
  stages{
    stage('Clean') {
      step{
        bat"mvn clean"
      }
    }
    stage('Test'){
      step{
        bat "mvn test"
      
      }
    }
    stage('Install'){
      step{
        bat "mvn install"
      
      }
    }
  }
  post {
    always
    {
      echo "test toujouurs"
    }
    success
    {
      echo "SUCCESS"
    }
    failure
    {
      echo "FAILURE"
    }
    unstable
