#!/user/bin/env groovy
def call(){
    echo "building app for branch $BRANCH_NAME"
    sh "mvn package"
}