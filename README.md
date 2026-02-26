#  Proyecto Microservicios: Productos y Descuentos

Este proyecto contiene **dos microservicios** que se comunican entre sí:

1. **msc_products (8081)** – Gestión de productos  
2. **mcs_discount (8082)** – Cálculo de descuentos usando datos del micro de productos  

Ambos están desarrollados en **Spring Boot WebFlux** con **Reactor**, **DTOs**, **Swagger/OpenAPI**, y pruebas unitarias con **JUnit + Mockito + StepVerifier**.

---

##  Tecnologías aplicadas

- Java 17+
- Spring Boot 3.x (WebFlux, Validation)
- Spring Data JPA + H2 / MySQL (opcional)
- WebClient (comunicación micro → micro)
- Lombok ()
- Swagger/OpenAPI 3
- Reactor (Mono/Flux)
- JUnit 5 + Mockito
- Maven

---


###  msc_products (Puerto 8081)

##  Estructura del Proyecto msc_products
```
msc_products/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/msc_products/
│   │           ├── controladores/
│   │           │   └── ProductoControlador.java
│   │           ├── dominio/
│   │           │   └── modelo/
│   │           │       ├── Producto.java
│   │           │       └── dto/
│   │           │           ├── ProductoPeticion.java
│   │           │           └── ProductoRespuesta.java
│   │           ├── servicios/
│   │           │   └── ProductoServicio.java
│   │           └── repositorio/
│   │               └── ProductoRepository.java
│   └── test/
│       └── java/
│           └── com/msc_products/
│               └── ProductoServicioTest.java
└── pom.xml
```

###  swagger y la base del api de micro-productos
```
Swagger: http://localhost:8081/swagger-ui.html
Base URL API: http://localhost:8081/api/productos
```

## prueba de los endpoints
```
MicroServicio de Productos

POST /api/productos   - 	ProductoPeticion	ProductoRespuesta	Crea un producto
GET	 /api/productos/{id}	-	ProductoRespuesta	Obtiene un producto por ID
```

###  mcs_discount (Puerto 8082)
##  Estructura del Proyecto
```
mcs_discount/
│
├─ src/main/java/com/mcs_discount
│ ├─ controlador/DescuentoControlador.java
│ ├─ dominio/modelo/Descuento.java
│ ├─ dominio/dto/DescuentoRespuesta.java
│ ├─ clientes/ProductoCliente.java
│ ├─ infraestructura/entidad/DescuentoEntity.java
│ ├─ repositorio/DescuentoRepositorio.java
│ └─ servicio/DescuentoServicio.java
│
├─ src/test/java/com/mcs_discount
│ └─ DescuentoServicioTest.java
│
└─ pom.xml
```
### swagger y la base del api de micro-descuentos
```
Swagger: http://localhost:8082/swagger-ui.html
Base URL API: http://localhost:8082/api/descuentos
```

## prueba de los endpoints
```
MicroServicio de Descuentos
GET	/api/descuentos/{id}	-	DescuentoRespuesta	Calcula el descuento de un producto
```

---

## ⚙ Configuración de dependencias (pom.xml)

- Spring Boot WebFlux
- Spring Data JPA
- H2 / MySQL
- Reactor
- Lombok
- Swagger/OpenAPI
- Spring Validation

---

##  Ejecutar microservicios

### productos

```bash
cd msc_products
mvn clean install
mvn spring-boot:run
```

