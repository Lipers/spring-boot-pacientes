package rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.api.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
