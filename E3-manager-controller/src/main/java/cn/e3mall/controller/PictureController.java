package cn.e3mall.controller;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PictureController {

    @Value("${image.server.url}")
    private String IMAGE_SERVER_URL;

    @RequestMapping(value = "/pic/upload", produces= MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
    public String uploadPicture(MultipartFile uploadFile){
        /*取文件原始文件扩展名*/
        String orginalFilename=uploadFile.getOriginalFilename();
        String extName =orginalFilename.substring(orginalFilename.lastIndexOf(".")+1);
        /*创建一个fastdfs的酷虎端*/
        try {
            FastDFSClient fastDFSClient=new FastDFSClient("classpath:conf/client.conf");
            //执行上传处理
           String path= fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
            //4、拼接返回的url和ip地址，拼装成完整的url
            String url = IMAGE_SERVER_URL + path;
            //5、返回map
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            return JsonUtils.objectToJson(result);

        } catch (Exception e) {
            e.printStackTrace();
            //5、返回map
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return JsonUtils.objectToJson(result);
        }

    }



}
