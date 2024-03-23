pipeline {
    agent any
    tools {
        jdk "java"
        gradle "gradle"
    }
    environment {
        cloud.aws.s3.bucket = "${env.cloud.aws.s3.bucket}"
        cloud.aws.stack.auto = "${env.cloud.aws.stack.auto}"
        cloud.aws.region = "${env.cloud.aws.region}"
        cloud.aws.credentials.accessKey = "${env.cloud.aws.credentials.accessKey}"
        cloud.aws.credentials.secretKey = "${env.cloud.aws.credentials.secretKey}"
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
                    sh "java -Daws.accessKeyId=${cloud.aws.credentials.accessKey} -Daws.secretKey=${cloud.aws.credentials.secretKey} -jar ./build/libs/muckkitlist_spring-0.0.1-SNAPSHOT.jar"
                }
            }
        }
    }
}
