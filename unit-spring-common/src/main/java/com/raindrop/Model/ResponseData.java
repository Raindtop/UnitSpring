package com.raindrop.Model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/*
 * @Description TODO 格式化返回值
 * @Author Raindrop
 * @Date 2019/10/22
 */
@Data
public class ResponseData implements Serializable {

    /**
     * 返回值
     */
    private String success = "TRUE";

    /**
     * 返回代码
     */
    private String code = "Y-10001";

    /**
     * 返回信息
     */
    private String message = "";

    /**
     * 数据
     */
    private JSONObject data = new JSONObject();

    /**
     * 添加数据
     * @param key
     * @param object
     * @return
     */
    public ResponseData addData(String key, Object object){
        this.data.put(key, object);
        return this;
    }

    /**
     * 设置失败返回
     * @return
     */
    public ResponseData setSuccessFalse(){
        this.success = "FALSE";
        return this;
    }

    /**
     * 设置成功返回
     * @return
     */
    public ResponseData setSuccessTrue(){
        this.success = "TRUE";
        return this;
    }

    /**
     * 设置失败返回消息
     * @param message
     * @return
     */
    public ResponseData setFalseAndMessage(String message){
        this.success = "FALSE";
        this.message = message;
        return this;
    }
}
