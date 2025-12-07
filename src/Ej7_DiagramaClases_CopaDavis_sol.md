# Ejercicio Copa Davis - Sistema de Competición

## Análisis del Problema

### Identificación de Clases

1. **País** 
   * Representa un equipo nacional.
   * **Atributos**: `nombre` (str), `bandera` (str).

2. **Jugador**
   * Representa a los tenistas del equipo.
   * **Atributos**: `nombreCompleto` (str), `ranking` (int), `fechaNacimiento` (date), `nacionalidad` (str).
   * **Métodos**: `getEdad()`, `getRanking()`.

3. **Eliminatoria**
   * Clase que gestiona cada enfrentamiento.
   * **Atributos**: `ronda` (int), `superficie` (str), `paisAnfitrion`, `fechaInicio` (date).
   * **Métodos**: `getGanador()`, `getMarcadorGlobal()`.

4. **Partido**
   * Registra cada enfrentamiento ya sea individual o dobles.
   * **Atributos**: `numero` (int), `dia` (int), `esDobles` (boolean), `setsGanadosEquipo1` (int), `setsGanadosEquipo2` (int).
   * **Métodos**: `getGanador()`, `esPartidoGanado()`.

## Análisis de Relaciones

### 1. Composición (País → Jugador)
* **Tipo**: Composición (`o--`)
* **Cardinalidad**: País (1) → Jugador (0..5)
* **Justificación**: Máximo 5 jugadores por equipo

### 2. Asociación (País → Eliminatoria)
* **Tipo**: Asociación (`--`)
* **Cardinalidad**: País (2) → Eliminatoria (1)
* **Justificación**: 2 países compiten por eliminatoria

### 3. Composición (Eliminatoria → Partido)
* **Tipo**: Composición (`*--`)
* **Cardinalidad**: Eliminatoria (1) → Partido (5)
* **Justificación**: Exactamente 5 partidos por eliminatoria

## Código PlantUML

´´´

    @startuml CopaDavis_Simple

    class Pais {
        - nombre: str
        - bandera: str
        + getNombreCompleto()
    }

    class Jugador {
        - nombreCompleto: str
        - ranking: int
        - fechaNacimiento: date
        - nacionalidad: str
        + getEdad()
        + getRanking()
    }

    class Eliminatoria {
        - ronda: int
        - superficie: str
        - paisAnfitrion: Pais
        - fechaInicio: date
        + getGanador()
        + getMarcadorGlobal()
    }

    class Partido {
        - numero: int
        - dia: int
        - esDobles: boolean
        - setsGanadosEquipo1: int
        - setsGanadosEquipo2: int
        + getGanador()
        + esPartidoGanado(equipo: Pais): boolean
    }

    class ParejaDobles {
        - jugador1: Jugador
        - jugador2: Jugador
        + getJugadores()
    }

    ' Relaciones
    Pais "1" -- "0..5" Jugador : contiene
    Pais "2" -- "1" Eliminatoria : compite_en
    Eliminatoria "1" --> "5" Partido : contiene
    Partido <|-- ParejaDobles : dobles

    note right of Eliminatoria
    Formato fijo:
    Día 1: Partido 1,2 (individuales)
    Día 2: Partido 3 (dobles)  
    Día 3: Partido 4,5 (individuales)
    end note

    note right of Partido
    Ganador: 3 de 5 partidos
    end note

    @enduml

´´´
