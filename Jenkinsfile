pipeline {
agent any

stages {
    stage('Checkout') {
        steps {
            // Checkout the code repository
            checkout scm
        }
    }

    stage('Build') {
        steps {
            // Build the war file
             sh 'mvn clean package'
        }
    }

    stage('Deploy') {
        environment {
            TOMCAT_HOME = 'http://31.128.40.167:8085/opt/tomcat'
            WAR_FILE = 'target/aston-1.0-SNAPSHOT.war'
        }

        steps {
            // Stop Tomcat
            sh "${TOMCAT_HOME}/bin/shutdown.sh"

            // Remove existing war file and deployed application
            sh "rm -rf ${TOMCAT_HOME}/webapps/aston-1.0-SNAPSHOT*"

            // Copy the new war file to Tomcat webapps directory
            sh "cp ${WAR_FILE} ${TOMCAT_HOME}/webapps/myapp.war"

            // Start Tomcat
            sh "${TOMCAT_HOME}/bin/startup.sh"
        }
    }

    stage('Verify') {
        steps {
            // Wait for Tomcat to start
            sh "sleep 30"

            // Verify if the application is deployed successfully
            sh "curl -s http://31.128.40.167:8085/aston-1.0-SNAPSHOT/"
        }
    }
}

post {
    always {
        // Cleanup any leftover files after deployment
        sh "rm -rf *.war"
    }
}
}