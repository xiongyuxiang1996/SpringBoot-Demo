package demo.springboot.emus;

/**
 * @Author 熊雨翔
 * @Date 2020/10/28 15:46
 */
public enum ResultCode {
    /**
     * 请求码
     */
    OK(0, "请求成功"),
    FAIL(1, "请求失败"),
    NEED_LOGIN(401, "需要登录"),
    PERMISSION_DENIED(403, "权限不足"),
    PARAM_ERROR(600, "参数错误"),
    LOST_PARAM(601, "缺少必要参数"),
    ;
    private int code;
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }}
