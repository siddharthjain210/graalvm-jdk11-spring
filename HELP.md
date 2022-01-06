# Getting Started

### Reference Documentation

1. docker -v build --tag rhel8-openjdk11 .


# Building the GRAAL VM builder image. 
2. docker -v build --tag rhel8-openjdk11-graal-native-base -f Dockerfile-rhel8-openjdk11-graal-base . --progress=plain

# Building the runtime docker Image. 
docker -v build  --tag mutistage -f Dockerfile-multistage .  --progress=plain

3. Deployment to AWS
sam deploy --debug  -t template.yml --stack-name graaldemo --resolve-s3 --capabilities CAPABILITY_IAM


# Building the runtime docker Image with aws serverless container. 
docker -v build  --tag mutistage-serverless -f Dockerfile-multistage .  --progress=plain

export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.3.0/Contents/Home/
