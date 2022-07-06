package com.prueba.sertracen.interfaces;

import com.prueba.sertracen.modelos.Documento;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IDocumento {

    Documento guardar(Documento d);

    Documento actualizar(Documento d);

    List<Documento> documentos();

    Documento findById(int id);

    void eliminar(int d);
}
