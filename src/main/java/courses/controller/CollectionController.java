package courses.controller;

import courses.bean.Collection;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collection")
public class CollectionController extends AbstractController{


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection getCollections() {

        return customRepo.getCollection();
    }

}