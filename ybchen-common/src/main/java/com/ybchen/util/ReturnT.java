package com.ybchen.util;

import java.io.Serializable;

/**
 * @Description：统一协议ReturnT工具类
 * @Author：chenyanbin
 * @Date：2021/5/9 下午8:09
 * @Versiion：1.0
 */
public class ReturnT<T> implements Serializable {
    /**
     * 状态码 0 表示成功，1表示处理中，-1表示失败
     */
    private Integer code;
    /**
     * 数据
     */
    private T data;
    /**
     * 描述
     */
    private String msg;

    private ReturnT() {
    }

    private static <T> ReturnT<T> build(Integer code, T data, String msg) {
        ReturnT json = new ReturnT();
        json.setCode(code);
        json.setData(data);
        json.setMsg(msg);
        return json;
    }

    /**
     * 成功，传⼊数据
     *
     * @return
     */
    public static <T> ReturnT<T> buildSuccess() {
        return build(0, (T) "", "");
    }


    /**
     * 成功，传⼊数据
     *
     * @param data
     * @return
     */
    public static <T> ReturnT<T> buildSuccess(T data) {
        return build(0, data, "");
    }

    /**
     * 失败，传⼊描述信息
     *
     * @param msg
     * @return
     */
    public static <T> ReturnT<T> buildError(String msg) {
        return build(-1, (T) "", msg);
    }

    /**
     * 判断接口响应是否成功，只是判断状态码是否等于：0
     *
     * @param data
     * @return
     */
    public static boolean isSuccess(ReturnT data) {
        return data.getCode() == 0;
    }

    /**
     * 判断接口响应是否失败，状态码除了0以外的，默认调用失败
     *
     * @param data
     * @return
     */
    public static boolean isFailure(ReturnT data) {
        return !isSuccess(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ReturnT{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
