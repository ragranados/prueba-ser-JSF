package com.prueba.sertracen.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionJPA {

    private static EntityManagerFactory emf = null;

    public static EntityManager createEntityManager() {

        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("pruebaserPU");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }

        return emf.createEntityManager();
    }

    public static void desconexion(EntityManager em){
        if(em != null){
            em.close();
            emf.close();
        }
    }

}
