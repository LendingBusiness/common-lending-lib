node {
   // Mark the code checkout 'stage'....
   stage 'Checkout'

   // Checkout code from repository
   checkout scm

   stage 'Build'
   cmd "${mvnHome}/bin/mvn clean install"
}