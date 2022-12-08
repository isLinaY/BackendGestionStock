package projet.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name = "enfant")
@Data @NoArgsConstructor @ToString @AllArgsConstructor
public class ProduitEnfant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "prix")
	private String prix;
	
	@Column(name = "quantite")
	private String quantite;
}
