package com.prueba.sertracen.servicios;

import com.prueba.sertracen.db.ConexionJPA;
import com.prueba.sertracen.modelos.Documento;

//import javax.persistence.*;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@LocalBean
@Stateless
public class DocumentoDao {

    @PersistenceContext
    private EntityManager em = null;

    public DocumentoDao() {
        em = ConexionJPA.createEntityManager();
    }

    //@Override
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

    //@Override
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

    //@Override
    public List<Documento> documentos() {

        em = ConexionJPA.createEntityManager();

        List<Documento> listaDocumentos = null;

        try {

            Query query = em.createNamedQuery("Documento.findAll");

            //Query query = em.createQuery("SELECT c FROM Documento c", Documento.class).getResultList();

            listaDocumentos = query.getResultList();

        } finally {
            ConexionJPA.desconexion(em);
        }

        return listaDocumentos;

    }

    //@Override
    public Documento findById(int id) {

        try{

            return em.find(Documento.class, id);

        }finally {
            ConexionJPA.desconexion(em);
        }

    }

    //@Override
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
