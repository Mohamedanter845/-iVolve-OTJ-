def call() {
    pipeline {
        agent any

        stages {
            stage('RunUnitTest') {
                steps {
                    echo "Running Unit Tests..."
                    sh 'mvn test'
                }
            }
            stage('BuildApp') {
                steps {
                    echo "Building the App..."
                    sh 'mvn package'
                }
            }
        }
    }
}
