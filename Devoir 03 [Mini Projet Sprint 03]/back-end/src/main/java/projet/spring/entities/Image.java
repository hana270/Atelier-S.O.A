package projet.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImage;
	
	private String name;
	private String type;
	
	@Column(name = "IMAGE", length = 4048576)
	@Lob
	private byte[] image;

	@ManyToOne()
	 @JoinColumn (name="ingredient_id")
	@JsonBackReference
	private Ingredient ingredient;
	
}
