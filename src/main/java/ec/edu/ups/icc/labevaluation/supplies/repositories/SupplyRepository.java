package ec.edu.ups.icc.labevaluation.supplies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.icc.labevaluation.supplies.entities.SupplyEntity;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity, Long>{
    //Esta consulta verificará que no haya otro insumo con el mismoo nobmre
    boolean existsByNameIgnoreCaseAndDeletedFalse(String name);
    List<SupplyEntity> findByActiveTrueAndDeletedFalseAndQuantityLessThanOrderByQuantityAsc(Integer maxQuantity);
}
