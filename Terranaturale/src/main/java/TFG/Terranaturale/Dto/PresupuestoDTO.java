package TFG.Terranaturale.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class PresupuestoDTO {
    private Integer id;
    private Instant fechalEnvio;
    private Instant fechaAceptado;
    private Boolean rechazado;
    private Integer idJardin;
    private String ubicacion;
}
