package thaylanvinicius.repositories;

import org.springframework.data.repository.CrudRepository;

import thaylanvinicius.models.Aluno;

public interface AlunosRepository extends CrudRepository<Aluno, Integer> {
}