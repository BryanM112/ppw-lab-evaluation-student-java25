package ec.edu.ups.icc.labevaluation.supplies.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.ups.icc.labevaluation.supplies.dtos.CreateSupplyDto;
import ec.edu.ups.icc.labevaluation.supplies.dtos.SupplyResponseDto;
import ec.edu.ups.icc.labevaluation.supplies.dtos.UpdateSupplyQuantityDto;
import ec.edu.ups.icc.labevaluation.supplies.entities.SupplyEntity;
import ec.edu.ups.icc.labevaluation.supplies.exceptions.SuppleConflictException;
import ec.edu.ups.icc.labevaluation.supplies.exceptions.SupplyNotFoundException;
import ec.edu.ups.icc.labevaluation.supplies.mappers.SupplyMapper;
import ec.edu.ups.icc.labevaluation.supplies.repositories.SupplyRepository;


@Service
@Transactional
public class SupplySerciveImpl implements SupplyService{

    private final SupplyRepository supplyRepository;
    
    public SupplySerciveImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    @Override
    public SupplyResponseDto create(CreateSupplyDto dto) {
        String nombre = dto.name().trim();
        boolean nombreExiste = supplyRepository.existsByNameIgnoreCaseAndDeletedFalse(nombre);
        if(nombreExiste){
            throw new SuppleConflictException("Ya existe ese nombre");
        }

        SupplyEntity entity = SupplyMapper.toEntity(dto);
        entity.setName(nombre);
        entity.setActive(true);

        SupplyEntity guardarEntity = supplyRepository.save(entity);

        return SupplyMapper.toResponse(guardarEntity);
    }

    @Override
    public List<SupplyResponseDto> findLowStock(Integer maxQuantity) {
            return supplyRepository.findByActiveTrueAndDeletedFalseAndQuantityLessThanOrderByQuantityAsc(maxQuantity)
            .stream().map(SupplyMapper::toResponse).toList();
    }

    @Override
    public SupplyResponseDto updateQuantity(Long id, UpdateSupplyQuantityDto dto) {
        SupplyEntity entity = supplyRepository.findByIdAndDeletedFalse(id)
        .orElseThrow(() -> new SupplyNotFoundException(
            "No se encontró el insumo con id: " + id
        ));

        entity.setQuantity(dto.quantity());

        SupplyEntity updatedEntity = supplyRepository.save(entity);

        return SupplyMapper.toResponse(updatedEntity);
       
    }

    
    
}
