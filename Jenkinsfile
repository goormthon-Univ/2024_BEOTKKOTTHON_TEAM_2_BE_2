pipeline {
    agent any
    tools {
        jdk "java"
        gradle "gradle"
    }
    environment {
        AWS_S3_BUCKET = credentials('env.cloud.aws.s3.bucket')
        AWS_STACK_AUTO = credentials('env.cloud.aws.stack.auto')
        AWS_REGION = credentials('env.cloud.aws.region')
        AWS_ACCESS_KEY = credentials('env.cloud.aws.credentials.accessKey')
        AWS_SECRET_KEY = credentials('env.cloud.aws.credentials.secretKey')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        // 자바 스프링 관련 단계 추가
        // 윈도우에서는 'sh'를 'bat'으로 변경
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
                    sh "java -Daws.accessKeyId=${AWS_ACCESS_KEY} -Daws.secretKey=${AWS_SECRET_KEY} -jar ./build/libs/muckkitlist_spring-0.0.1-SNAPSHOT.jar"
                }
            }
        }
    }
}
