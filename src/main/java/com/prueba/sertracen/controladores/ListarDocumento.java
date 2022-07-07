package com.prueba.sertracen.controladores;

import com.prueba.sertracen.modelos.Documento;
import com.prueba.sertracen.servicios.DocumentoDao;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListarDocumento implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Documento> documentos;

    @Inject
    private DocumentoDao documentoDao;

    @PostConstruct
    public void init(){
        this.documentos = documentoDao.documentos();
    }

    public List<Documento> getDocumentos() {
        System.out.println(documentos);
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public DocumentoDao getDocumentoDao() {
        return documentoDao;
    }

    public void setDocumentoDao(DocumentoDao documentoDao) {
        this.documentoDao = documentoDao;
    }
}
