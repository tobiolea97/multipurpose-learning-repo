# Docker

## ¿Cómo se puede configurar un contenedor Docker para exponer un puerto específico?

Para exponer un puerto específico en un contenedor Docker, se puede usar la opción -p o --publish. Por ejemplo, para exponer el puerto 8080 del contenedor al puerto 80 del host, se puede usar el siguiente comando:

```bash
docker run -p 80:8080 nombre_imagen
```

Otra forma de exponer un puerto es mediante el archivo Dockerfile, utilizando la instrucción EXPOSE. Por ejemplo:

```Dockerfile
EXPOSE 8080
```

## ¿Cuál es la diferencia entre una imagen y un contenedor en Docker?

### Imagen

- Una de Docker es un archivo inmutable (de solo lectura) que incluye todo lo necesario para ejecutar un programa: el código de la aplicación, las dependencias, las herramientas, las bibliotecas y la configuración del entorno. Actúa como una plantilla para crear contenedores.
- Cada imagen está formada por capas.
- Las imágenes son estáticas y no cambian.

### Contenedor

- Un contenedor es una instancia en ejecución de una imagen.
- Los contenedores se crean a partir de imágenes.
- Los contenedores son dinámicos y pueden cambiar durante su ejecución.
- Un contenedor tiene su propio sistema de archivos basado en la imagen subyacente, pero también puede tener su estado, como los datos creados o modificados durante su ejecución.

## ¿Qué es Docker Compose y cuál es su función en el despliegue de aplicaciones?

Docker Compose es una herramienta que permite definir y gestionar entornos de contenedores Docker de manera sencilla y declarativa utilizando un archivo de configuración llamado docker-compose.yml. En lugar de ejecutar contenedores Docker de manera individual con comandos separados, Docker Compose permite orquestar y administrar múltiples contenedores que conforman una aplicación completa con un solo comando.

Docker Compose es especialmente útil para el despliegue de entornos de desarrollo, pruebas o producción que involucren múltiples servicios, como bases de datos, servidores web, colas de mensajes, etc. Todo el entorno se puede desplegar con un solo comando.

Docker Compose facilita la creación de redes personalizadas entre contenedores y la gestión de volúmenes persistentes. Los servicios definidos en un archivo Compose pueden comunicarse entre sí usando nombres de servicio como alias de red, lo que simplifica la configuración de redes.

