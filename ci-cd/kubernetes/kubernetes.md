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

### Terminos
- Infrastructure as Code
    "Infrastructure as Code" es una práctica que consiste en gestionar la infraestructura de TI utilizando código y herramientas de automatización. En lugar de configurar manualmente los servidores y los recursos de red, los administradores de sistemas pueden definir la infraestructura como código y utilizar herramientas de automatización para implementar y gestionar la infraestructura de forma coherente y repetible.
- GitOps
    "GitOps" es una metodología de operaciones de TI que utiliza Git como fuente de verdad para la infraestructura y las aplicaciones. En un entorno de GitOps, los cambios en la infraestructura y las aplicaciones se gestionan a través de solicitudes de extracción (pull requests) en un repositorio de Git, lo que permite a los equipos de operaciones y desarrollo colaborar de forma eficiente y mantener un historial de cambios completo y auditable.


## Primeros pasos

#### Crear un cluster con minikube
``` bash
minikube start
kubectl cluster-info
kubectl get nodes
kubectl get namespaces
kubectl get pods -A
kubectl get services -A
``` 

### Workspaces

Los "workspaces" son espacios de trabajo virtuales que permiten a los usuarios organizar y gestionar sus recursos de forma más eficiente. Cada workspace tiene su propio entorno aislado, lo que facilita la colaboración y la gestión de recursos en entornos compartidos.

``` yaml
---
apiVersion: v1
kind: Namespace
metadata:
  name: development
---
apiVersion: v1
kind: Namespace
metadata:
  name: production 
``` 

``` bash
# correr el archivo
kubectl apply -f namespaces.yaml
# eliminar un namespace
kubectl delete -f namespaces.yaml
kubectl delete namespace development
``` 
### Deployments

Un "deployment" es un controlador de Kubernetes que gestiona la implementación y la escalabilidad de las aplicaciones en el clúster. Los deployments permiten definir el estado deseado de las aplicaciones y garantizar que se mantenga en todo momento.

``` yaml
--- 
apiVersion: apps/v1
kind: Deployment
metadata:
  name: pod-info-deployment
  namespace: development
  labels:
    app: pod-info
spec:
  replicas: 1
  selector:
    matchLabels:
      app: pod-info
  template:
    metadata:
      labels:
        app: pod-info
    spec:
      containers:
      - name: pod-info-container
        image: kimschles/pod-info-app:latest
        ports:
        - containerPort: 3000
        env:
          - name: POD_NAME
            valueFrom:
              fieldRef:
                fieldPath: metadata.name
          - name: POD_NAMESPACE
            valueFrom:
              fieldRef:
                fieldPath: metadata.namespace
          - name: POD_IP
            valueFrom:
              fieldRef:
                fieldPath: status.podIP
```

``` bash
kubectl apply -f deployment.yaml
kubectl get deployments -n development
kubectl get pods -n development
kubectl describe deployment pod-info-deployment -n development
kubectl delete deployment pod-info-deployment -n development
```

### Pods

Un pod es la unidad más pequeña de despliegue en Kubernetes y puede contener uno o más contenedores. Los pods comparten recursos como la red y el almacenamiento, lo que facilita la comunicación entre los contenedores y la gestión de los recursos compartidos.

``` yaml


``` 

``` bash
# delete pod
kubectl delete pod {id] -n development
```
