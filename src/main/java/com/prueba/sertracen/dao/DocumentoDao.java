package com.prueba.sertracen.dao;

import com.prueba.sertracen.db.ConexionJPA;
import com.prueba.sertracen.entidades.Documento;
import com.prueba.sertracen.repositorio.IDocumento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class DocumentoDao implements IDocumento {

    private EntityManager em = null;

    @Override
    public Documento guardar(Documento d) {

        em = ConexionJPA.createEntityManager();

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
        em = ConexionJPA.createEntityManager();

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
        em = ConexionJPA.createEntityManager();

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
        em = ConexionJPA.createEntityManager();

        try{

            return em.find(Documento.class, id);

        }finally {
            ConexionJPA.desconexion(em);
        }

    }

    @Override
    public void eliminar(int id) {
        em = ConexionJPA.createEntityManager();

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
