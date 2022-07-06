package com.prueba.sertracen.controladores;

import com.prueba.sertracen.modelos.Documento;
import com.prueba.sertracen.servicios.DocumentoDao;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

import java.util.List;

public class ListarDocumento {

    private List<Documento> documentos;

    @Inject
    private DocumentoDao documentoDao;

    @PostConstruct
    public void init(){
        this.documentos = documentoDao.documentos();
    }

    public List<Documento> getDocumentos() {
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
