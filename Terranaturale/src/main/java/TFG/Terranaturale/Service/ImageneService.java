package TFG.Terranaturale.Service;

import TFG.Terranaturale.Dto.ImageneDTO;
import TFG.Terranaturale.Exception.ResourceNotFoundException;
import TFG.Terranaturale.Model.Imagene;
import TFG.Terranaturale.Repository.ImageneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageneService {

    private final ImageneRepository imageneRepository;
    private final ModelMapper modelMapper;

    public ImageneService(ImageneRepository imageneRepository, ModelMapper modelMapper) {
        this.imageneRepository = imageneRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<List<ImageneDTO>> getAllImagenes() {
        List<Imagene> imagenes = imageneRepository.findAll();
        List<ImageneDTO> imageneDTOS = new ArrayList<>();
        for (Imagene imagene : imagenes) {
            ImageneDTO imageneDTO = modelMapper.map(imagene, ImageneDTO.class);
            imageneDTOS.add(imageneDTO);
        }
        return ResponseEntity.ok().body(imageneDTOS);
    }

    public ResponseEntity<ImageneDTO> getImageneById(Integer id) {
        Imagene imagene = imageneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Imagene not found with id " + id));
        return ResponseEntity.ok().body(modelMapper.map(imagene, ImageneDTO.class));
    }
}

