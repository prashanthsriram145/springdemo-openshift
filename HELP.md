## Command to build docker image
docker build -t springdemo .

## Command to login to quay.io registry
docker login quay.io

We need enter username, password to login to quay.io.

## Command to tag springdemo image to quay.io repository

docker tag springdemo quay.io/prashanthsriram/springdemo:latest

## Command to push image to registry quay.io

docker push quay.io/prashanthsriram/springdemo:latest

Once the image is pushed to repository, we need to make the repository public so that we can install image in Openshift

## Command to create a new application in openshift cluster using image from quay.io

oc new-app --image=quay.io/prashanthsriram/springdemo

## Command to expose Openshift service object and create a route object

oc expose service/springdemo

## Command to check the status of Openshift cluster and capture the route URL

oc status

We can use the route URL from oc status output and use curl or browser to hit the REST API

Ex: curl http://springdemo-prashanthsriram-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/welcome



## Way to deploy application using template files of deployment, service and configmap

oc create -f templates/configmap.yaml
oc create -f templates/deployment.yaml
oc create -f templates/service.yaml
