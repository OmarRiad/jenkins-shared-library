#!/user/bin/env groovy
def call(){
    echo "building app"
    sh "mvn package"
}