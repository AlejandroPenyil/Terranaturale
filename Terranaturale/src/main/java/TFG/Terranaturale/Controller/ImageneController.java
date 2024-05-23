package TFG.Terranaturale.Controller;

import TFG.Terranaturale.Dto.ImageneDTO;
import TFG.Terranaturale.Service.ImageneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
public class ImageneController {

    private final ImageneService imageneService;

    @Autowired
    public ImageneController(ImageneService imageneService) {
        this.imageneService = imageneService;
    }

    @GetMapping
    public ResponseEntity<List<ImageneDTO>> getAllImagenes() {
        return imageneService.getAllImagenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageneDTO> getImageneById(@PathVariable Integer id) {
        return imageneService.getImageneById(id);
    }
}

