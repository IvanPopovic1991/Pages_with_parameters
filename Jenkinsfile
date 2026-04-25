pipeline {

    agent any

    tools {
        maven 'Maven'
    }

    environment {
        HEADLESS = 'true'
        ChromeExeFilePath = '/usr/bin/google-chrome'
    }

    stages {

        stage('Checkout') {
            steps {
                git credentialsId: 'github-token',
                        url: 'https://github.com/IvanPopovic1991/Pages_with_parameters.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn -q clean test'
            }
        }

        stage('Test Report') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false,
                        results: [[path: 'allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.log', allowEmptyArchive: true
        }
        failure {
            echo 'Build failed'
        }
        success {
            echo 'Build successful'
        }
    }
}