# Docker

## Glosario
- **Docker** - Plataforma de software que permite a los desarrolladores construir, probar y desplegar aplicaciones en contenedores.
- **Image** - Un archivo que contiene un sistema de archivos pre comprimido y empaquetado que contiene todo lo necesario para ejecutar una aplicacion.
- **Container** - Un contenedor es una unidad estandar de software que empaqueta el codigo y todas sus dependencias para que la aplicacion corra de manera eficiente y confiable en cualquier entorno.
- **Dockerfile** - Un archivo que contiene instrucciones para construir una imagen.
- **Volume** - Un directorio en el host que se monta en un container.
- **Port Binding** - Exponer un puerto de un container al host.



## Comandos

- `docker --help` - Lista todos los comandos de Docker
- `docker <some_command> --help` - Lista los flags de un comando
- `docker system prune` - Elimina todos los containers, imagenes, y volumenes que no estan en uso
- `docker system prune -a` - Elimina todos los containers, imagenes, y volumenes
- `docker system df` - Muestra el uso de disco de Docker
- `docker inspect <container_id>` - Muestra informacion detallada de un objeto de Docker

## Containers
Los containers se crean desde una imagen, y se pueden crear multiples containers de una misma imagen. Las imagenes son sistemas de archivos pre comprimidos y empaquetados que contienen todo lo necesario para ejecutar una aplicacion. Contiene tambien una instrucción sobre como correr la aplicación, llamada `entrypoint`.

- `docker ps` - List all running containers
- `docker ps -a` - List all containers
- `docker container create <image>` - Create a container from an image, pero no lo corre

Cada container tiene su propio id, y se pueden listar con `docker ps -a`. Los containers se pueden detener, pausar, reiniciar, y eliminar.

- `docker container start <container_id>` - Inicia un container
- `docker container start <container_id> --attach` - Inicia un container y se conecta a el
- `docker container stop <container_id>` - Detiene un container
- `docker container stop -t 0 <container_id>` - Detiene un container inmediatamente
- `docker container restart <container_id>` - Reinicia un container
- `docker container rm <container_id>` - Elimina un container
- `docker container prune` - Elimina todos los containers que no estan corriendo
- `docker container prune -f` - Elimina todos los containers que no estan corriendo sin preguntar
- `docker logs <container_id>` - Muestra los logs de un container

## Docker run

- `docker run <image>` - Crea un container y lo corre
- `docker run -d <image>` - Crea un container y lo corre en background
- `docker run -it <image>` - Crea un container y lo corre en modo interactivo
- `docker run -it <image> <command>` - Crea un container y corre un comando en el
- `docker run -it --entrypoint /bin/bash <image>` - Crea un container y corre un shell en el
- `docker run --rm <image>` - Crea un container y lo corre, y lo elimina cuando termina
- `docker run --entry-point <command>` - Cambia el entrypoint de un container

Una vez que el container está corriendo:
- `docker exec -it <container_id> <command>` - Ejecuta un comando en un container corriendo
- `docker exec -it --tty <container_id> bash` - Conecta a un container corriendo




## Dockerfiles

Los Dockerfiles son archivos que contienen instrucciones para construir una imagen. Se pueden construir imagenes a partir de un Dockerfile con el comando `docker build`.

```dockerfile
# Dockerfile
FROM ubuntu 

# Metadata
LABEL maintainer="Carlos Nunez <dev@carlosnunez.me>" // Metadata

# Usuario con el que se corre el container
USER root 

# Copia archivos al container
COPY ./entrypoint.bash /

# Ejecuta comandos en el container. Aqui se debe instalar software y configurar el container
RUN apt -y update
RUN apt -y install curl bash
RUN chmod 755 /entrypoint.bash

USER nobody

# Que comando se corre al iniciar el container
ENTRYPOINT [ "/entrypoint.bash" ]
```

Una vez que tenemos nuestro Dockerfile, podemos construir una imagen con el comando `docker build`.

- `docker build -t <image_name> .` - Construye una imagen a partir de un Dockerfile en el directorio actual
- `docker build -t <image_name> -f <path_to_dockerfile>` - Construye una imagen a partir de un Dockerfile en una ubicacion especifica
- `docker images` - Lista todas las imagenes
- `docker tag <image_id> <image_name>:<version>` - Cambia el tag de una imagen
- `docker rmi <image_id>` - Elimina una imagen



## Binding ports

Para exponer un puerto de un container al host, se usa el flag `-p` en el comando `docker run`.

- `docker run -p <host_port>:<container_port> <image>` - Expone un puerto del container al host

## Volumes

Los volumenes son directorios en el host que se montan en un container. Se pueden montar volumenes con el flag `-v` en el comando `docker run`.

- `docker run -v <host_dir>:<container_dir> <image>` - Monta un volumen en un container

## Docker Hub

Docker Hub es un servicio de registro de imagenes de Docker. Se pueden subir imagenes a Docker Hub con el comando `docker push`.

- `docker login` - Loguea en Docker Hub
- `docker push <image>` - Sube una imagen a Docker Hub
- `docker pull <image>` - Descarga una imagen de Docker Hub

