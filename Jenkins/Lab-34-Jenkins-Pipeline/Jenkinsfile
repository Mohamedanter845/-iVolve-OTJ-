pipeline {
    agent any

    environment {
        IMAGE_NAME = 'mohamedanter845/lab34app'
        VERSION = 'v1'
    }

    stages {
        stage('Run Unit Test') {
            steps {
                echo 'Running Unit Tests...'
                sh 'mvn test'
            }
        }

        stage('Build App') {
            steps {
                echo 'Building App...'
                sh 'mvn package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker Image...'
                sh 'docker build -t $IMAGE_NAME:$VERSION .'
            }
        }

        stage('Push Docker Image') {
            steps {
                echo 'Pushing Docker Image...'
                withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push $IMAGE_NAME:$VERSION'
                }
            }
        }

        stage('Remove Local Image') {
            steps {
                echo 'Removing Local Docker Image...'
                sh 'docker rmi $IMAGE_NAME:$VERSION'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}

