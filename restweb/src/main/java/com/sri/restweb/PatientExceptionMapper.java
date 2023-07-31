package com.sri.restweb;



import com.sri.restweb.exception.PatientException;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class PatientExceptionMapper  implements ExceptionMapper<PatientException> {

	@Override
	public Response toResponse(PatientException exception) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"Try Again Later\"");
		sb.append("}");

		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	
	}

}
