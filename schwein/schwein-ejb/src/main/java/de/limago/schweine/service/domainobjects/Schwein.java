package de.limago.schweine.service.domainobjects;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class Schwein {
	@Setter(AccessLevel.NONE)
	private String id;
	private String name;
	@Setter(AccessLevel.NONE)
	private int gewicht;

	public void fressen() {
		gewicht ++;
	}

}
