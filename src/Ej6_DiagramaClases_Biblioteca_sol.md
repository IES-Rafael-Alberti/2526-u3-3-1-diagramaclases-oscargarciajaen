# Ejercicio 6 - Sistema de Biblioteca 

## Análisis del Problema 

### Identificación de Clases 

1. **Libro** 
   * Representa los ejemplares disponibles.
   * **Atributos**: `tipo` (str), `estado` (str).

2. **Autor**
   * Representa a los escritores.
   * **Atributos**: `nombre_completo`, `fecha_nacimiento`, `multa`.

3. **Sistema**
   * Clase que gestiona todo el sistema de la biblioteca.
   * **Atributos**: `libros_prestados`, `libros_disponibles`.
   * **Métodos**: `getEdad()`, `calcularEdad()`, `prestarLibro()`, `devolverLibro()`, `obtener_numero_prestamos()`, `calcular_fecha_limite_devolucion()`.

4. **Socio**
   * Representa a los usuarios registrados que pueden solicitar libros.
   * **Atributos**: `nombre` (str), `DNI` (str), `fecha_inscripcion` (date), `numero_prestamos_posibles` (int).
   * **Métodos**: `esperar_dias_multa()`.

5. **Prestamo**
   * Registra cada préstamo de libros.
   * **Atributos**: `dia_prestamo`, `numero_prestamos_socio`.
   * **Métodos**: `modificarPrestamosPosibles()`, `modificar_estado()`, `generar_multa()`.

## Análisis de Relaciones 

### 1. Asociación (Sistema → Autor)
* **Tipo**: Asociación simple (`<--`)
* **Descripción**: Sistema conoce datos de Autor para catálogo

### 2. Composición (Socio ← Préstamo)
* **Tipo**: Composición (`<--`)
* **Cardinalidad**: Socio (1) ← Préstamo (1..*)
* **Justificación**: Préstamo depende completamente del socio

### 3. Asociación Múltiple (Préstamo → Libro)
* **Tipo**: Asociación (`-->`)
* **Cardinalidad**: Préstamo (1) → Libro (1..3)
* **Justificación**: Máximo 3 libros por préstamo

### 4. Dependencia (Sistema → Préstamo)
* **Tipo**: Dependencia (flecha punteada `.>`)
* **Descripción**: Sistema gestiona operaciones de Préstamo
* **Justificación**: Sistema necesita Préstamo para funcionar

**Nota**: Completar diagrama PlantUML con todas las relaciones:  


## Código PlantUML

´´´

    @startuml Ejercicio6

    class Libro{
        - tipo : str
        - estado : str
    }

    class Autor{
        - nombre_completo
        - fecha_nacimiento
        - multa
    }

    class Sistema {
        - libros_prestados
        - libros_disponibles
        + getEdad()
        + calcularEdad()
        + prestarLibro()
        + devolverLibro()
        + obtener_numero_prestamos()
        + calcular_fecha_limite_devolucion()
    }

    class Socio {
        - nombre : str
        - DNI : str
        - fecha_inscripcion : date
        - numero_prestamos_posibles : int
        + esperar_dias_multa()
    }

    class Prestamo {
        - dia_prestamo
        - numero_prestamos_socio 
        + modificarPrestamosPosibles()
        + modificar_estado()
        + generar_multa()
    }

    Autor <-- Sistema 
    Socio "1" <-- "1..*" Prestamo
    Prestamo --> "1..3" Libro  
    Sistema .> Prestamo 

    @enduml
´´´

