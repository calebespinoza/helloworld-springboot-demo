pipeline {
    agent any
    environment {
        IMAGE_NAME = "calebespinoza/image:latest"
    }
    stages {
        stage ('Compile') {
            steps {
                sh "chmod +x ./gradlew"
                sh "./gradlew compileJava"
            }
        }

        stage ('Build') {
            steps {
                sh "./gradlew build -x test"
            }
        }

        stage ("Coverage") {
            steps {
                echo "Coverage"
            }
        }

        stage ("Code Static Analysis") {
            steps {
                echo "Code Static Analysis"
            }
        }

        stage ("Build Image") {
            steps {
                echo "Build an OCI image"
                //sh "./gradlew bootBuildImage --imageName=$IMAGE_NAME"
            }
        }
    }
}