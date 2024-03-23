pipeline {
    agent any
    tools {
        jdk "java"
        gradle "gradle"
    }
    environment {
        cloud.aws.s3.bucket= ${env.cloud.aws.s3.bucket}
        cloud.aws.stack.auto= ${env.cloud.aws.stack.auto}
        cloud.aws.region.static= ${env.cloud.aws.region.static}
        cloud.aws.credentials.access-key= ${env.cloud.aws.credentials.access-key}
        cloud.aws.credentials.secret-key= ${env.cloud.aws.credentials.secret-key}
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
                        sh 'java -Daws.accessKeyId=${AWS_ACCESS_KEY_ID} -Daws.secretKey=${AWS_SECRET_ACCESS_KEY} -jar ./build/libs/muckkitlist_spring-0.0.1-SNAPSHOT.jar

                    }
            }
        }
    }
}