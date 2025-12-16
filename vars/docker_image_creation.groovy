def call(image_name) {
    echo "code build with docker"
    sh '''
        whoami
        pwd
        ls -l
        docker build -t ${imageName} .
    '''
}
