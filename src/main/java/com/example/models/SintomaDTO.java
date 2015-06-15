package com.example.models;

import java.util.Calendar;


public class SintomaDTO {
		   
    private int localizacionDolor;
    private int intensidad;
    private String patronesSueno;
    private int actividadFisica;
    private int idPaciente;
    
    public SintomaDTO(){
        
    }

	public int getLocalizacionDolor() {
		return localizacionDolor;
	}

	public void setLocalizacionDolor(int localizacionDolor) {
		this.localizacionDolor = localizacionDolor;
	}

	public int getIntensidad() {
		return intensidad;
	}

	public void setIntensidad(int intensidad) {
		this.intensidad = intensidad;
	}

	public String getPatronesSueno() {
		return patronesSueno;
	}

	public void setPatronesSueno(String patronesSueno) {
		this.patronesSueno = patronesSueno;
	}

	public int getActividadFisica() {
		return actividadFisica;
	}

	public void setActividadFisica(int actividadFisica) {
		this.actividadFisica = actividadFisica;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
    
}
