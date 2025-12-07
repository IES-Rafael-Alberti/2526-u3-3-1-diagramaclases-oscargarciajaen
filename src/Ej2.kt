import java.time.localDate

class Curso(val codigo: Int, val nombre: String, val descripcion: String, val creditos: Int, val nivel: String){

}

class Profesor(val id: Int, val nombre: String, val email: String, val departamento: String){

    fun darClase(){

    }

    fun prepararExamenes(){

    }

    fun evaluarEstudiantes(){

    }

    fun getObtenerCursosImpartidos(){

    }
}

class Estudiante(val numeroExpediente: Int, val nombreCompleto: String, val email: String, val fechaMatriculacion: localDate){

    fun asistirAClase(){

    }

    fun esturdiar(){

    }

    fun presentarseAExamen(){

    }
}

class Matricula(val fechaMatricula: localDate, val nota: Float){

    fun actualizarNota(){

    }

    fun getFechaMatricula(){

    }

}

