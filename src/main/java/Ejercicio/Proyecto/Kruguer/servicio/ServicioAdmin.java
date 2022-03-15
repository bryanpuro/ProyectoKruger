package Ejercicio.Proyecto.Kruguer.servicio;

import Ejercicio.Proyecto.Kruguer.Empleado.EmpleadoEntity;
import Ejercicio.Proyecto.Kruguer.repositorio.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Lazy
@Service
public class ServicioAdmin {
    @Autowired
    private IEmpleadoRepositorio iEmpleadoRepositorio;

    /**
     * metodo para crear un empleado.
     */
    public void saveEmpleado(EmpleadoEntity empleadoentity) {

        empleadoentity.setUsuario(empleadoentity.getCorreo());
        empleadoentity.setPass(empleadoentity.getCedula());
        iEmpleadoRepositorio.save(empleadoentity);

    }

    /**
     * metodo para listar empleados.
     */
    public List<EmpleadoEntity> findallEmpleados() {

        List<EmpleadoEntity> a = iEmpleadoRepositorio.findAll();
        a.removeIf(z -> z.getEstado().equals("0"));
        return a;
    }

    /**
     * metodo para buscar un empleado por id.
     */
    public EmpleadoEntity findByIdEmpleado(String idempleado) {
        Optional<EmpleadoEntity> em = iEmpleadoRepositorio.findById(idempleado);

        if (em.isPresent()) {
            return em.get();
        } else {
            return null;
        }

    }

    /**
     * metodo para eliminar/desactivar un empleado.
     */
    public void inectiveEmpleadoById(String idempleado) {
        if (idempleado != null) {

            EmpleadoEntity empleadoentity = findByIdEmpleado(idempleado);

            empleadoentity.setEstado("0");
            iEmpleadoRepositorio.save(empleadoentity);

        } else {
            System.out.println("El empleado con ese id no existe");
        }
    }

    /**
     * metodo para actualizar un empleado.
     */

    public void updateEmpleado(EmpleadoEntity empleadoEntity) {
        if (empleadoEntity.getIdempleado() != null) {
            EmpleadoEntity empleadoentity = new EmpleadoEntity();
            empleadoentity.setIdempleado(empleadoEntity.getIdempleado());
            empleadoentity.setCedula(empleadoEntity.getCedula());
            empleadoentity.setNombre(empleadoEntity.getNombre());
            empleadoentity.setApellido(empleadoEntity.getApellido());
            empleadoentity.setCorreo(empleadoEntity.getCorreo());
            iEmpleadoRepositorio.save(empleadoentity);
        } else {
            System.out.println("El id de empleado es incorrecto");
        }

    }

    /**
     * metodo para buscar un empleado por estado de vacuna.
     */

    public List<EmpleadoEntity> findByEstadoVacuna(String estadoVacuna) {
        return iEmpleadoRepositorio.findByEstadoVacuna(estadoVacuna);
    }

    /**
     * metodo para buscar un empleado por tipo de vacuna.
     */
    public List<EmpleadoEntity> findByTipoVacuna(String tipoVacuna) {
        if (tipoVacuna.equals("Sputnik") || tipoVacuna.equals("Pfizer") || tipoVacuna.equals("AstraZeneca") || tipoVacuna.equals("Jhonson&Jhonson")) {
            return iEmpleadoRepositorio.findByTipoVacuna(tipoVacuna);
        } else {
            System.out.printf("No existe ese tipo de vacuna");
            return null;
        }
    }

    /**
     * metodo para buscar un empleado por fecha de vacuna.
     */




    /**
     * ----------------------------------------------------------------------------------------------------
     * --------------------SERVICIOS ---- EMPLEADO---------------------------------------------------------
     * ----------------------------------------------------------------------------------------------------
     */
    public void updateDAtos(EmpleadoEntity empleado) {
        if (empleado.getIdempleado() != null) {
            EmpleadoEntity empleadoentity = findByIdEmpleado(empleado.getIdempleado());
            //empleadoentity.setIdempleado(empleado.getIdempleado());
            empleadoentity.setFechaNacimiento(empleado.getFechaNacimiento());
            empleadoentity.setDireccion(empleado.getDireccion());
            empleadoentity.setTelefono(empleado.getTelefono());
            empleadoentity.setEstadoVacuna(empleado.getEstadoVacuna());
            empleadoentity.setTipoVacuna(empleado.getTipoVacuna());
            empleadoentity.setFechaVacunacion(empleado.getFechaVacunacion());
            empleadoentity.setNumeroDosis(empleado.getNumeroDosis());
            iEmpleadoRepositorio.save(empleadoentity);
        } else {
            System.out.println("El id de empleado es incorrecto");
        }
    }




}
