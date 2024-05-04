#!/user/bin/env groovy
def call(){
    echo "building docker image"
    withCredentials([usernamePassword(credentialsId: "dockerhub-credentials", passwordVariable: "PASS", usernameVariable:"USER")]) {
        sh 'docker build -t omarriad07/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push omarriad07/demo-app:jma-2.0'
    }
}