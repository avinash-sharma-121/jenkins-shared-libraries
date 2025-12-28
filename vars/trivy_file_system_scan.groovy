def call(){
        echo "Scanning code with trivy scanner"
        sh "ls -ltr"
        sh  "trivy fs --severity LOW,HIGH,CRITICAL ."
        echo "Trivy scan completed"
}