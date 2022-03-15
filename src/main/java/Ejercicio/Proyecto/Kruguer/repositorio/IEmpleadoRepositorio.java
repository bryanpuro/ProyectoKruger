package Ejercicio.Proyecto.Kruguer.repositorio;

import Ejercicio.Proyecto.Kruguer.Empleado.EmpleadoEntity;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEmpleadoRepositorio extends JpaRepository<EmpleadoEntity, String> {
    /**
     * consulta para buscar empleados por estado de vacunacion.
     */
    @Query("SELECT u FROM empleadoEntity u WHERE u.estadoVacuna = ?1")
    List<EmpleadoEntity> findByEstadoVacuna(String estadoVacuna);


    /**
     * consulta para poder buscar empleados por el tipo de vacuna.
     */
    @Query("SELECT u FROM empleadoEntity u WHERE u.tipoVacuna = ?1")
    List<EmpleadoEntity> findByTipoVacuna(String tipoVacuna);

    /**
     * consulta para poder buscar empleados por fecha de vacunacion.
     */





}
