def call(image_name) {
    echo "code build with docker"
    pwd
    ls
    sh "docker build -t ${image_name} ."
}
