package co.com.unionsoluciones.apirestservicios.controller;

import co.com.unionsoluciones.apirestservicios.dtos.ErrorDTO;
import co.com.unionsoluciones.apirestservicios.dtos.NominaEmpleadoDTO;
import co.com.unionsoluciones.apirestservicios.dtos.UsuarioInsertDTO;
import co.com.unionsoluciones.apirestservicios.models.UsuarioModel;
import co.com.unionsoluciones.apirestservicios.mybatis.mapper.SaraMapper;
import co.com.unionsoluciones.apirestservicios.services.ServiceUsuario;
import co.com.unionsoluciones.apirestservicios.services.ServicioSara;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rblanco on 29/04/22
 **/
@RestController
@CrossOrigin(value = {"http://localhost:4200"})
@RequestMapping("/requieretoken/usuario")
public class ControllerUsuario {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ServiceUsuario serviceUsuario;

    @Autowired
    private ServicioSara servicioSara;

    @GetMapping()
    private List<UsuarioModel> getUsuarios(){
        return serviceUsuario.getUsuarios();
    }

    @PreAuthorize("hasRole('ROOT')")
    @GetMapping("/{limInferior}/{limSuperior}")
    public ResponseEntity myQueryByIdUsuarioHijo(@PathVariable Integer limInferior, @PathVariable Integer limSuperior){
        try {

            List<UsuarioModel> lista = serviceUsuario.myQueryByIdUsuarioHijo(limInferior, limSuperior);
            return new ResponseEntity<>( lista , HttpStatus.OK);

        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>(
                    new ErrorDTO(e.getMessage(), e.getMessage())
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idd}")
    public UsuarioModel getUsuario(@PathVariable Integer idd){
        return serviceUsuario.getUsuario(idd);
    }


    @GetMapping("/empresa")
    public List<NominaEmpleadoDTO> getNominasEmp(){
        return servicioSara.consultarNomina();
    }

    @GetMapping("/buscarpornombre/{nombre}")
    public UsuarioModel getUsuario(@PathVariable String nombre){
        return serviceUsuario.myQueryByNombre(nombre);
    }

    @PostMapping("/nuevo")
    public UsuarioModel nuevoUsuario(@RequestBody UsuarioInsertDTO usuarioInsertDTO){

        Assert.notNull(usuarioInsertDTO, "Objeto usuario NULO");
        Assert.hasText(usuarioInsertDTO.getNombre(), "Atributo nombre NULO/VACIO");
        //Assert.notNull(usuarioInsertDTO.getSalario(), "Atributo salario NULO/VACIO");

        return serviceUsuario.insert(usuarioInsertDTO);
    }
}
