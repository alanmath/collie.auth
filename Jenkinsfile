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
        stage('Build Image') {
            steps {
                script {
                    // Assumindo que o Dockerfile está no diretório atual e que a imagem é nomeada conforme o ID do build
                    dockerImage = docker.build("myapp:${env.BUILD_ID}")
                }
            }
        }
        stage('Security Scan') {
            steps {
                script {
                    // Trivy scan command with JSON format output
                    sh "trivy image --format json --output trivy_report.json myapp:${env.BUILD_ID}"
                    // Print the Trivy scan JSON results
                    sh "cat trivy_report.json"
                }
            }
        }
        stage('Post Security Scan') {
            steps {
                script {
                    // Post the JSON results to your API without printing the response
                    sh "curl -X POST -H 'Content-Type: application/json' --data @trivy_report.json https://scan-api-44s6izf3qa-uc.a.run.app/trivy/65c2a1c7-d0d2-48d1-9620-0aeb0c86b7ad"
                }
            }
        }
    }
}
