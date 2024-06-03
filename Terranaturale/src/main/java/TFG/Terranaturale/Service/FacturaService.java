package TFG.Terranaturale.Service;

import TFG.Terranaturale.Dto.FacturaDTO;
import TFG.Terranaturale.Model.Factura;
import TFG.Terranaturale.Repository.FacturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {
    FacturaRepository facturaRepository;
    ModelMapper mapper;

    public FacturaService(FacturaRepository facturaRepository, ModelMapper mapper) {
        this.facturaRepository = facturaRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<List<FacturaDTO>> getFacturas() {
        List<Factura> facturas = facturaRepository.findAll();
        List<FacturaDTO> facturasDto = new ArrayList<>();
        for (Factura factura : facturas) {
            FacturaDTO facturaDto = mapper.map(factura, FacturaDTO.class);
        }

        return ResponseEntity.ok().body(facturasDto);
    }
}
