package cn.e3mall.service;

import cn.e3mall.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

     public  TbItem getItemById(long id);

     DataGridResult getItemList(int page, int rows);

}
