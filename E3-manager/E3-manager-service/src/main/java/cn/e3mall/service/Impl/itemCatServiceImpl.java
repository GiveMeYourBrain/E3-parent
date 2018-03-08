package cn.e3mall.service.Impl;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class itemCatServiceImpl implements ItemCatService  {

    @Autowired
    private TbItemCatMapper itemCatMapper;



    @Override
    public List<EasyUITreeNode> getCatList(long parentId) {
        // 1、根据parentId查询节点列表
        TbItemCatExample tbItemCatExample= new TbItemCatExample();

        //设置查询条件
        Criteria criteria=tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);

         List<TbItemCat> list=itemCatMapper.selectByExample(tbItemCatExample);

        //转换为esayUItreeNode列表
        List<EasyUITreeNode> resultList =new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
           EasyUITreeNode node= new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        return resultList;
    }
}
