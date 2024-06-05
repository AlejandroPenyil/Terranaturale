package TFG.Terranaturale.Service;

import TFG.Terranaturale.Dto.ImageneDTO;
import TFG.Terranaturale.Dto.UsuarioDTO;
import TFG.Terranaturale.Exception.ResourceNotFoundException;
import TFG.Terranaturale.Model.Imagene;
import TFG.Terranaturale.Model.Usuario;
import TFG.Terranaturale.Repository.ImageneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
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

    public ResponseEntity<List<ImageneDTO>> getImageneByClientId(UsuarioDTO userDto) {
        Usuario user = modelMapper.map(userDto, Usuario.class);
        List<Imagene> imageneList = imageneRepository.findByIdUsuario(user);

        List<ImageneDTO> imageneDTOS = new ArrayList<>();
        for (Imagene imagene : imageneList) {
            imageneDTOS.add(modelMapper.map(imagene, ImageneDTO.class));
        }
        return ResponseEntity.ok().body(imageneDTOS);
    }

    public void createImagene(ImageneDTO imagenDTO) {
        Imagene imagene = modelMapper.map(imagenDTO, Imagene.class);
        imagene.setFecha(Instant.now());
        imageneRepository.save(imagene);
    }

    public ResponseEntity<List<ImageneDTO>> getImageneByInvitado() {
        List<Imagene> imagenes = imageneRepository.findAll();
        List<ImageneDTO> imageneDTOS = new ArrayList<>();
        for (Imagene imagene : imagenes) {
            if(imagene.getIdUsuario().getRol().equals("GUEST")) {
                ImageneDTO imageneDTO = modelMapper.map(imagene, ImageneDTO.class);
                imageneDTOS.add(imageneDTO);
            }
        }
        return ResponseEntity.ok().body(imageneDTOS);
    }
}

