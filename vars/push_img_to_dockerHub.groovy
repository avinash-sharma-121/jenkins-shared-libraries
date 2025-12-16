def call(String docker_username,String image_name, String tags){
      echo "code push to the dockerHUb"
    /*  withCredentials([usernamePassword(
      'credentialsId':'dockerHubID',
      passwordVariable:'dockerHubPass',
      usernameVariable:'dockerHubUser')]){
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}" 
        sh "docker image tag ${image_name} ${env.dockerHubUser}/${image_name}:${image_version}"
        sh "docker push ${env.dockerHubUser}/${image_name}:${image_version}"
     }
     */
     sh "docker push ${docker_username}/${image_name}:${tags}"
}
