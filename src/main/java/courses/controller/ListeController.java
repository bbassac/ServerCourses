package courses.controller;

import courses.bean.Collection;
import courses.bean.Liste;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/liste")
public class ListeController extends AbstractController{



    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Liste getListe(@PathVariable("id") Long id) {
        return customRepo.getListe(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json;UTF-8")
    @ResponseBody
    public Collection addListe(@RequestBody RestListe list) {
        list.setId(null);
        Liste l = new Liste(list);
        return customRepo.ajouterListe(l);
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT,consumes = "application/json;UTF-8")
    @ResponseBody
    public Collection updateList(@RequestBody RestListe list) {
        Liste l = new Liste(list);
        return customRepo.update(l);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Collection deleteListe(@PathVariable("id") Long id) {
        return customRepo.effacerListe(id);
    }
}