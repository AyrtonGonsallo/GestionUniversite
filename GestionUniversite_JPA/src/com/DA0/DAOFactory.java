package com.DA0;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.DA0.exceptions.DAOConfigurationException;

public class DAOFactory {

   

    DAOFactory() {
        
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        DAOFactory instance = new DAOFactory();
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
     /* package */ EntityManager getEntityManager() throws Exception {
        return Persistence.createEntityManagerFactory("JPA").createEntityManager();
    }

    /*
     * Méthodes de récupération de l'implémentation des différents DAO (un seul
     * pour le moment)
     */
    public EtudiantDAO getEtudiantDAO() {
        return new EtudiantDAO(this);
    }
    public NoteDAO getNoteDAO() {
        return new NoteDAO( this );
    }
    public ProfesseurDAO getProfesseurDAO() {
        return new ProfesseurDAO( this );
    }
}