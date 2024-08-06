pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/RamkrushnaGosavi/cardManagement'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        }
    }
}
