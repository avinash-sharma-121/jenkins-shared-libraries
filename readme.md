# Jenkins Shared Library – Docker & Trivy CI/CD Utilities

This repository contains reusable **Jenkins Shared Library Groovy scripts** designed to standardize and simplify CI/CD pipelines.  
It provides common pipeline steps for **Git checkout, Docker image build & push, and security scanning using Trivy**.

---

## 🚀 Why Use This Shared Library?

- Avoid duplicate Jenkinsfile code
- Maintain consistent CI/CD standards
- Enforce container security with Trivy
- Easy to reuse across multiple projects

---

## 📦 Features

- ✅ Git source code checkout
- 🐳 Docker image build
- 📤 Push Docker images to Docker Hub
- 🔐 Trivy security scanning
  - Docker image scan with pass/fail (security gate)
  - Docker image scan for reporting
  - File system scan

---

## 📂 Repository Structure

```text
.
├── docker_image_creation.groovy
├── git_checkout.groovy
├── push_img_to_dockerHub.groovy
├── trivy_docker_scaner_pass_fail.groovy
├── trivy_docker_scaner_report.groovy
└── trivy_file_system_scan.groovy

Each Groovy file represents a **custom Jenkins pipeline step**.
```
---

## 🔧 Prerequisites

Ensure the Jenkins agent has:

- Jenkins configured with Shared Libraries
- Docker
- Trivy
- Git
- Docker Hub account (for pushing images)

---

## 📘 Shared Library Functions

---

```
1️⃣ Git Checkout

File: git_checkout.groovy

git_checkout('https://github.com/org/repo.git', 'main')


Purpose:
Clones the given Git repository and branch into the Jenkins workspace.

2️⃣ Docker Image Creation

File: docker_image_creation.groovy

docker_image_creation('docker_username', 'my-app', 'v1.0')


Purpose:
Builds a Docker image using the Dockerfile available in the workspace.

Resulting Image:

docker_username/my-app:v1.0

3️⃣ Push Docker Image to Docker Hub

File: push_img_to_dockerHub.groovy

push_img_to_dockerHub('docker_username', 'my-app', 'v1.0')


Purpose:
Pushes the Docker image to Docker Hub.

⚠️ Note:
Docker authentication should be handled using Jenkins credentials.
Credential-based login code is already included as comments in the script.

4️⃣ Trivy Docker Image Scan (Pass / Fail)

File: trivy_docker_scaner_pass_fail.groovy

trivy_docker_scaner_pass_fail('docker_username/my-app:v1.0')


Purpose:

Scans the Docker image for CRITICAL vulnerabilities

Fails the pipeline if any CRITICAL issues are detected

Acts as a security gate in the CI/CD pipeline

5️⃣ Trivy Docker Image Scan (Report Only)

File: trivy_docker_scaner_report.groovy

trivy_docker_scaner_report('docker_username/my-app:v1.0')


Purpose:

Scans the Docker image for LOW, HIGH, and CRITICAL vulnerabilities

Displays results in the console

Does not fail the pipeline

6️⃣ Trivy File System Scan

File: trivy_file_system_scan.groovy

trivy_file_system_scan()
```


Purpose:
Scans the application source code and dependencies for vulnerabilities.

🧩 Complete Jenkinsfile Example

```
@Library('jenkins-shared-lib') _

pipeline {
    agent any

    stages {

        stage('Checkout Source Code') {
            steps {
                git_checkout(
                    'https://github.com/org/repo.git',
                    'main'
                )
            }
        }

        stage('Build Docker Image') {
            steps {
                docker_image_creation(
                    'docker_username',
                    'sample-app',
                    'v1.0'
                )
            }
        }

        stage('Trivy File System Scan') {
            steps {
                trivy_file_system_scan()
            }
        }

        stage('Trivy Image Scan (Security Gate)') {
            steps {
                trivy_docker_scaner_pass_fail(
                    'docker_username/sample-app:v1.0'
                )
            }
        }

        stage('Push Image to Docker Hub') {
            steps {
                push_img_to_dockerHub(
                    'docker_username',
                    'sample-app',
                    'v1.0'
                )
            }
        }
    }
}
```
---

## 🔐 Security Best Practices

- Use Jenkins Credentials for Docker Hub authentication

- Enforce Trivy pass/fail scans in production pipelines

- Scan both file systems and container images

- Block deployments on CRITICAL vulnerabilities

---

## 📌 Future Enhancements

- Fully integrate Docker login with Jenkins credentials

- Generate Trivy HTML / JSON vulnerability reports

- Support AWS ECR, Azure ACR, and GCP GCR

- Add SBOM generation and image signing

---

## 🏁 Summary

This Jenkins Shared Library provides a clean, secure, and reusable CI/CD foundation for Docker-based projects, with built-in vulnerability scanning using Trivy.