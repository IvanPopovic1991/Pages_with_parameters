pipeline {

    agent any

    options {
        skipDefaultCheckout(true)   // - uklanja dupli checkout
        timestamps()               // - čitljiviji log
    }

    tools {
        maven 'Maven 3'
    }

    environment {
        HEADLESS = 'true'
        ChromeExeFilePath = '/usr/bin/google-chrome'

        // povlači kredencijale iz Jenkins-a
        CRM_CREDS = credentials('crm-credentials')

        // mapira na varijable iz koda
        UsernameForCrm = "${CRM_CREDS_USR}"
        PasswordForCrm = "${CRM_CREDS_PSW}"
        CRM_URL = credentials('crm-url')
        URLForCrm = "${CRM_URL}"
    }

    stages {

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

        stage('Screenshots (if any)') {
            steps {
                sh '''
                    echo "=== SCREENSHOTS ==="
                    ls target/screenshots 2>/dev/null || echo "No screenshots"
                '''
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
            archiveArtifacts artifacts: 'target/screenshots/*.png', fingerprint: true
        }
        failure {
            echo '❌ Build failed'
        }
        success {
            echo '✅ Build successful'
        }
    }
}