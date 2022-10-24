package thaylanvinicius.repositories;
import org.springframework.data.repository.CrudRepository;

import thaylanvinicius.models.Professor;

public interface ProfessoresRepository extends CrudRepository<Professor, Integer> {
    
}
