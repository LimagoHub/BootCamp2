package de.limago.schweine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_personen")
@NamedQueries ({
		@NamedQuery(name = "PersonEntity.findAll", query = "select p from PersonEntity p"),
		@NamedQuery(name = "PersonEntity.findByVorname", query = "select p from PersonEntity p where p.vorname like :vorname"),
		@NamedQuery(name = "PersonEntity.findByNachname", query = "select p from PersonEntity p where p.nachname like :nachname")
}
)
public class PersonEntity {
	
	@Id
	@Column(length = 36)
	private String id;
	@Column(length = 30, name = "firstname")
	private String vorname;
	@Column(length = 30, name = "lastname")
	private String nachname;

}
