#!/user/bin/env groovy
import com.example.Docker

def call(String imageName){
    return new Docker(this).buildDockerImage(imageName)
}