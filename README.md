# DAM - Proyecto final DI y AD
El siguiente repositorio contiene en una versión demo del proyecto final para el alumnado de DAM que tendrán que crear una interfaz de usuario con la tecnología Flutter/Dart que conecta al backend con lenguaje Java y Springboot.


# Requisitos previos FE(Frontend)
* Flutter: Instalación SDK Flutter y configuración del path en las variables de entorno

# Requisitos previos BE_API (Backend)
* Java:  Instalación JDK compatible con la solución (min JDK 17)
* MySQL: Instalación MySQL Server y Workbench (IMPORTANTE: Hay que crear el esquema 'sga')
  
# Configuración IDE VSCode
Es muy recomendable agregar los siguientes plugins en VSCode para trabajar en ambos proyectos:
* C/C++ Extension Pack
* Extension Pack for Java
* Flutter

A continuación, se dispone de un ejemplo de configuración para poder realizar debug en el equipo local:
   ```settings.json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Launch Current File",
            "request": "launch",
            "mainClass": "${file}"
        },
        {
            "name": "FE (Flutter Chrome)",
            "program": "lib/main.dart",
            "cwd": "FE",
            "deviceId": "chrome",
            "request": "launch",
            "type": "dart"
        }
    ]
}
   ```

# Arquitectura de la solución 

## Frontend
Pendiente de implementar (representación Flutter/Dart)

## Backend
En el caso del backend, la arquitectura de esta solución sigue un modelo clean architectura estructurado por capas

![](doc/images/clean-architecture.png)

#### API Spring Web + JPA/ORM Hibernate +  MySQL
```mermaid
flowchart TB

    %% Presentation Layer
    subgraph Presentation["Presentation Layer"]
        C[Controllers<br/>EntityController]
        D[DTOs<br/>Request / Response]
        E[GlobalExceptionHandler]
    end

    %% Application Layer
    subgraph Application["Application Layer"]
        S[Services<br/>EntityService]
    end

    %% Domain Layer
    subgraph Domain["Domain Layer"]
        M[Entities<br/>User / Product / Order]
        R[Repositories<br/>Interfaces]
        X[Domain Exceptions]
    end

    %% Infrastructure Layer
    subgraph Infrastructure["Infrastructure Layer"]
        P[Persistence]
        J[Entities JPA]
        JR[JpaRepository]
        A[Repository Adapters]
        DB[(Database)]
    end

    %% Relationships
    C --> S
    D --> C
    E --> C

    S --> M
    S --> R
    S --> X

    A --> R
    A --> J
    A --> JR

    JR --> DB

    %% Grouping
    P --- J
    P --- JR
    P --- A
```

# Estructura de carpetas

## Flutter
Para manejar múltiples controladores con distintos tipos de peticiones, se va a utilizar usar Dio + Repository Pattern + Provider

![](doc/images/DioReposProvider.png)

De esta manera va a ser más eficiente la gestión del flujo REST y, una vez comprendida la estructura, simplificará la implementación de nuevos elementos.


# Despliegue contenedores (Docker)
Pendiente de implementar
