package com.cleanarchitecturebase.model.request;

import com.cleanarchitecturebase.model.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    private String nombre;
    private String apellido;
    private String correo;
    private String nombreUsuario;
    private String clave;

}
