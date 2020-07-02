
package maker.utils;
import lombok.Data;

import java.io.Serializable;



@Data
public class ResultInfo implements Serializable {
    private String code;  //状态码
    private String msg; //状态信息
    private Object data; //数据



   /**
     * 成功
     * @param code
     * @param msg
     * @param data
     * @return
     */

    public static ResultInfo success(String code, String msg, Object data){
        ResultInfo result = new ResultInfo();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }



    public static ResultInfo failed(String code, String msg, Object data){
        return failed(code,msg,data);
    }


    //重载
    public static ResultInfo failed(String code, String msg){
        return failed(code,msg,null);
    }


}
