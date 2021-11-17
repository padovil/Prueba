package sistemainformacion.registroproyectos.Controller;

import org.springframework.web.bind.annotation.RestController;

import sistemainformacion.registroproyectos.Model.TipoFinanciacion;
import sistemainformacion.registroproyectos.Service.TipoFinanciacionService;

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
@RequestMapping("/investigacion/TipoFinanciacion")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//responde peticiones desde cualquier lado
public class TipoFinanciacionController {
    
    @Autowired
    private TipoFinanciacionService TipoFinanciacionService;

    @GetMapping("/all")
    public List<TipoFinanciacion> getTipoFinanciacions(){
        return TipoFinanciacionService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<TipoFinanciacion> getTipoFinanciacion(@PathVariable("id") int id){//toma como variable lo que llega en la ruta
        return TipoFinanciacionService.getTipoFinanciacion(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public TipoFinanciacion save(@RequestBody TipoFinanciacion TipoFinanciacion){ //es pra  que los parametros del json lleguen bien como un modelo
        return TipoFinanciacionService.save(TipoFinanciacion);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public TipoFinanciacion update(@RequestBody TipoFinanciacion TipoFinanciacion){ //es pra  que los parametros del json lleguen bien como un modelo
        return TipoFinanciacionService.update(TipoFinanciacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 204
    public String deleteTipoFinanciacion(@PathVariable("id") int id){
        TipoFinanciacionService.deleteTipoFinanciacion(id);
        return "redirect:/";
    }
}
