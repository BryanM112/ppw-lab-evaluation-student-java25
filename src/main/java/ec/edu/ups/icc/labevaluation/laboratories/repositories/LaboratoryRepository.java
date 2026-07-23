package ec.edu.ups.icc.labevaluation.laboratories.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.ups.icc.labevaluation.laboratories.entities.LaboratoryEntity;
public interface LaboratoryRepository extends JpaRepository<LaboratoryEntity, Long> {
    //modificamos el método por el nuevo dado en el html de la prueba con un botón
    List<LaboratoryEntity> findByCampus_IdAndCapacityGreaterThanEqualAndActiveTrueAndDeletedFalseAndCampus_ActiveTrueAndCampus_DeletedFalseOrderByCapacityDesc(Long campusId, Integer minCapacity);
}
