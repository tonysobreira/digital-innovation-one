package digitalinnovation.example.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digitalinnovation.example.restfull.model.Soldado;

public interface SoldadoRepository extends JpaRepository<Soldado, Long> {

}
