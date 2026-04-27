pipeline {

    agent any

    tools {
        maven 'Maven 3'
    }

    environment {
        HEADLESS = 'true'
        ChromeExeFilePath = '/usr/bin/google-chrome'
    }

    stages {

        stage('DEBUG PIPELINE') {
            steps {
                sh 'echo "=== NEW PIPELINE ACTIVE ==="'
            }
        }

        stage('Checkout') {
            steps {
                git url: 'https://github.com/IvanPopovic1991/Pages_with_parameters.git'
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    try {
                        sh 'mvn -q clean test -DHEADLESS=true'
                    } catch (Exception e) {
                        echo "Test failed but pipeline continues"
                    }
                }
            }
        }

        stage('CHECK SCREENSHOTS') {
            steps {
                sh 'echo "=== SCREENSHOTS ==="'
                sh 'ls -l target/screenshots || true'
            }
        }

        stage('CHECK ALLURE RESULTS') {
            steps {
                sh 'ls -R allure-results || true'
                sh 'ls -R target/allure-results || true'
            }
        }

        stage('Allure Report') {
            steps {
                allure([
                        includeProperties: false,
                        results: [[path: 'allure-results']]
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/screenshots/*.png', allowEmptyArchive: true
        }
        failure {
            echo 'Build failed'
        }
        success {
            echo 'Build successful'
        }
    }
}