package projet.spring.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import projet.spring.entities.Image;
import projet.spring.service.ImageService;
import projet.spring.service.IngredientService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;

	@Autowired
	IngredientService ingredientservice;
	/*
	private static final String IMAGE_DIRECTORY = "C:/images/";
*/
	
	@RequestMapping(value = "/upload" , method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	return imageService.uplaodImage(file);
	}

	 @RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	    public ResponseEntity<?> getImageDetails(@PathVariable("id") Long id) {
	        try {
	            Image image = imageService.getImageDetails(id);
	            return ResponseEntity.ok(image);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.status(404).body(e.getMessage());
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error while processing image");
	        }
	    }
	 
	 
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException { 
		 return imageService.getImage(id);
	 }


	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	
	/*
	@PostMapping(value = "/uplaodImageIng/{idIng}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idIng") Long idIng)
			throws IOException {
		return imageService.uplaodImageIng(file, idIng);
	}*/
	@RequestMapping(value = "/uplaodImageIng/{idIng}", method = RequestMethod.POST)
	public Image uploadImageIng(@RequestParam("image") MultipartFile file,
	                          @PathVariable("idIng") Long idIng) throws IOException {
	    return imageService.uplaodImageIng(file, idIng);
	}
	
	@RequestMapping(value = "/getImagesIng/{idIng}", method = RequestMethod.GET)
	public List<Image> getImagesProd(@PathVariable("idIng") Long idIng) throws IOException {
		return imageService.getImagesParIng(idIng);
	}

	
	
	/********************************/
/*
@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id) throws IOException {
 
    Ingredient p = ingredientservice.getVetement(id);

  
    String imagePath = "C:/Users/MSI/images/";  

   
    Path directoryPath = Paths.get(imagePath);
    if (!Files.exists(directoryPath)) {
        Files.createDirectories(directoryPath);
    }

 
    String fileName = id + ".jpg";

   
    Path filePath = Paths.get(imagePath + fileName);
    if (Files.exists(filePath)) {
     
        String uniqueSuffix = System.currentTimeMillis() + "";  
        fileName = id + "_" + uniqueSuffix + ".jpg";
    }

  
    Files.write(Paths.get(imagePath + fileName), file.getBytes());

 
    p.setImagePath(fileName);
    ingredientservice.saveIngredient(p);

    System.out.println("Image sauvegardée à : " + imagePath + fileName);
}


@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
    Ingredient p = ingredientservice.getIngredient(id);
    Path imagePath = Paths.get(System.getProperty("user.home") + "/images/" + p.getImagePath());
    
   
    if (!Files.exists(imagePath)) {
        throw new FileNotFoundException("L'image pour l'ID " + id + " n'existe pas.");
    }
    
    return Files.readAllBytes(imagePath);
}


	
	**/
	
}
