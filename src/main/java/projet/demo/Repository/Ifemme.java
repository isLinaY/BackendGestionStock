package projet.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.demo.Model.ProduitFemme;

@Repository
public interface Ifemme extends JpaRepository<ProduitFemme, Long>{

}
