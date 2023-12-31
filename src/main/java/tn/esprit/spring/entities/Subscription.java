package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Subscription implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long numSub;
	LocalDate startDate;
	LocalDate endDate;
	Float price;
//	@Enumerated(EnumType.STRING)
	TypeSubscription typeSub;
	//amira hajji


}
