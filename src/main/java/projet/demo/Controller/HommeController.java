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

import projet.demo.Model.ProduitHomme;
import projet.demo.Repository.Ihomme;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/homme")
public class HommeController {
	@Autowired
	private Ihomme hommeRepo ;
	
	// get all employees
	@GetMapping("/all")
	public List<ProduitHomme> getAllHomme(){
		return hommeRepo.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/add")
	public ProduitHomme createHomme(@RequestBody ProduitHomme homme) {
		return hommeRepo.save(homme);
	}
	
	// get employee by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<ProduitHomme> getHommeById(@PathVariable Long id) {
		ProduitHomme prodhomme =hommeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		return ResponseEntity.ok(prodhomme);
	}
	
	// update employee rest api
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProduitHomme> updatehomme(@PathVariable Long id, @RequestBody ProduitHomme hommeDetails){
		ProduitHomme homme = hommeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		
		homme.setName(hommeDetails.getName());
		homme.setPrix(hommeDetails.getPrix());
		homme.setQuantite(hommeDetails.getQuantite());
		
		ProduitHomme updatedHomme = hommeRepo.save(homme);
		return ResponseEntity.ok(updatedHomme);
	}
	
	// delete employee rest api
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteHomme(@PathVariable Long id){
		ProduitHomme deleteHomme = hommeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		hommeRepo.delete(deleteHomme);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
