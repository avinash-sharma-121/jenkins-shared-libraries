def call(image_name) {
    echo "code build with docker"
    sh "docker build -t ${image_name} ."
}
