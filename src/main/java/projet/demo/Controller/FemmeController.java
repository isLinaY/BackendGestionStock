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

import projet.demo.Model.ProduitFemme;
import projet.demo.Repository.Ifemme;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/femme")
public class FemmeController {

	@Autowired
	private Ifemme femmeRepo ;
	
	// get all employees
	@GetMapping("/all")
	public List<ProduitFemme> getAllFemme(){
		return femmeRepo.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/add")
	public ProduitFemme createFemme(@RequestBody ProduitFemme femme) {
		return femmeRepo.save(femme);
	}
	
	// get employee by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<ProduitFemme> getFemmeById(@PathVariable Long id) {
		ProduitFemme prodfemme =femmeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		return ResponseEntity.ok(prodfemme);
	}
	
	// update employee rest api
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProduitFemme> updatefemme(@PathVariable Long id, @RequestBody ProduitFemme femmeDetails){
		ProduitFemme femme = femmeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		
		femme.setName(femmeDetails.getName());
		femme.setPrix(femmeDetails.getPrix());
		femme.setQuantite(femmeDetails.getQuantite());
		
		ProduitFemme updatedFemme = femmeRepo.save(femme);
		return ResponseEntity.ok(updatedFemme);
	}
	
	// delete employee rest api
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteFemme(@PathVariable Long id){
		ProduitFemme deleteFemme = femmeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		
		femmeRepo.delete(deleteFemme);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}