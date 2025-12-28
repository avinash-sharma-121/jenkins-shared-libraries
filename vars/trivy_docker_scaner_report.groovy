def call(String IMAGE_Full_name) {

    echo "Scanning image with trivy scanner"
    sh  "trivy --version"
    sh  "trivy image --severity LOW,HIGH,CRITICAL ${IMAGE_Full_name}"
    echo "Trivy scan completed"

}