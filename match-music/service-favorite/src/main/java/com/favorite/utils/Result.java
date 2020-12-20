package com.favorite.utils;

public class Result {

    public static int SUCCESS_CODE = 200;
    public static int ERROR_CODE = 500;
    public int status = SUCCESS_CODE;
    public String msg = "操作成功";
    public Object data = null;

//构造重载
    public Result(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public Result(int status,String msg) {
        this.msg = msg;
        this.status = status;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


//成功响应状态
    public static Result ok(Object data){
        return new Result(data);
    }

    public static Result ok(String msg,Object data){
        return new Result(msg,data);
    }

    public static Result ok(int status,String msg,Object data){
        return new Result(status,msg,data);
    }

    public static Result ok(){
        return new Result();
    }

//失败响应
    public static Result fail(int status,String msg){
        return new Result(status,msg,null);
    }

    public static Result fail(String msg){
        return new Result(ERROR_CODE,msg,null);
    }

    public static Result fail(){
        return new Result(ERROR_CODE,"操作失败");
    }

}
