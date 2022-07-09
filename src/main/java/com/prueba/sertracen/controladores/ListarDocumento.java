package com.prueba.sertracen.controladores;

import com.prueba.sertracen.modelos.Documento;
import com.prueba.sertracen.servicios.DocumentoDao;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListarDocumento implements Serializable {

    private List<Documento> documentos;

    private Documento documento = new Documento();

    @Inject
    transient private DocumentoDao documentoDao;

    @PostConstruct
    public void init(){
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
        this.documentos = documentoDao.documentos();
    }

    public void update() {

        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public void agregar() {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public ListarDocumento() {

    }

    public List<Documento> getDocumentos() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
