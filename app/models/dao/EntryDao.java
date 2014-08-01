package models.dao;


import models.Entry;
import play.db.jpa.JPA;

import javax.persistence.EntityManager;

public class EntryDao {
    private EntityManager getEm(){
        return JPA.em();
    }

    public void persist(Entry entry){
        getEm().persist(entry);
    }
}