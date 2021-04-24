package com.DA0;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.DA0.exceptions.DAOConfigurationException;

public class DAOFactory {

   

    DAOFactory() {
        
    }

    /*
     * M�thode charg�e de r�cup�rer les informations de connexion � la base de
     * donn�es, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        DAOFactory instance = new DAOFactory();
        return instance;
    }

    /* M�thode charg�e de fournir une connexion � la base de donn�es */
     /* package */ EntityManager getEntityManager() throws Exception {
        return Persistence.createEntityManagerFactory("JPA").createEntityManager();
    }

    /*
     * M�thodes de r�cup�ration de l'impl�mentation des diff�rents DAO (un seul
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