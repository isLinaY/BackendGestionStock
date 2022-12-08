package projet.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.demo.Model.ProduitHomme;

@Repository
public interface Ihomme extends JpaRepository<ProduitHomme, Long> {

}
