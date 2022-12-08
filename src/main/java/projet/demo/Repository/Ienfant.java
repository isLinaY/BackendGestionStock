package projet.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.demo.Model.ProduitEnfant;

@Repository
public interface Ienfant extends JpaRepository<ProduitEnfant, Long>{

}
