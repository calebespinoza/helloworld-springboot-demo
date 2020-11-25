# Deploy a Springboot environment in a K8s cluster

### Build Docker image
The *bootBuildImage* task builds and OCI image of the application using the output of the bootJar task.
```
$ gradle bootBuildImage --imageName=<docker-repo>/helloworld-springboot-demo
```

### Run the container
Start the container locally base on the image created.
```
$ docker run -d -p 8787:8787 --name demo-springboot <docker-repo>/helloworld-springboot-demo:latest
```
Test your endpoint locally.
```
$ curl http://localhost:8787/hello/<firstname>/<lastname>
```

### Upload image
Upload the image to your Docker Hub o Private Registry.
```
$ docker push <docker-repo>/helloworld-springboot-demo:latest
```

### Create k8s Deployment & Service
Expose the endpoint.
```
$ kubectl create -f demo-springboot-definition.yaml
```
Get the External IP from Service
```
$ kubectl get svc
```

### Access to the endpoint
```
$ curl http://<ip-address>:3005/hello/<firstname>/<lastname>
```
