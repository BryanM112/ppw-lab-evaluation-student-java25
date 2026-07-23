package ec.edu.ups.icc.labevaluation.users.mappers;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ec.edu.ups.icc.labevaluation.users.dtos.UserResponseDto;
import ec.edu.ups.icc.labevaluation.users.entities.UserEntity;
public final class UserMapper {
    private UserMapper() {}
    //Ahora transformamos los datos entity a dto. Agregamos los campos age, active, roles. Agregamos roles con un set
    public static UserResponseDto toResponse(UserEntity entity){
        Set<String> roles = entity.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet());
        return new UserResponseDto(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getAge(), entity.isActive(), roles);
    }
}
