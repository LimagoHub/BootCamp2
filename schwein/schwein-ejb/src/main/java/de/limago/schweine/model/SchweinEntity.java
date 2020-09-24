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


// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// JPA
@Entity
@Table(name="tblschweine")
@NamedQueries({
	@NamedQuery(name="SchweinEntity.findAll", query = "select s from SchweinEntity s"),
	@NamedQuery(name="SchweinEntity.findByName", query = "select s from SchweinEntity s where s.name like :name")
})
public class SchweinEntity {
	
	@Id private String id;
	@Column(length=30) 	private String name;
	private int gewicht;

}
