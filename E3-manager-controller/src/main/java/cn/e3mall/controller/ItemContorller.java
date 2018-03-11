package cn.e3mall.controller;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemContorller {

    @Autowired
    public  ItemService itemService;




    @RequestMapping("/list/{id}")
    @ResponseBody
    public TbItem getItemById(@PathVariable long id){
        TbItem tbItem=itemService.getItemById(id);

        return tbItem;
    }

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    @RequestMapping("/item/list")
    @ResponseBody
     public DataGridResult getItemList(Integer page,Integer rows){
        DataGridResult tbItems =  itemService.getItemList(page,rows);
            return tbItems;
        }



    @RequestMapping("/item/save")
    @ResponseBody
    public E3Result saveItem(TbItem tbItem, String desc){
        E3Result result=itemService.saveItem(tbItem,desc);
        return  result;
    }
    @RequestMapping("item/desc")
    @ResponseBody
    public TbItem queryItem(@PathVariable long id){
        TbItem id1 = itemService.getItemById(id);
        return id1;
    }


}
