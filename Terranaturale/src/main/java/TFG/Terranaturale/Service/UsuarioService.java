package TFG.Terranaturale.Service;

import TFG.Terranaturale.Dto.UsuarioDTO;
import TFG.Terranaturale.Model.Usuario;
import TFG.Terranaturale.Repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository,ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
            usuarioDTOS.add(usuarioDTO);
        }


        return ResponseEntity.ok().body(usuarioDTOS);
    }

    public ResponseEntity<UsuarioDTO> getUsuarioById(Integer id) {
        return ResponseEntity.ok().body(modelMapper.map(usuarioRepository.findById(id), UsuarioDTO.class));
    }

    public ResponseEntity<UsuarioDTO> createOrUpdateUsuario(UsuarioDTO usuario) {
        Usuario usuario1 = modelMapper.map(usuario, Usuario.class);
        return ResponseEntity.ok().body(modelMapper.map(usuarioRepository.save(usuario1), UsuarioDTO.class));
    }

    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}