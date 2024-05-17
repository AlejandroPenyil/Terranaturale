package TFG.Terranaturale.Controller;

import TFG.Terranaturale.Dto.FacturaDto;
import TFG.Terranaturale.Service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("factura")
public class FacturaController {
    FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public ResponseEntity<List<FacturaDto>> factura() {
        return facturaService.getFacturas();
    }
}
