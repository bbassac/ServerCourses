package courses.controller;

import courses.bean.Item;
import courses.bean.Liste;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController extends AbstractController{



    @CrossOrigin
    @RequestMapping(value = "/{listId}",method = RequestMethod.POST,consumes = "application/json;UTF-8")
    @ResponseBody
    public Liste addItemToList(@PathVariable("listId") Long listId, @RequestBody RestItem item) {
        item.setId(null);
        Item i = new Item(item);
        return customRepo.addItemToList(listId, i);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT,consumes = "application/json;UTF-8")
    @ResponseBody
    public Liste updateItem(@RequestBody RestItem item) {

        Item i = new Item(item);
        return customRepo.updateItem(i);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public Liste removeItemsFromList(@RequestBody RestItem item) {
        Item i = new Item(item);
        return customRepo.removeItemToList(item.getListId(), i);
    }

}