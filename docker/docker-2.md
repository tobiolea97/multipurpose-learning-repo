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


