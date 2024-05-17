package TFG.Terranaturale.Model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "presupuestos")
public class Presupuesto {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fechal_envio", nullable = false)
    private Instant fechalEnvio;

    @Column(name = "fecha_aceptado")
    private Instant fechaAceptado;

    @Column(name = "rechazado", nullable = false)
    private Boolean rechazado = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_jardin", nullable = false)
    private Jardine idJardin;

    @Column(name = "ubicacion", nullable = false, length = 100)
    private String ubicacion;

}