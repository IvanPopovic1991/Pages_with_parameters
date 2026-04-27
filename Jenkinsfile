pipeline {

    agent any

    tools {
        maven 'Maven 3'
    }

    environment {
        HEADLESS = 'true'
        ChromeExeFilePath = '/usr/bin/google-chrome'
        // Allure CLI path (bez root instalacije)
        PATH = "$HOME/tools/allure/bin:$PATH"
    }

    stages {

        stage('DEBUG PIPELINE') {
            steps {
                sh 'echo "=== NEW PIPELINE ACTIVE ==="'
            }
        }

        stage('Checkout') {
            steps {
                git credentialsId: 'github-token',
                        url: 'https://github.com/IvanPopovic1991/Pages_with_parameters.git'
            }
        }

        // provera Allure instalacije
        stage('Check Allure') {
            steps {
                sh 'echo "PATH=$PATH"'
                sh 'which allure || true'
                sh 'allure --version || true'
            }
        }

        stage('Build & Test') {
            steps {
                // prosleđujemo HEADLESS kao system property
                sh 'mvn -q clean test -DHEADLESS=true'
            }
        }

        stage('Test Report') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        // da li postoji allure-results
        stage('Allure Results Debug') {
            steps {
                sh 'echo "=== ALLURE RESULTS ==="'
                sh 'ls -R target/allure-results || true'
            }
        }

        // koristi target/allure-results
        stage('Allure Report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }

        // DEBUG: screenshots
        stage('Screenshots Debug') {
            steps {
                sh 'echo "=== SCREENSHOTS ==="'
                sh 'ls -R target/screenshots || true'
            }
        }

        stage('Debug files') {
            steps {
                sh 'echo "=== TARGET FOLDER ==="'
                sh 'ls -R target || true'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/screenshots/**/*.png, **/target/allure-results/**, **/target/surefire-reports/**', allowEmptyArchive: true
        }
        failure {
            echo 'Build failed'
        }
        success {
            echo 'Build successful'
        }
    }
}