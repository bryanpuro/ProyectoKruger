package Ejercicio.Proyecto.Kruguer.controlador;

import Ejercicio.Proyecto.Kruguer.Empleado.EmpleadoEntity;
import Ejercicio.Proyecto.Kruguer.servicio.ServicioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleado")
public class ControladorEmpleado {

    @Autowired
    private ServicioAdmin service;

    @PostMapping("/updateDatosEmpleado")
    public String updateDatos(@RequestBody EmpleadoEntity idempleado){
        service.updateDAtos(idempleado);
        return  "datos actualizados";
    }
}
