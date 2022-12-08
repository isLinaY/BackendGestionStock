package projet.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.demo.Model.ProduitEnfant;
import projet.demo.Repository.Ienfant;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enfant")

public class EnfantController {
	@Autowired
	private Ienfant enfantRepo ;
	
	// get all employees
	@GetMapping("/all")
	public List<ProduitEnfant> getAllEnfant(){
		return enfantRepo.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/add")
	public ProduitEnfant createEnfant(@RequestBody ProduitEnfant enfant) {
		return enfantRepo.save(enfant);
	}
	
	// get employee by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<ProduitEnfant> getEnfantById(@PathVariable Long id) {
		ProduitEnfant prodenfant =enfantRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		return ResponseEntity.ok(prodenfant);
	}
	
	// update employee rest api
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProduitEnfant> updateenfant(@PathVariable Long id, @RequestBody ProduitEnfant enfantDetails){
		ProduitEnfant enfant = enfantRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		
		enfant.setName(enfantDetails.getName());
		enfant.setPrix(enfantDetails.getPrix());
		enfant.setQuantite(enfantDetails.getQuantite());
		
		ProduitEnfant updatedEnfant = enfantRepo.save(enfant);
		return ResponseEntity.ok(updatedEnfant);
	}
	
	// delete employee rest api
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEnfant(@PathVariable Long id){
		ProduitEnfant deleteEnfant = enfantRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		
		enfantRepo.delete(deleteEnfant);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
