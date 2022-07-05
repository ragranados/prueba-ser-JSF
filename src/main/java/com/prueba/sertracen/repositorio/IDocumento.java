package com.prueba.sertracen.repositorio;

import com.prueba.sertracen.entidades.Documento;

import java.util.List;

public interface IDocumento {

    Documento guardar(Documento d);

    Documento actualizar(Documento d);

    List<Documento> documentos();

    Documento findById(int id);

    Documento eliminar(Documento d);
}
