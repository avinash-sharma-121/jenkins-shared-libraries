def call(String docker_username,String image_name, String tags) {
    echo "code build with docker"
    sh '''
        whoami
        docker --version
        pwd
        ls -l
    '''
    sh "docker build -t ${docker_username}/${image_name}:${tags} ."
}
