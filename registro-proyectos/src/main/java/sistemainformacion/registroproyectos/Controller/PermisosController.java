package sistemainformacion.registroproyectos.Controller;

import org.springframework.web.bind.annotation.RestController;

import sistemainformacion.registroproyectos.Model.Permisos;
import sistemainformacion.registroproyectos.Service.PermisosService;

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
@RequestMapping("/investigacion/Permisos")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//responde peticiones desde cualquier lado
public class PermisosController {
    
    @Autowired
    private PermisosService PermisosService;

    @GetMapping("/all")
    public List<Permisos> getPermisoss(){
        return PermisosService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<Permisos> getPermisos(@PathVariable("id") int id){//toma como variable lo que llega en la ruta
        return PermisosService.getPermisos(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Permisos save(@RequestBody Permisos Permisos){ //es pra  que los parametros del json lleguen bien como un modelo
        return PermisosService.save(Permisos);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Permisos update(@RequestBody Permisos Permisos){ //es pra  que los parametros del json lleguen bien como un modelo
        return PermisosService.update(Permisos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 204
    public String deletePermisos(@PathVariable("id") int id){
        PermisosService.deletePermisos(id);
        return "redirect:/";
    }
}
