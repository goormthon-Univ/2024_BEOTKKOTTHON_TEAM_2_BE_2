pipeline {
    agent any
    tools {
        jdk "java"
        gradle "gradle"
    }
    environment {
        cloud.aws.s3.bucket = env.cloud.aws.s3.bucket
        cloud.aws.stack.auto = env.cloud.aws.stack.auto
        cloud.aws.region = env.cloud.aws.region
        cloud.aws.credentials.access-key = env.cloud.aws.credentials.access-key
        cloud.aws.credentials.secret-key = env.cloud.aws.credentials.secret-key
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        //후에 자바 스프링 관련 추가
        //window는 sh -> bat 변경 필요
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
                    sh "java -Daws.accessKeyId=${cloud.aws.credentials.access-key} -Daws.secretKey=${cloud.aws.credentials.secret-key} -jar ./build/libs/muckkitlist_spring-0.0.1-SNAPSHOT.jar"
                }
            }
        }
    }
}
