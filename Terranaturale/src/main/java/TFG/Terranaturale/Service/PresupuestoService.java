package TFG.Terranaturale.Service;

import TFG.Terranaturale.Dto.PresupuestoDTO;
import TFG.Terranaturale.Exception.ResourceNotFoundException;
import TFG.Terranaturale.Model.Jardine;
import TFG.Terranaturale.Model.Presupuesto;
import TFG.Terranaturale.Repository.PresupuestoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PresupuestoService {

    private final PresupuestoRepository presupuestoRepository;

    private final ModelMapper modelMapper;

    public PresupuestoService(PresupuestoRepository presupuestoRepository, ModelMapper modelMapper) {
        this.presupuestoRepository = presupuestoRepository;
        this.modelMapper = modelMapper;
    }

    public List<PresupuestoDTO> findAll() {
        return presupuestoRepository.findAll().stream()
                .map(presupuesto -> modelMapper.map(presupuesto, PresupuestoDTO.class))
                .collect(Collectors.toList());
    }

    public PresupuestoDTO findById(Integer id) {
        Presupuesto presupuesto = presupuestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Presupuesto not found"));
        return modelMapper.map(presupuesto, PresupuestoDTO.class);
    }

    public PresupuestoDTO save(PresupuestoDTO presupuestoDTO) {
        Presupuesto presupuesto = modelMapper.map(presupuestoDTO, Presupuesto.class);
        Presupuesto savedPresupuesto = presupuestoRepository.save(presupuesto);
        return modelMapper.map(savedPresupuesto, PresupuestoDTO.class);
    }

    public PresupuestoDTO update(Integer id, PresupuestoDTO presupuestoDTO) {
        Presupuesto presupuesto = presupuestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Presupuesto not found"));

        presupuesto.setFechalEnvio(presupuestoDTO.getFechalEnvio());
        presupuesto.setFechaAceptado(presupuestoDTO.getFechaAceptado());
        presupuesto.setRechazado(presupuestoDTO.getRechazado());
        presupuesto.setIdJardin(modelMapper.map(presupuestoDTO.getIdJardin(), Jardine.class));
        presupuesto.setUbicacion(presupuestoDTO.getUbicacion());

        Presupuesto updatedPresupuesto = presupuestoRepository.save(presupuesto);
        return modelMapper.map(updatedPresupuesto, PresupuestoDTO.class);
    }

    public void delete(Integer id) {
        Presupuesto presupuesto = presupuestoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Presupuesto not found"));
        presupuestoRepository.delete(presupuesto);
    }
}
