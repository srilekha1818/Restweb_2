package com.sri.restweb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sri.restweb.data.Patient;

import jakarta.ws.rs.core.Response;



@Service
public class PatientServiceImpl implements PatientService {
	Map<Long, Patient> patients = new HashMap<>();
	long currentId = 100;
	public PatientServiceImpl() {
	init();
	}
	 void init() {
		// TODO Auto-generated method stub
		 Patient patient = new Patient();
			patient.setId(currentId);
			patient.setName("John");
			patients.put(patient.getId(), patient);
	}
	 @Override
	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		Collection<Patient> results = patients.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
	}
	@Override
	public Patient getPatient(Long id) {
		
		return patients.get(id);
	}
	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}
	@Override
	public Response updatePatient(Patient patient) {
		Patient currentPatient = patients.get(patient.getId());
		Response response;
		
		if (currentPatient != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		} else {
			response=Response.notModified().build();
		}
		return response;
	}
	
	@Override
	public Response deletePatient(Long id) {
		Patient patient = patients.get(id);

		Response response;

		if (patient != null) {
			patients.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}
}
