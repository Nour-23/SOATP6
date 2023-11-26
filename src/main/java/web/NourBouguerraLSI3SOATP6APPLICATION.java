package web;

import entities.Compte;
import entities.EtatCompte;
import entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CompteRepository;

import java.util.Date;

// Spécifie que cette classe est une application Spring Boot
@SpringBootApplication
// Active la configuration des dépôts JPA avec le package "repositories"
@EnableJpaRepositories(basePackages = "repositories")
// Active la recherche des entités JPA avec le package "entities"
@EntityScan(basePackages = "entities")
public class NourBouguerraLSI3SOATP6APPLICATION {

    // Point d'entrée de l'application
    public static void main(String[] args) {
        // Lance l'application Spring Boot
        SpringApplication.run(NourBouguerraLSI3SOATP6APPLICATION.class, args);
    }

    // Définition d'une méthode CommandLineRunner pour l'initialisation des données au démarrage
    @Bean
    public CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            // Création de trois comptes avec des caractéristiques différentes
            Compte compte1 = new Compte(null, 1000.0, new Date(), TypeCompte.COURANT, EtatCompte.ACTIVE);
            Compte compte2 = new Compte(null, 500.0, new Date(), TypeCompte.EPARGNE, EtatCompte.ACTIVE);
            Compte compte3 = new Compte(null, 200.0, new Date(), TypeCompte.EPARGNE, EtatCompte.ACTIVE);

            // Sauvegarde des comptes dans la base de données à l'aide du CompteRepository
            compteRepository.save(compte1);
            compteRepository.save(compte2);
            compteRepository.save(compte3);

            // Affichage des soldes des comptes dans la console
            for (Compte c : compteRepository.findAll()) {
                // Utilisation de System.out.println pour afficher les informations dans la console
                System.out.println("Solde du compte " + c.getId() + ": " + c.getSolde());
            }
        };
    }
}
