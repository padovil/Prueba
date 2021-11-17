package sistemainformacion.registroproyectos.Controller;

import org.springframework.web.bind.annotation.RestController;

import sistemainformacion.registroproyectos.Model.RolesSistema;
import sistemainformacion.registroproyectos.Service.RolesSistemaService;

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
@RequestMapping("/investigacion/RolesSistema")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//responde peticiones desde cualquier lado
public class RolesSistemaController {
    
    @Autowired
    private RolesSistemaService RolesSistemaService;

    @GetMapping("/all")
    public List<RolesSistema> getRolesSistemas(){
        return RolesSistemaService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<RolesSistema> getRolesSistema(@PathVariable("id") int id){//toma como variable lo que llega en la ruta
        return RolesSistemaService.getRolesSistema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public RolesSistema save(@RequestBody RolesSistema RolesSistema){ //es pra  que los parametros del json lleguen bien como un modelo
        return RolesSistemaService.save(RolesSistema);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public RolesSistema update(@RequestBody RolesSistema RolesSistema){ //es pra  que los parametros del json lleguen bien como un modelo
        return RolesSistemaService.update(RolesSistema);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 204
    public String deleteRolesSistema(@PathVariable("id") int id){
        RolesSistemaService.deleteRolesSistema(id);
        return "redirect:/";
    }
}
