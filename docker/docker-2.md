# Docker: Deep Dive

### Main files and directories

- `/var/lib/docker` - Docker's data directory
- `/var/run/docker.sock` - Docker's socket file
- `/etc/docker/daemon.json` - Docker's configuration file

### Installing docker on Ubuntu

```bash
curl -L https://get.docker.io | bash
```

### Portainer

Portainer is a web-based management UI for Docker. It allows you to manage containers, images, networks, and volumes.

```bash
docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:latest
```

### Course excericses

```bash
docker pull ngix:latest

```

### Dockerfile in depth
- Base image
```Dockerfile
    # FROM
    # Command that describes the base image that this Dockerfile's image will be created from
    # it must be the first command in the Dockerfile
    FROM ubuntu:latest
```

- Copy files
```Dockerfile
    # 1) Copy a file from the host to the container
    # COPY $source-file $destination-file
    COPY index.html /var/www/html/index.html
    # 2) Copy a file into a directory
    # COPY $source-file $destination-directory
    COPY index.html /var/www/html/
    # 3) Copy a directory into a directory
    # COPY $source-directory $destination-directory
    COPY src/ /var/www/html/
```

- Copy Wildcards
![wildcards](images/copy-wildcards.png)


- Run command
```Dockerfile
    # RUN
    # Command that will be executed when the image is built
    # RUN $command
    RUN apt-get update
    RUN apt-get install -y nginx
    
    # alternative syntax
    RUN["apt-get", "update"]
    RUN["apt-get", "install", "-y", "nginx"]
```

- Entrypoint
```Dockerfile
    # ENTRYPOINT
    # Command that will be executed when the container is started
    # ENTRYPOINT $command
    ENTRYPOINT ["nginx", "-g", "daemon off;"]
```

- CMD
```Dockerfile
    # CMD
    # Command that will be executed when the container is started
    # CMD $command
    CMD ["nginx", "-g", "daemon off;"]
```

### Combining CMD and Entrypoint

![CMD and Entrypoing](images/entry-point-and-cmd-combinations.png)

### When to use an entrypoint and when to use a CMD?

- Use an entrypoint when you want to provide a command that will always be executed when the container is started
- Use a CMD when you want to provide a default command that can be overwritten by the user on the run command
- CMD is best suited for providing command-line arguments to the entrypoint

### Using ENV and ARG

- ARG
```Dockerfile
    # ARG
    # Command that sets an argument at build time
    # ARG $variable-name=$variable-value
    ARG MY_ARG=my-value
```

- ENV
```Dockerfile
    # ENV
    # Command that sets an environment variable at run time
    # ENV $variable-name $variable-value
    ENV MY_ENV_VAR my-value
```

### Useful commands

- LABEL
```Dockerfile
    # LABEL
    # Command that sets metadata for the image
    # LABEL $key=$value
    LABEL version="1.0"
    LABEL maintainer="tobiolea97@gmail.com"
```

- WORKDIR
```Dockerfile
    # WORKDIR
    # Command that sets the working directory for the container
    # WORKDIR $directory
    WORKDIR /var/www/html
```

- USER
```Dockerfile
    # USER
    # Command that sets the user that will run the container
    # USER $user
    USER www-data
```

- EXPOSE
```Dockerfile
    # EXPOSE
    # Command that exposes a port to the host
    # EXPOSE $port
    EXPOSE 80
```


### Other features

- Multi stage builds
```Dockerfile
    # Multi stage builds
    # Use multiple FROM statements in a single Dockerfile
    # to create multiple images
    FROM node:latest as build
    WORKDIR /app
    COPY package.json .
    RUN npm install
    COPY . .
    RUN npm run build

    FROM nginx:latest
    COPY --from=build /app/build /usr/share/nginx/html
```

- Multi app images

There are some scenarios where you may want to run multiple applications in a single container. This is not recommended as it goes against the best practices of Docker. However, if you need to do this, you can create a single image that runs multiple applications.


- Container privileges and capabilities

Docker containers run with a default set of capabilities that are inherited from the host. You can add or remove capabilities from a container using the --cap-add and --cap-drop flags.

- Container limits

You can set resource limits on a container using the --memory and --cpus flags. This allows you to control the amount of memory and CPU that a container can use.

```bash
docker run --memory 512m --cpus 0.5 my-image
```


- Log driver and log options

You can configure the logging driver for a container using the --log-driver flag. You can also set log options using the --log-opt flag.

```bash
docker run --log-driver syslog --log-opt tag=my-container my-image
```

- Docker in Docker

You can run Docker inside a Docker container by mounting the Docker socket file from the host into the container.

```bash
docker run -v /var/run/docker.sock:/var/run/docker.sock my-image
```

## Volumes

- Volumes are used to persist data between containers
- Volumes are stored outside of the container's filesystem
- Volumes can be shared between containers
- Volumes can be managed using the docker volume command

### Creating a volume

```bash
docker volume create my-volume
```

### Inspecting a volume

```bash
docker volume inspect my-volume
```

### Removing a volume

```bash
docker volume rm my-volume
```

### Mounting a volume

```bash
docker run -v my-volume:/data my-image
```

### Bind mounts

- Bind mounts are used to mount a host directory into a container
- Bind mounts are stored on the host filesystem
- Bind mounts can be used to share files between the host and the container

### Mounting a bind mount

```bash
docker run -v /host-directory:/container-directory my-image
```

### DD
Used for writing and reading raw data from block devices


## Networking

- Docker provides a default bridge network that containers can use to communicate with each other
- You can create custom networks to isolate containers
- You can connect containers to multiple networks
- You can use the --link flag to connect containers

### Creating a network

```bash
docker network create my-network
```

#### Course example
    
```bash
# terminal 1
docker container create -it --name container-a --entrypoint sh curlimages/curl
docker container start container-a
docker container attach container-a
ifconfig # get the ip address
ping <ip-address-of-container-b>
docker network create network-a
docker container create -it --name container-c --entrypoint sh --net network-a curlimages/curl

# terminal 2
docker container create -it --name container-b --entrypoint sh curlimages/curl
docker container start container-b
docker container attach container-b
ifconfig # get the ip address 
ping <ip-address-of-container-a>
docker network create network-b
docker container create -it --name container-d --entrypoint sh --net network-b curlimages/curl
```

#### Connecting a container to a network

```bash
docker network connect my-network my-container
```

#### Exposing a port

```bash
docker run -p 8080:80 my-image
```