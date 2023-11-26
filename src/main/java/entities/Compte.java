package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.Date;

// Annotation Lombok : génère automatiquement les méthodes getters, setters,
// toString, constructeurs par défaut et avec tous les champs
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

// Annotation JPA : indique que cette classe est une entité persistante dans la base de données
@Entity
public class Compte {
    // Annotation JPA : indique que cet attribut est l'identifiant de l'entité
    @Id
    // Annotation JPA : spécifie que l'identifiant doit être généré automatiquement
    // par la base de données, utilisant une stratégie d'auto-incrémentation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double solde; // Solde du compte
    private Date dt; // Date de création du compte
    private TypeCompte type; // Type de compte (COURANT ou EPARGNE)
    private EtatCompte etat; // État du compte (CREE, ACTIVE, SUSPENDU, BLOQUE)

    public Compte(Object o, double v, Date date, TypeCompte typeCompte, EtatCompte etatCompte) {
    }
}
