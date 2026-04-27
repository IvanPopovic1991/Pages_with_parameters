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
                script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            results: [[path: 'allure-results']]
                    ])
                }
            }
        }
        stage('Debug files') {
            steps {
                sh 'ls -R target || true'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/screenshots/**/*.png, target/**/*.log', allowEmptyArchive: true
        }
        failure {
            echo 'Build failed'
        }
        success {
            echo 'Build successful'
        }
    }
}