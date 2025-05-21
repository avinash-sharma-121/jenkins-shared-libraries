def call(url,branch){
      echo "code pulling"
      git url: "${url}", branch: "${branch}"
      echo "code pull successfull"
}
