package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Piste implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long numPiste;
	String namePiste;
	@Enumerated(EnumType.STRING)
	Color color;
	int length;
	int slope;

	@ManyToMany(mappedBy= "pistes")
	Set<Skier> skiers;


	public Piste(String namePiste, Color color, int length, int slope) {
		this.namePiste = namePiste;
		this.color = color;
		this.length = length;
		this.slope = slope;
	}



	// Getters and setters

	@Override
	public String toString() {
		return "Piste [numPiste=" + numPiste + ", namePiste=" + namePiste + ", color=" + color + ", length=" + length
				+ ", slope=" + slope + "]";
	}
	
}
