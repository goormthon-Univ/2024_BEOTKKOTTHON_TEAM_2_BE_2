pipeline {
    agent any
    tools {
        jdk "java"
        gradle "gradle"
    }
    environment {
        AWS_S3_BUCKET = "${env.CLOUD_AWS_S3_BUCKET}"
        AWS_STACK_AUTO = "${env.AWS_STACK_AUTO}"
        AWS_REGION = "${env.AWS_REGION}"
        AWS_ACCESS_KEY = "${env.CLOUD_AWS_CREDENTIALS_ACCESSKEY}"
        AWS_SECRET_KEY = "${env.CLOUD_AWS_CREDENTIALS_SECRETKEY}"
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
