package cn.e3mall.service;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

     public  TbItem getItemById(long id);

     DataGridResult getItemList(int page, int rows);

     public E3Result saveItem(TbItem tbItem,String desc);

}
