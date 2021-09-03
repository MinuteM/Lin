package common;

import lombok.Data;

@Data
public class ResultInfo {

    private Boolean success;

    private String message;

    private Object data;

    public static ResultInfo success(Object o) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(o);
        resultInfo.setSuccess(true);
        return resultInfo;
    }

    public static ResultInfo error(String message) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMessage(message);
        resultInfo.setSuccess(false);
        return resultInfo;
    }

}
