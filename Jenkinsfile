pipeline {

    agent any

    options {
        skipDefaultCheckout(true)
    }

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git credentialsId: 'github-token', url: 'https://github.com/IvanPopovic1991/Pages_with_parameters.git'
            }
        }

        stage('Build & Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }

    }

}