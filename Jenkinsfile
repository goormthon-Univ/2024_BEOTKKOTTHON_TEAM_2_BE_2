pipeline {
    agent any
    tools {
        jdk "java"
        gradle "gradle"
    }
    environment {
        cloud {
            aws {
                s3 {
                    bucket = env.cloud.aws.s3.bucket
                }
                stack {
                    auto = env.cloud.aws.stack.auto
                }
                region {
                    static = env.cloud.aws.region.static
                }
                credentials {
                    accessKey = env.cloud.aws.credentials.accessKey
                    secretKey = env.cloud.aws.credentials.secretKey
                }
            }
        }
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Install Dependencies') {
            steps {
                script {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew build'
                }
            }
        }
        stage('Build And Deploy') {
            steps {
                script {
                    sh "java -Daws.accessKeyId=${cloud.aws.credentials.accessKey} -Daws.secretKey=${cloud.aws.credentials.secretKey} -jar ./build/libs/muckkitlist_spring-0.0.1-SNAPSHOT.jar"
                }
            }
        }
    }
}
