package Ejercicio.Proyecto.Kruguer.Empleado;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Entity Empleado.
 *
 * @author Bryan.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EMPLEADO")
public class EmpleadoEntity {
    private static final long serialVersionUID = -1365828486478167916L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_EMPLEADO", nullable = false)
    private String idempleado;

    @Column(name = "CEDULA")
    @Size(max = 10,min= 10)
    @Pattern(regexp = "[0-9]+", message = "La cedula debe contener no mas de 10 digitos")
    private String cedula;

    @Column(name = "NOMBRE")
    @Pattern(regexp = "[A-Za-z]+", message = "El nombre del empleado solo puede tener letras")
    private String nombre;

    @Column(name = "APELLIDO")
    @Pattern(regexp = "[A-Za-z]+", message = "El nombre del empleado solo puede tener letras")
    private String apellido;

    @Column(name = "CORREO")
    @Email(message = "El correo debe ser valido")
    private String correo;


    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "ESTADO_VACUNA")
    private String estadoVacuna;


    @Column(name = "TIPO_VACUNA")
    private String tipoVacuna;

    @Column(name = "FECHA_VACUNACION")
    private Date fechaVacunacion;

    @Column(name = "NUMERO_DOSIS")
    private String numeroDosis;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "PASS")
    private String pass;
    @Column(name = "ESTADO")
    private String estado;


}
