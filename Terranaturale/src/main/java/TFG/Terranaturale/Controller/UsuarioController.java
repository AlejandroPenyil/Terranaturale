package TFG.Terranaturale.Controller;

import TFG.Terranaturale.Dto.UsuarioDTO;
import TFG.Terranaturale.Model.Usuario;
import TFG.Terranaturale.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Integer id) {
        UsuarioDTO usuario = usuarioService.getUsuarioById(id).getBody();
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuario) {
        return usuarioService.createOrUpdateUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDetails) {
        UsuarioDTO usuario = usuarioService.getUsuarioById(id).getBody();
        if (usuario!=null) {
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setContraseña(usuarioDetails.getContraseña());
            usuario.setCorreo(usuarioDetails.getCorreo());
            usuario.setDni(usuarioDetails.getDni());
            usuario.setRol(usuarioDetails.getRol());
            usuario.setTelefono(usuarioDetails.getTelefono());
            usuario.setDireccion(usuarioDetails.getDireccion());
            usuarioService.createOrUpdateUsuario(usuario);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}