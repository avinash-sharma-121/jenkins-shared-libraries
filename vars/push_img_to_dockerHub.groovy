def call(image_name,credential_id,image_version){
      echo "code push to the dockerHUb"
      withCredentials([usernamePassword(
      'credentialsId':'dockerHubID',
      passwordVariable:'dockerHubPass',
      usernameVariable:'dockerHubUser')]){
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}" 
        sh "docker image tag ${image_name} ${env.dockerHubUser}/${image_name}:${image_version}"
        sh "docker push ${env.dockerHubUser}/${image_name}:${image_version}"
     }
}
