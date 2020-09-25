package de.limago.schweine.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement
public class PersonDTO {
	
	@NotNull
	@Size(min = 36, max = 36)
	private String id;
	@NotNull
	@Size(min = 1, max = 30)
	private String vorname;
	@NotNull
	@Size(min = 1, max = 30)
	private String nachname;
//	@Pattern(regexp = "[A-ZÖÜÄ]{1,3}-[A-Z]{1,2} [1-9][0-9]{0,3}H?E?")
//	private String kennzeichen;

}
