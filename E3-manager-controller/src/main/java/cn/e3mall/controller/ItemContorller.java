package cn.e3mall.controller;

import cn.e3mall.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    private Integer page;
    private Integer rows;
    @RequestMapping("/item/list")
    @ResponseBody
     public DataGridResult getItemList(Integer page,Integer rows){
        DataGridResult tbItems =  itemService.getItemList(page,rows);
            return tbItems;
        }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
