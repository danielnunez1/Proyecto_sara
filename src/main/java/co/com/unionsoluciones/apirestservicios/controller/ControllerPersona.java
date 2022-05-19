package co.com.unionsoluciones.apirestservicios.controller;

import co.com.unionsoluciones.apirestservicios.dtos.PersonaDTO;
import co.com.unionsoluciones.apirestservicios.dtos.PersonaInsertDTO;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rblanco on 27/04/22
 **/
@RestController
@CrossOrigin(value = {"http://localhost:4200"})
@RequestMapping("/requieretoken/persona")
public class ControllerPersona {

    @PreAuthorize("hasRole('USUARIO')")
    @GetMapping()
    public List<PersonaDTO> getPersonas(){
        List<PersonaDTO> lista = new ArrayList<>();
        lista.add(new PersonaDTO(String.valueOf( System.currentTimeMillis() ),"Rafael","Blanco2"));
        lista.add( new PersonaDTO(String.valueOf( System.currentTimeMillis() ),"Rafael","Blanco3"));
        return lista;
    }

    @PostMapping
    public PersonaDTO addPersona(@RequestBody PersonaInsertDTO personaInsertDTO){

        Assert.notNull(personaInsertDTO, "Objeto persona NULO");
        Assert.hasText(personaInsertDTO.getNombre(), "Atributo nombre NULO/VACIO");
        Assert.hasText(personaInsertDTO.getApellido(), "Atributo apellido NULO/VACIO");

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId( String.valueOf( System.currentTimeMillis() ) );
        personaDTO.setNombre(personaInsertDTO.getNombre());
        personaDTO.setApellido(personaInsertDTO.getApellido());

        return personaDTO;
    }

    @GetMapping("/{id}")
    public PersonaDTO getPersona(@PathVariable String id){

        return new PersonaDTO( id,"Rafael","Blanco2");

    }

}
