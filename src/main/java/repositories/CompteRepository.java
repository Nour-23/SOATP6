package repositories;

import entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface définissant un repository pour l'entité Compte, étend JpaRepository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
