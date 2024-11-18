package projet.spring.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Ingredient {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngredient;

    private String nomIngredient;
    private Double quantite;
    private String uniteMesure;
    
    
    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recette;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ingredient")
    private List<Image> images;
   
   /***
    * private String imagePath;
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

    * ****/ 
    
    
    public Ingredient() {
        super();
    }

    public Ingredient(Long idIngredient, String nomIngredient, Double quantite, String uniteMesure) {
        super();
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
        this.quantite = quantite;
        this.uniteMesure = uniteMesure;
    } 
    
    public Ingredient(Long idIngredient, String nomIngredient, Double quantite, String uniteMesure,Recette r) {
        super();
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
        this.quantite = quantite;
        this.uniteMesure = uniteMesure;
        this.recette =r;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public String getUniteMesure() {
        return uniteMesure;
    }

    public void setUniteMesure(String uniteMesure) {
        this.uniteMesure = uniteMesure;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "idIngredient=" + idIngredient +
                ", nomIngredient='" + nomIngredient + '\'' +
                ", uniteMesure='" + uniteMesure + '\'' +
                '}';
    }

	public Recette getRecette() {
		return this.recette;
	}

	public void setRecette(Recette recette2) {
		this.recette = recette2;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	
	
}
