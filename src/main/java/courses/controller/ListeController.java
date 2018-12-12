package courses.controller;

import courses.bean.Collection;
import courses.bean.Liste;
import courses.bean.RestListe;
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
    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public Collection addListe(@RequestBody RestListe l) {
        Liste list = new Liste(l);
        list.setId(null);
        return customRepo.ajouterListe(list);
    }


    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public Collection updateList(@RequestBody RestListe l) {
        Liste list = new Liste(l);
        return customRepo.update(list);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Collection deleteListe(@PathVariable("id") Long id) {
        return customRepo.effacerListe(id);
    }
}