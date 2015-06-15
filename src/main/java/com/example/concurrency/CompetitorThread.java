package com.example.concurrency;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.PersistenceManager;
import com.example.models.NPaciente;
import com.example.models.NSintoma;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;

public class CompetitorThread extends Thread {

    //private CompetitorDTO competitorDTO;

    @PersistenceContext(unitName = "AplicacionMundialPU")
    EntityManager entityManager;

    /*public CompetitorThread(CompetitorDTO competitorDTO) {
        this.competitorDTO = competitorDTO;
    }*/
    
    private void initEtityManager() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        initEtityManager();

        NSintoma s = new NSintoma();
        //JSONObject rta = new JSONObject();
        s.setFecha(Calendar.getInstance().getTime());
        s.setLocallizacionDolor(1);
        s.setIntensidad(2);
        s.setPatronesSueno("poco");
        Query q = entityManager.createQuery("select u from NPaciente u");
        List<NPaciente> paciente = q.getResultList();
        s.setIdPaciente(paciente.get(0));

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(s);
            entityManager.getTransaction().commit();
            entityManager.refresh(s);
            //rta.put("competitor_id", c.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            s = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        //return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta.toJSONString()).build();
    }

}
