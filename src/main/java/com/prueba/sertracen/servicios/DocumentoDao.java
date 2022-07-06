package com.prueba.sertracen.servicios;

import com.prueba.sertracen.db.ConexionJPA;
import com.prueba.sertracen.modelos.Documento;
import com.prueba.sertracen.interfaces.IDocumento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DocumentoDao implements IDocumento {

    private EntityManager em = null;

    public DocumentoDao() {
        em = ConexionJPA.createEntityManager();
    }

    @Override
    public Documento guardar(Documento d) {



        try {
            em.getTransaction().begin();
            em.persist(d);

            em.getTransaction().commit();
        } finally {
            ConexionJPA.desconexion(em);
        }

        return d;
    }

    @Override
    public Documento actualizar(Documento d) {

        try {

            Documento d1 = em.find(Documento.class, d.getId());

            em.getTransaction().begin();

            if (em.contains(d1)) {
                em.merge(d);
            }

            em.getTransaction().commit();
        } finally {
            ConexionJPA.desconexion(em);
        }

        return d;
    }

    @Override
    public List<Documento> documentos() {

        List<Documento> listaDocumentos = null;

        try {

            Query query = em.createNamedQuery("Documento.findAll");

            listaDocumentos = query.getResultList();

        } finally {
            ConexionJPA.desconexion(em);
        }

        return listaDocumentos;

    }

    @Override
    public Documento findById(int id) {

        try{

            return em.find(Documento.class, id);

        }finally {
            ConexionJPA.desconexion(em);
        }

    }

    @Override
    public void eliminar(int id) {

        try{

            Documento d = em.find(Documento.class, id);

            em.getTransaction().begin();

            if(d != null){
                em.remove(d);
            }

            em.getTransaction().commit();

        }finally {
            ConexionJPA.desconexion(em);
        }
    }
}
