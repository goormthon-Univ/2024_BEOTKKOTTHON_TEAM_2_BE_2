pipeline {
    agent any
    tools {
        jdk "java"
        gradle "gradle"
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
                        sh 'java -Daws.accessKeyId=${env.AWS_ACCESS_KEY_ID} -Daws.secretKey=${env.AWS_SECRET_ACCESS_KEY} -jar ./build/libs/muckkitlist_spring-0.0.1-SNAPSHOT.jar'
                    }
            }
        }
    }
}
