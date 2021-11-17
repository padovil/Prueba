package sistemainformacion.registroproyectos.Controller;

import org.springframework.web.bind.annotation.RestController;

import sistemainformacion.registroproyectos.Model.TipoProyecto;
import sistemainformacion.registroproyectos.Service.TipoProyectoService;

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
@RequestMapping("/investigacion/TipoProyecto")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//responde peticiones desde cualquier lado
public class TipoProyectoController {
    
    @Autowired
    private TipoProyectoService TipoProyectoService;

    @GetMapping("/all")
    public List<TipoProyecto> getTipoProyectos(){
        return TipoProyectoService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<TipoProyecto> getTipoProyecto(@PathVariable("id") int id){//toma como variable lo que llega en la ruta
        return TipoProyectoService.getTipoProyecto(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public TipoProyecto save(@RequestBody TipoProyecto TipoProyecto){ //es pra  que los parametros del json lleguen bien como un modelo
        return TipoProyectoService.save(TipoProyecto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public TipoProyecto update(@RequestBody TipoProyecto TipoProyecto){ //es pra  que los parametros del json lleguen bien como un modelo
        return TipoProyectoService.update(TipoProyecto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 204
    public String deleteTipoProyecto(@PathVariable("id") int id){
        TipoProyectoService.deleteTipoProyecto(id);
        return "redirect:/";
    }
}
