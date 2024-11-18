package projet.spring.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import projet.spring.entities.Image;
import projet.spring.entities.Ingredient;
import projet.spring.repos.ImageRepository;
import projet.spring.repos.IngredientRepository;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	IngredientService ingredientservice;

	@Autowired
	IngredientRepository ingredientRepository;

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		/*
		 * Ce code commenté est équivalent au code utilisant le design pattern Builder
		 * Image image = new Image(null, file.getOriginalFilename(),
		 * file.getContentType(), file.getBytes(), null); return
		 * imageRepository.save(image);
		 */
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).build());
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
				.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}

	@Override
	public Image uplaodImageIng(MultipartFile file, Long idIng) throws IOException {
		// Charger l'ingrédient existant depuis la base de données
		Optional<Ingredient> ingredientOpt = ingredientRepository.findById(idIng);

		if (ingredientOpt.isPresent()) {
			Ingredient ingredient = ingredientOpt.get();
			Image image = Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
					.image(file.getBytes()).ingredient(ingredient) // Associer l'ingrédient existant
					.build();

			return imageRepository.save(image);
		} else {
			throw new RuntimeException("Ingrédient non trouvé pour l'ID : " + idIng);
		}
	}

	@Override
	public List<Image> getImagesParIng(Long VetId) {
		Ingredient p = this.ingredientRepository.findById(VetId).get();
		return p.getImages();

	}

	/*
	 * public Image uplaodImage(MultipartFile file) throws IOException { return
	 * imageRepository.save(Image.builder() .name(file.getOriginalFilename())
	 * .type(file.getContentType()) .image(file.getBytes()).build() ); }
	 * 
	 * @Override public Image getImageDetails(Long id) throws IOException{ final
	 * Optional<Image> dbImage = imageRepository. findById (id); return
	 * Image.builder() .idImage(dbImage.get().getIdImage())
	 * .name(dbImage.get().getName()) .type(dbImage.get().getType())
	 * .image(dbImage.get().getImage()).build() ; }
	 * 
	 * 
	 * @Override public ResponseEntity<byte[]> getImage(Long id) throws IOException{
	 * final Optional<Image> dbImage = imageRepository. findById (id); return
	 * ResponseEntity .ok() .contentType(MediaType.valueOf(dbImage.get().getType()))
	 * .body(dbImage.get().getImage()); }
	 */

}