package com.prueba.sertracen.db;

//import javax.persistence.*;
import jakarta.persistence.*;

public class ConexionJPA {

    @PersistenceUnit(unitName = "pruebaserPU")
    private static EntityManagerFactory emf = null;

    public static EntityManager createEntityManager() {

        try {
            if (emf == null) {
                System.out.println("entra");
                emf = Persistence.createEntityManagerFactory("pruebaserPU");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion xd: " + e.getMessage());
        }

        return emf.createEntityManager();
    }

    public static void desconexion(EntityManager em) {
        if (em != null) {
            em.close();
            emf.close();
        }
    }

}
