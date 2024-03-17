package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RestController
@Tag(name = "Response Estimate", description = "Response Estimate API")
@RequestMapping("/api/favorites")
public class FavoritesController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getFavoritesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok("ok");
    }

    @PostMapping
    public ResponseEntity<?> createFavorite(@RequestBody Favorite favorite) {
        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteFavoritesByUserId(@PathVariable Long userId) {
            return ResponseEntity.ok("Favorites deleted successfully");

    }
}
