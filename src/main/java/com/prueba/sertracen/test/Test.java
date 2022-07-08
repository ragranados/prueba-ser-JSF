package com.prueba.sertracen.test;

import com.prueba.sertracen.servicios.DocumentoDao;
import com.prueba.sertracen.modelos.Documento;
import io.github.cdimascio.dotenv.Dotenv;

public class Test {

    public static void main(String[] args) {

        Documento d = new Documento();

        //d.setId(2);
        d.setNombre("Raul A");
        d.setApellido("Granados H");
        d.setEdad(14);
        d.setFoto("URL FOTO EQUIS DE");
        d.setEmail("email");

        DocumentoDao da = new DocumentoDao();

        for (Documento d1: da.documentos()) {
            System.out.println(d1.getApellido());
        }
    }

}
