package TFG.Terranaturale.Service;

import TFG.Terranaturale.Dto.FacturaDto;
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

    public ResponseEntity<List<FacturaDto>> getFacturas() {
        List<Factura> facturas = facturaRepository.findAll();
        List<FacturaDto> facturasDto = new ArrayList<>();
        for (Factura factura : facturas) {
            FacturaDto facturaDto = mapper.map(factura, FacturaDto.class);
        }

        return ResponseEntity.ok().body(facturasDto);
    }
}
