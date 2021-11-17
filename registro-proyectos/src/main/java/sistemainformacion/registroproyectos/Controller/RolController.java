package sistemainformacion.registroproyectos.Controller;

import org.springframework.web.bind.annotation.RestController;

import sistemainformacion.registroproyectos.Model.Rol;
import sistemainformacion.registroproyectos.Service.RolService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/investigacion/Rol")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//responde peticiones desde cualquier lado
public class RolController {
    
    @Autowired
    private RolService RolService;

    @GetMapping("/all")
    public List<Rol> getRols(){
        return RolService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<Rol> getRol(@PathVariable("id") int id){//toma como variable lo que llega en la ruta
        return RolService.getRol(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Rol save(@RequestBody Rol Rol){ //es pra  que los parametros del json lleguen bien como un modelo
        return RolService.save(Rol);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Rol update(@RequestBody Rol Rol){ //es pra  que los parametros del json lleguen bien como un modelo
        return RolService.update(Rol);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 204
    public String deleteRol(@PathVariable("id") int id){
        RolService.deleteRol(id);
        return "redirect:/";
    }
}
