pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }
    stages {
        stage('Delete workspace') {
            steps {
                cleanWs()
                echo 'Deleting workspace'
                echo params.device
            }
        }
        stage('Checkout to SCM') {
            steps {
                checkout scm
                echo "Cloning the repository"
            }
        }
        stage("Build") {
            steps {
              withMaven(
                  maven:'Maven'
                  ){
                  bat "mvn test"
              }
            }

        }
    }
}
