package projet.spring.entities;


import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecette;

    private String nomRecette;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @JsonIgnore
    @OneToMany(mappedBy = "recette", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
    
    public void setIdRec(long Recetteid) {
    	this.idRecette = Recetteid;
    }
}