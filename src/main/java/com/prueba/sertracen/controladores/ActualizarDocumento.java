package com.prueba.sertracen.controladores;

import com.prueba.sertracen.servicios.DocumentoDao;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Named
@ViewScoped
public class ActualizarDocumento implements Serializable {

    @Inject
    private DocumentoDao documentoDao;

    @PostConstruct
    public void init(){

    }
}
