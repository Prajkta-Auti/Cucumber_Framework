pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Hello World'
            }
        }   
        stage('Test') {
            steps {
                echo 'Test application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy application'
            }
        }
    }
	post{
	always{
	emailext body: '', subject: 'pipelne status', to: 'prajkta.auti11@gmail.com'
	}
	}
}
