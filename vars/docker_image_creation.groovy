def call(String image_name, String tags, String docekr_username) {
    echo "code build with docker"
    sh '''
        whoami
        docker --version
        pwd
        ls -l
    '''
    sh 'docker build -t ' ${docekr_username}/${image_name}:${tags} .'
}
