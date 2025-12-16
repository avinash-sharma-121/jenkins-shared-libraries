def call(image_name) {
    echo "code build with docker"
    sh '''
        whoami
        which docker
        docker --version
        docker ps
        pwd
        ls -l
    '''
    sh 'docker build -t ${imageName} .'
}
