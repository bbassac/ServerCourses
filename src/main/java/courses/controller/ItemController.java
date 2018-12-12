package courses.controller;

import courses.bean.Item;
import courses.bean.Liste;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController extends AbstractController{



    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Liste getItemsFromList(@RequestBody RestItem item) {
        item.setId(null);
        Item i = new Item(item);
        return customRepo.addItemToList(item.getListId(), i);
    }


}