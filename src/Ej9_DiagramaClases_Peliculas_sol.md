# Ejercicio Películas - Catálogo Cinematográfico

## Análisis del Problema

### Identificación de Clases

1. **Pelicula** 
   * Representa las películas del catálogo.
   * **Atributos**: `titulo` (str), `añoEstreno` (int), `duracionMinutos` (int), `idiomaOriginal` (str).

2. **Persona**
   * Representa personas del cine (directores y actores).
   * **Atributos**: `nombreCompleto` (str), `fechaNacimiento` (date), `nacionalidad` (str).
   * **Métodos**: `getEdad()`.

3. **Director**
   * Hereda de Persona. Dirige películas.

4. **Actor**
   * Hereda de Persona. Participa en películas.

5. **Participacion**
   * Registra la actuación de un actor en una película específica.
   * **Atributos**: `papel` (str).
   * **Métodos**: `getPapel()`.

## Análisis de Relaciones

### 1. Asociación (Director → Pelicula)
* **Tipo**: Asociación simple (`--`)
* **Descripción**: Director dirige películas del catálogo

### 2. Asociación (Actor → Participacion)
* **Tipo**: Asociación (`--`)
* **Cardinalidad**: Actor (0..*) → Participacion (0..*)
* **Justificación**: Actor participa en múltiples películas

### 3. Asociación Múltiple (Participacion → Pelicula)
* **Tipo**: Asociación (`--`)
* **Cardinalidad**: Participacion (0..*) → Pelicula (0..*)
* **Justificación**: Múltiples actores por película

### 4. Herencia (Persona → Director/Actor)
* **Tipo**: Herencia (`<|--`)
* **Descripción**: Director y Actor comparten atributos de Persona
* **Justificación**: Evita duplicación de datos

## Código PlantUML

´´´

    @startuml CatalogoPeliculas_Simple

    ' Clases principales
    class Persona {
        - nombreCompleto: str
        - fechaNacimiento: date
        - nacionalidad: str
        + getEdad()
    }

    class Director extends Persona {
    }

    class Actor extends Persona {
    }

    class Pelicula {
        - titulo: str
        - añoEstreno: int
        - duracionMinutos: int
        - idiomaOriginal: str
        + getDuracion()
    }

    class Participacion {
        - papel: str
        + getPapel()
    }


    Director "1" -- "0..*" Pelicula : dirige
    Actor "0..*" - "0..*" Pelicula : actua_en
    Participacion o- "0..*" Actor
    Participacion o-- "0..*" Pelicula

    @enduml

´´´

