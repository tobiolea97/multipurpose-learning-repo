# Kubernetes

Kubernetes es una plataforma de código abierto diseñada para automatizar la implementación, el escalado y las operaciones de aplicaciones en contenedores. Originalmente desarrollado por Google, ahora es mantenido por la Cloud Native Computing Foundation (CNCF).

### ¿Para qué sirve Kubernetes?
Kubernetes se utiliza principalmente para gestionar contenedores en un entorno distribuido. Los contenedores permiten empaquetar aplicaciones con todas sus dependencias, lo que facilita su implementación en diferentes entornos.

- Escalabilidad: Permite escalar aplicaciones fácilmente. Puede añadir o quitar contenedores automáticamente en función de la carga de trabajo.

-  Automatización del Despliegue: Kubernetes puede gestionar automáticamente el despliegue y la supervisión de las aplicaciones, lo que facilita las actualizaciones continuas y reduce el tiempo de inactividad.

- Gestión de Recursos: Administra el uso de recursos del sistema, como CPU y memoria, para garantizar que las aplicaciones reciban los recursos necesarios sin exceder la capacidad del sistema.

- Alta Disponibilidad: Proporciona mecanismos para la recuperación automática en caso de fallos, asegurando que las aplicaciones permanezcan disponibles y operativas.

- Facilidad de Desarrollo y Operaciones: Facilita la colaboración entre equipos de desarrollo y operaciones (DevOps) al proporcionar una infraestructura común y unificada para el desarrollo, prueba y despliegue de aplicaciones.

- Portabilidad: Las aplicaciones gestionadas por Kubernetes pueden ejecutarse en cualquier entorno compatible, desde el local hasta nubes públicas o privadas.

### Componentes Clave de Kubernetes
- Nodo Maestro: Coordina el clúster y gestiona la planificación, el mantenimiento de los estados deseados y la configuración del clúster.
- Nodos de Trabajo: Ejecutan las aplicaciones y las cargas de trabajo en contenedores.
- Pods: La unidad más pequeña de despliegue que puede crear y gestionar Kubernetes. Un pod puede contener uno o más contenedores.
- Servicios: Abstracciones que definen un conjunto lógico de pods y una política para acceder a ellos.
- Controladores: Gestionan el estado de las aplicaciones y garantizan que el número deseado de pods se esté ejecutando en el clúster.


### Primeros pasos

1. Crear un cluster con minikube
``` bash
minikube start
kubectl cluster-info
kubectl get nodes
kubectl get namespaces
kubectl get pods -A
kubectl get services -A
``` 

