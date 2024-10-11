# Aplicación Web de Gestión con Java Spring Boot, Thymeleaf y MySQL

Este proyecto es una aplicación web interactiva desarrollada con Java Spring Boot, Thymeleaf y MySQL. La aplicación permite la gestión de datos a través de una interfaz de usuario atractiva y responsiva, utilizando HTML, CSS y Bootstrap.

## Objetivo del proyecto

El objetivo de esta aplicación es proporcionar una solución sencilla para gestionar [inserta aquí el propósito específico de la aplicación, como "productos en una tienda", "usuarios en un sistema", etc.]. Los usuarios pueden interactuar con la aplicación para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

## Características principales

- **Interfaz de usuario responsiva**: Utiliza Bootstrap para asegurar que la aplicación sea accesible desde dispositivos móviles y de escritorio.
- **Gestión de datos**: Permite a los usuarios realizar operaciones CRUD en la base de datos MySQL.
- **Autenticación de usuarios**: Implementa un sistema de inicio de sesión para proteger las funcionalidades de la aplicación.
- **Interacción dinámica**: Utiliza Thymeleaf para renderizar las vistas y ofrecer una experiencia de usuario fluida.

## Tecnologías utilizadas

- **Java 11+**
- **Spring Boot**: Marco de trabajo para construir la aplicación de backend.
- **Thymeleaf**: Motor de plantillas para generar las vistas HTML.
- **MySQL**: Base de datos para almacenar los datos de la aplicación.
- **HTML/CSS**: Estructura y estilo de la interfaz de usuario.
- **Bootstrap**: Framework CSS para el diseño responsivo.

## Importaciones necesarias

### Dependencias en `pom.xml` (para Maven)

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
</dependencies>
