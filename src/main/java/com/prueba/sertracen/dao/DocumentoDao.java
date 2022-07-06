package com.prueba.sertracen.dao;

import com.prueba.sertracen.entidades.Documento;
import com.prueba.sertracen.repositorio.IDocumento;

import java.util.List;

public class DocumentoDao implements IDocumento {


    @Override
    public Documento guardar(Documento d) {
        Documento documento = null;

        try{

        }catch (Exception e){

        }

        return documento;
    }

    @Override
    public Documento actualizar(Documento d) {
        return null;
    }

    @Override
    public List<Documento> documentos() {
        return null;
    }

    @Override
    public Documento findById(int id) {
        return null;
    }

    @Override
    public Documento eliminar(Documento d) {
        return null;
    }
}
