package sistemainformacion.registroproyectos.Controller;

import org.springframework.web.bind.annotation.RestController;

import sistemainformacion.registroproyectos.Model.ProyectosDocencia;
import sistemainformacion.registroproyectos.Service.ProyectosDocenciaService;

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
@RequestMapping("/investigacion/ProyectosDocencia")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//responde peticiones desde cualquier lado
public class ProyectosDocenciaController {
    
    @Autowired
    private ProyectosDocenciaService ProyectosDocenciaService;

    @GetMapping("/all")
    public List<ProyectosDocencia> getProyectosDocencias(){
        return ProyectosDocenciaService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<ProyectosDocencia> getProyectosDocencia(@PathVariable("id") int id){//toma como variable lo que llega en la ruta
        return ProyectosDocenciaService.getProyectosDocencia(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public ProyectosDocencia save(@RequestBody ProyectosDocencia ProyectosDocencia){ //es pra  que los parametros del json lleguen bien como un modelo
        return ProyectosDocenciaService.save(ProyectosDocencia);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public ProyectosDocencia update(@RequestBody ProyectosDocencia ProyectosDocencia){ //es pra  que los parametros del json lleguen bien como un modelo
        return ProyectosDocenciaService.update(ProyectosDocencia);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 204
    public String deleteProyectosDocencia(@PathVariable("id") int id){
        ProyectosDocenciaService.deleteProyectosDocencia(id);
        return "redirect:/";
    }
}
