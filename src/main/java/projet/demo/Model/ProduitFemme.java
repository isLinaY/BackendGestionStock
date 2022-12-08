package projet.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "femme")
public class ProduitFemme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "prix")
	private String prix;
	
	@Column(name = "quantite")
	private String quantite;
	
	public ProduitFemme() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public ProduitFemme(long id, String name, String prix, String quantite) {
		super();
		this.id = id;
		this.name = name;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	
	
}
