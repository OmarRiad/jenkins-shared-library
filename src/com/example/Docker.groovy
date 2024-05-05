#!/user/bin/env groovy
package com.example

class Docker implements Serializable{
    def script
    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName){
        script.echo "building docker image"
        script.sh "docker build -t $imageName ."

    }

    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: "dockerhub-credentials", passwordVariable: "PASS", usernameVariable:"USER")]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"

        }
    }

    def dockerPush(String imageName){
        script.sh "docker push $imageName"
    }


}