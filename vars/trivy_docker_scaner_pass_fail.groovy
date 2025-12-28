def call(String IMAGE_Full_name) {
    echo "Scanning image with trivy scanner"
    echo "Image to scan: ${IMAGE_Full_name}"
    try{
    sh  "trivy --version"
    sh  "trivy image --exit-code 1 --severity CRITICAL ${IMAGE_Full_name}"
    echo "Trivy scan pass all vulnerabilities"
    }
    catch (err){
        echo "Trivy scan failed due to CRITICAL vulnerabilities"
        error("Security gate failed due to Trivy scan")
    }
}