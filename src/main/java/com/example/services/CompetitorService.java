/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.concurrency.CompetitorThread;
import com.example.models.NPaciente;
/*import com.example.models.Competitor;
import com.example.models.CompetitorDTO;*/

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

/**
 *
 * @author Mauricio
 */
@Path("/competitors")
@Produces(MediaType.APPLICATION_JSON)
public class CompetitorService {

    @PersistenceContext(unitName = "AplicacionMundialPU")
    EntityManager entityManager;
    
    public void initDB() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
    	initDB();
        Query q = entityManager.createQuery("select u from Npaciente u");
        List<NPaciente> paciente = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(paciente).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompetitor(){//(CompetitorDTO competitor) {
    	JSONObject rta = new JSONObject();
    	Runnable thread = new CompetitorThread();
    	new Thread(thread).start();
    	rta.put("competitor_id","1");
    	System.out.println("Entró a dejar un nuevo registro");
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta.toJSONString()).build();
    }
    
    @OPTIONS
    public Response cors(@javax.ws.rs.core.Context HttpHeaders requestHeaders) {
        return Response.status(200).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS").header("Access-Control-Allow-Headers", "AUTHORIZATION, content-type, accept").build();
    }

}
