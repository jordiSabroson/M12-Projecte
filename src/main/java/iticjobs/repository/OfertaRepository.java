package iticjobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iticjobs.model.Oferta;

@Repository
public interface OfertaRepository extends CrudRepository<Oferta, Long>{

}
