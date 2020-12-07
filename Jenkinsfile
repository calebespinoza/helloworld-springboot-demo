def httpStatus = ""
pipeline {
    agent { label "linux-agent-01" }//any
    environment {
        DOCKER_REGISTRY = "calebespinoza"
        IMAGE_NAME = "$DOCKER_REGISTRY/helloworld-springboot-demo"
        CONTAINER_NAME = "demo-springboot"
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
                sh "./gradlew bootBuildImage --imageName=$IMAGE_NAME:latest && docker images"
            }
        }

        stage ("Verify Container") {
            steps {
                script {
                    sh "docker run -d -p 8787:8787 --name $CONTAINER_NAME $IMAGE_NAME:latest"
                    sleep 30
                    httpStatus = sh ( returnStdout: true, script: 'curl -I http://localhost:8787/hello/Sitehands/Team --silent | grep 200' ).trim()
                    echo "HTTP STATUS: $httpStatus"
                }
            }
        }

        stage ("Upload Image") {
            steps {
                script {
                    if (httpStatus == "HTTP/1.1 200") {
                        echo "docker push $IMAGE_NAME"
                    }

                    sh "docker stop $CONTAINER_NAME && docker rm $CONTAINER_NAME && docker rmi $IMAGE_NAME:latest"
                }
            }
        }
    }
}