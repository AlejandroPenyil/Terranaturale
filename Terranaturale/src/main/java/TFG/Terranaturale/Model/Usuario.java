package TFG.Terranaturale.Model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
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

}