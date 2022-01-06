# SCAFFOLD LAMBDA APPLICATION USING SPRING NATIVE, AWS-SERVERLESS-JAVA-CONTAINER AND GRAALVM JAVA 11.

## If building on Docker
### Building the GRAAL VM builder image.
This image would be used to build the native image. Setting up Graal native compiler.
`
docker -v build --tag rhel8-openjdk11-graal-native-base -f docker/Dockerfile-rhel8-openjdk11-graal-base . --progress=plain
`

### Building the runtime native application Image from a docker container.
`
docker -v build  --tag mutistage-serverless -f Dockerfile-multistage .  --progress=plain
`
### Downloading the AWS Deployable from Docker File. 
1. Run your docker container.
2. Remote copy your assembly file from runningDocker container. We will use this zip file to upload to AWS in our serverless template.

`
docker cp "CONTAINERID":/var/app/NAME-ZIP-FILE target/Archive.zip  
`

### Deploying locally and testing.   
`
sam local start-api --debug
`
   
### Deployment to AWS
Run the below command from the root folder to deploy to AWS. 

`
sam deploy --debug  -t template.yml --stack-name graaldemo --resolve-s3 --capabilities CAPABILITY_IAM
`

## If running on local Machine, 
### On Macbbook, Setup GRAALVM_HOME Once
`
export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.3.0/Contents/Home/
`

#### Building the native Image.
`
./mvnw -ntp clean package -DskipTests -Pnative
`
