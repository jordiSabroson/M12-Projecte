package iticjobs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iticjobs.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{

}
