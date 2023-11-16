package iticjobs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iticjobs.model.Empresa;
import iticjobs.model.Oferta;
import iticjobs.repository.EmpresaRepository;
import iticjobs.repository.OfertaRepository;

@RestController
@RequestMapping("/api")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;
	private OfertaRepository ofertaRepository;

	public EmpresaController(OfertaRepository ofertaRepository) {
		this.ofertaRepository = ofertaRepository;
	}

	@GetMapping("/empresa")
	public Iterable<Empresa> buscaEmpresa() {
		return empresaRepository.findAll();
	}

	@GetMapping("/empresa/{id}")
	public Optional<Empresa> buscaPerIdEmpresa(@PathVariable long id) {
		return empresaRepository.findById(id);
	}

	@PostMapping("/empresa")
	public Empresa afegeixEmpresa(@RequestBody Empresa empresa) {
		Empresa empresa1 = empresaRepository.save(empresa);
		return empresa1;
	}

	@PutMapping("/empresa/{id}")
	public Empresa modificaEmpresa(@RequestBody Empresa empresa, @PathVariable long id) {
		return empresaRepository.findById(id).map(empresa1 -> {
			empresa1.setNom(empresa.getNom());
			empresa1.setCif(empresa.getCif());
			return empresaRepository.save(empresa1);
		}).orElseGet(() -> {
			empresa.setId(id);
			return empresaRepository.save(empresa);
		});
	}

	@DeleteMapping("/empresa/{id}")
	public void esborra(@PathVariable long id) {
		empresaRepository.deleteById(id);
	}

	@GetMapping("/oferta")
	public Iterable<Oferta> buscaOfertes() {
		return ofertaRepository.findAll();
	}

	@GetMapping("/oferta/{id}")
	public Optional<Oferta> buscaPerIdOferta(@PathVariable long id) {
		return ofertaRepository.findById(id);
	}

	@PostMapping("/oferta")
	public Oferta afegeixOferta(@RequestBody Oferta oferta) {
		Oferta oferta1 = ofertaRepository.save(oferta);
		return oferta1;
	}

	@PutMapping("/oferta/{id}")
	public Oferta modificaOferta(@RequestBody Oferta oferta, @PathVariable long id) {
		return ofertaRepository.findById(id).map(oferta1 -> {
			oferta1.setTitol(oferta.getTitol());
			oferta1.setJornada(oferta.getJornada());
			oferta1.setCiutat(oferta.getCiutat());
			oferta1.setSalari(oferta.getSalari());
			return ofertaRepository.save(oferta1);
		}).orElseGet(() -> {
			oferta.setId(id);
			return ofertaRepository.save(oferta);
		});
	}

	@DeleteMapping("/oferta/{id}")
	public void esborraOferta(@PathVariable long id) {
		ofertaRepository.deleteById(id);
	}
}
