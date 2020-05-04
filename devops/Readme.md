## Starting docker containers locally

### Build images and start the containers

```
docker-compose up -d --build
```

### Check if all the services are up

```
docker-compose ps
```

## Deployment

### Deploy pods and services
```
kubectl apply -f airavata-mft-services-deployments.yml
```

### Deploy virtual services and destination rules

```
kubectl apply -f airavata-mft-virtual-services.yml
```

### Enable authentication between services

```
kubectl apply -f airavata-mft-authentication-policy.yml
```


