package TFG.Terranaturale.Model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "`Contraseña`", nullable = false, length = 100)
    private String contraseña;

    @Column(name = "Correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "DNI", nullable = false, length = 100)
    private String dni;

    @Lob
    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol));
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}