# Ejercicio: Cursos Universitarios

## Análisis del Problema

Este ejercicio muestra la gestión de una universidad, donde profesores imparten cursos, estudiantes se matriculan en ellos y se registran las matrículas con fechas y calificaciones.

## Identificación de Clases

### Clase `Curso`

Representa una asignatura que puede ser impartida por uno o varios profesores.

**Atributos:**

- `codigo: int`
- `nombre: str`
- `descripción: str`
- `creditos: int`
- `nivel: str`

### Clase `Profesor`

Representa a un profesor que imparte uno o varios cursos.

**Atributos:**

- `id: int`
- `nombre: str`
- `email: str`
- `departamento: str`

**Métodos:**

- `+ darClase()`
- `+ prepararExamenes()`
- `+ evaluarEstudiantes()`
- `+ getObtenerCursosImpartidos()`

### Clase `Estudiante`

Representa a una persona que estudia cursos en los que se puede matricular.

**Atributos:**

- `numeroExpediente: int`
- `nombreCompleto: str`
- `email: str`
- `fechaMatriculacion: date`

**Métodos:**

- `+ asistirAClase()`
- `+ estudiar()`
- `+ presentarseAExamen()`

### Clase `Matricula`

Es la matricula de un curso concreto, que tiene la fecha y la nota.

**Atributos:**

- `fecha_matricula: date`
- `nota: float`

**Métodos:**

- `+ actualizarNota()`
- `+ getFechaMatricula()`

## Análisis de Relaciones

**Relación Profesor - Curso**  
Un profesor imparte uno o varios cursos (cardinalidad 1 → 1..n). Esto muestra que cada profesor puede enseñar varias asignaturas, pero cada curso tiene un profesor en concreto.

**Relación Estudiante - Matrícula**
Un estudiante puede tener varias matrículas (cardinalidad 1 → 1..n). Esto permite que un estudiante se inscriba en múltiples cursos.

**Relación Matrícula - Curso**  
Cada matrícula corresponde a un único curso (cardinalidad 1 → 1). Una matrícula muestra la inscripción de un estudiante en una asignatura específica.

La clase `Matricula` la he creado como **clase de asociación** entre `Estudiante` y `Curso`, representando la relación muchos a muchos entre ambas. Esto permite recibir múltiples inscripciones del mismo estudiante en distintos cursos, guardando a su vez la fecha de la matrícula y la nota obtenida.

## Código PlantUML
´´´

    @startuml ej_2

    class Curso{
        - codigo:int
        - nombre:str
        - descripción:str
        - creditos:int
        - nivel:str
    }

    class Profesor{
        - id:int
        - nombre:str
        - email:str
        - departamento:str

        + darClase()
        + prepararExamenes()
        + evaluarEstudiantes()
        +                        getObtenerCursosImpartidos()

    }
    class Estudiante {
        - numeroExpediente: int
        - nombreCompleto : str
        - email : str
        - fechaMatriculacion : date

        + asistirAClase()
        + estudiar()
        + presentarseAExamen()

    }

    class Matricula {
        - fecha_matricula : date
        - nota : float
        - actualizarNota()
        - getFechaMatricula()

    }

    Profesor "1" -- "1..n" Curso : "imparte"
    Estudiante "1" -- "1..n" Matricula
    Matricula "1" -- "1" Curso
    @enduml

´´´

## Código en Kotlin



