package sistemainformacion.registroproyectos.Controller;

import org.springframework.web.bind.annotation.RestController;

import sistemainformacion.registroproyectos.Model.AsociadosProyecto;
import sistemainformacion.registroproyectos.Service.AsociadosProyectoService;

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
@RequestMapping("/investigacion/AsociadosProyecto")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//responde peticiones desde cualquier lado
public class AsociadosProyectoController {
    
    @Autowired
    private AsociadosProyectoService asociadosProyectoService;

    @GetMapping("/all")
    public List<AsociadosProyecto> getAsociadosProyectos(){
        return asociadosProyectoService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<AsociadosProyecto> getAsociadosProyecto(@PathVariable("id") int id){//toma como variable lo que llega en la ruta
        return asociadosProyectoService.getAsociadosProyecto(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public AsociadosProyecto save(@RequestBody AsociadosProyecto asociadosProyecto){ //es pra  que los parametros del json lleguen bien como un modelo
        return asociadosProyectoService.save(asociadosProyecto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public AsociadosProyecto update(@RequestBody AsociadosProyecto asociadosProyecto){ //es pra  que los parametros del json lleguen bien como un modelo
        return asociadosProyectoService.update(asociadosProyecto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 204
    public String deleteAsociadosProyecto(@PathVariable("id") int id){
        asociadosProyectoService.deleteAsociadosProyecto(id);
        return "redirect:/";
    }
}
