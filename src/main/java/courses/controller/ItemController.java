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
    @RequestMapping(value = "/{listId}/{itemId}",method = RequestMethod.DELETE,consumes = "application/json;UTF-8")
    @ResponseBody
    public Liste removeItemsFromList(@PathVariable("listId") Long listId, @PathVariable("itemId") Long itemId) {
        return customRepo.removeItemToList(listId, itemId);
    }

}