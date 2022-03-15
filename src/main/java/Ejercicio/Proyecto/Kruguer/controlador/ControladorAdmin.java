package Ejercicio.Proyecto.Kruguer.controlador;

import Ejercicio.Proyecto.Kruguer.Empleado.EmpleadoEntity;
import Ejercicio.Proyecto.Kruguer.servicio.ServicioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class ControladorAdmin {

    @Autowired
    private ServicioAdmin service;

    /**
     * WS para crear un empleado.
     */
    @PostMapping("/create")
    public String createCliente(@RequestBody @Valid EmpleadoEntity empleadoEntity, BindingResult result) {
        if (result.hasErrors()) {
            String error = "revise los parametros ingresados";
            return error;
        }
        service.saveEmpleado(empleadoEntity);
        return "true";
    }

    /**
     * WS para listar todos los empleados.
     */
    @GetMapping("/findAllEmpleados")
    public List<EmpleadoEntity> findallEmpleados() {
        return service.findallEmpleados();
    }

    /**
     * WS para buscar un empleado.
     */
    @GetMapping("/findEmpleadoById")
    public EmpleadoEntity findByIdEmpleado(@RequestBody String idempleado) {
        return service.findByIdEmpleado(idempleado);
    }

    /**
     * WS para eliminar un empleado.
     */
    @PostMapping("/eliminarEmpleadoById")
    public String inactiveEmpleadoById(@RequestBody String idempleado) {
        service.inectiveEmpleadoById(idempleado);
        return "registro eliminado";
    }


    /**
     * WS para actualizar un empleado.
     */
    @PostMapping("/updateEmpleado")
    public String updateEmpleado(@RequestBody EmpleadoEntity idempleado){
        service.updateEmpleado(idempleado);
        return "Registro Actualizado";
    }


    /**
     * WS para buscar un empleado por estado de vacuna.
     */
    @PostMapping("/findByEstadoVacuna")
    public List<EmpleadoEntity> findbyEstadoVacuna(@RequestBody String estadoVacuna){
        return service.findByEstadoVacuna(estadoVacuna);
    }


    /**
     * WS para buscar un empleado por tipo de vacuna.
     */
    @PostMapping("/findByTipoVacuna")
    public List<EmpleadoEntity> findByTipoVacuna (@RequestBody String tipoVacuna){
        return  service.findByTipoVacuna(tipoVacuna);

    }

    /**
     * WS para buscar un empleado por fecha de vacuna.
     */



}
