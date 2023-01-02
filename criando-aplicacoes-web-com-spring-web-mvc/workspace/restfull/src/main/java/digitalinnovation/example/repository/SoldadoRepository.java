package digitalinnovation.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digitalinnovation.example.model.Soldado;

public interface SoldadoRepository extends JpaRepository<Soldado, Long> {

}
