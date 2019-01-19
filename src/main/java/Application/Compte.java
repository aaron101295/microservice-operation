package Application;


import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Service
@Table(name = "compte_bancaire")
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    private String typedecompte;
    private Double interet;
    private String frais;
    private Double solde;

    public Compte() {
    }

    public Compte(String iban, String typedecompte, Double interet, String frais, Double solde) {
        this.iban = iban;
        this.typedecompte = typedecompte;
        this.interet = interet;
        this.frais = frais;
        this.solde = solde;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTypedecompte() {
        return typedecompte;
    }

    public void setTypedecompte(String typedecompte) {
        this.typedecompte = typedecompte;
    }

    public Double getInteret() {
        return interet;
    }

    public void setInteret(Double interet) {
        this.interet = interet;
    }

    public String getFrais() {
        return frais;
    }

    public void setFrais(String frais) {
        this.frais = frais;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

}

