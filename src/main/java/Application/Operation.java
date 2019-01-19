package Application;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Service
@Table(name = "operations")
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String ibansource;
    private String ibandest;
    private Double montant;
    @JsonFormat(locale = "hu", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Budapest")
    private Date date;

    public Operation() {
    }

    public Operation(Long id, String type, String ibansource, String ibandest, Double montant, Date date) {
        this.id = id;
        this.type = type;
        this.ibansource = ibansource;
        this.ibandest = ibandest;
        this.montant = montant;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "ibansource")
    public String getIbansource() {
        return ibansource;
    }

    public void setIbansource(String ibansource) {
        this.ibansource = ibansource;
    }

    @Column(name = "ibandest")
    public String getIbandest() {
        return ibandest;
    }

    public void setIbandest(String ibandest) {
        this.ibandest = ibandest;
    }

    @Column(name = "montant")
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}