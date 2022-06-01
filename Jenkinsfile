pipeline {
  agent any
  
  tools {
    maven "M3"
  }
  
  stages{
    stage('Clean') {
      steps{
        bat"mvn clean"
      }
    }
    stage('Test'){
      steps{
        bat "mvn test"
      
      }
    }
    stage('Install'){
      steps{
        bat "mvn install"
      
      }
    }
  }
}
  //post {
    //always
//    {
 //     echo "test toujouurs"
 //   }
 //   success
 //   {
 //     echo "SUCCESS"
 //   }
 //   failure
 //   {
 //     echo "FAILURE"
 //   }
 //   unstable
