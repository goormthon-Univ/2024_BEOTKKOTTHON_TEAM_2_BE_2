package muckkitlist_spring.muckkitlist_spring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@Tag(name = "Response 3", description = "Response Estimate API")

@RequestMapping("/api/restaurants")
public class RestaurantController {

    @GetMapping
    public ResponseEntity<?> getAllRestaurants() {
        return ResponseEntity.ok("restaurants");
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long restaurantId) {
            return ResponseEntity.ok("엥");
    }
}
