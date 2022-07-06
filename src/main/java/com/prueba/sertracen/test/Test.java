package com.prueba.sertracen.test;

import com.prueba.sertracen.dao.DocumentoDao;
import com.prueba.sertracen.entidades.Documento;
import com.prueba.sertracen.repositorio.IDocumento;

public class Test {

    public static void main(String[] args) {

        IDocumento documento = new DocumentoDao();
        Documento d = new Documento();

        //d.setId(2);
        d.setNombre("Raul A");
        d.setApellido("Granados H");
        d.setEdad(14);
        d.setFoto("URL FOTO EQUIS DE");
        d.setEmail("email");

        DocumentoDao da = new DocumentoDao();

        da.eliminar(2);
    }

}
