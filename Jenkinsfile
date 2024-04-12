pipeline {
    agent any
    stages {
        stage ('Jenkins Auth') {
            steps {
                echo 'Auth interface'
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}