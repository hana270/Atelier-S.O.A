package projet.spring.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.spring.entities.Image;
public interface ImageRepository extends JpaRepository<Image, Long> {
	@Query("SELECT i FROM Image i JOIN i.ingredient ing WHERE ing.id = :id")
	List<Image> findImagesByIngredientId(@Param("id") Long id);
}

