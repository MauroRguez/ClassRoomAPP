package com.example.APIClassRoom.ayudas;

public enum MensajesAPI {


    CURSO_NO_ENCONTRADO("El curso que busca no se encuentra en la BD"),
    MATERIA_NO_ENCONTRADA("La materia que busca no se encuentra en la BD"),
    INSCRIPCION_NO_ENCONTRADA("La inscripcion que busca no se encuentra en la BD"),
    CALIFICACION_NO_ENCONTRADA("La calificacion que busca no se encuentra en la BD"),
    ASISTENCIA_NO_ENCONTRADA("La asistencia que busca no se encuentra en la BD"),
    USUARIO_NO_ENCONTRADO("El usuario que busca no se encuentra en la BD"),
    ESTUDIANTE_NO_ENCONTRADO("El estudiuante que busca no se encuentra en la BD"),
    DOCENTE_NO_ENCONTRADO("El docente que busca no se encuentra en la BD");




    private String texto;

    MensajesAPI(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
