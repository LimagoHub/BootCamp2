package de.limago.schweine.service.domainobjects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
	
	
	private String id;
	private String vorname;
	private String nachname;

}
