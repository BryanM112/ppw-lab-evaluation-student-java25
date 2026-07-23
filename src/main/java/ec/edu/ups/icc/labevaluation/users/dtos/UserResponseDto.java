package ec.edu.ups.icc.labevaluation.users.dtos;

import java.util.Set;

//agregamos los campos que nos piden y que se imprimirán en Bruno
public record UserResponseDto(Long id, String name, String email, Integer age, boolean active, Set<String> roles) {}
