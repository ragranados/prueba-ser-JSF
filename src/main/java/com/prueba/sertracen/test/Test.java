package com.prueba.sertracen.test;

import com.prueba.sertracen.servicios.DocumentoDao;
import com.prueba.sertracen.modelos.Documento;
import com.prueba.sertracen.interfaces.IDocumento;
import io.github.cdimascio.dotenv.Dotenv;

public class Test {

    public static void main(String[] args) {
        Dotenv dotenv = null;

        dotenv = Dotenv.configure().load();

        IDocumento documento = new DocumentoDao();
        Documento d = new Documento();

        //d.setId(2);
        d.setNombre("Raul A");
        d.setApellido("Granados H");
        d.setEdad(14);
        d.setFoto("URL FOTO EQUIS DE");
        d.setEmail("email");

        DocumentoDao da = new DocumentoDao();

        da.guardar(d);

        System.out.println(dotenv.get("PRUEBA"));
    }

}
