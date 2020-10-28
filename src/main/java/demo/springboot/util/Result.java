package demo.springboot.util;

import demo.springboot.emus.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 熊雨翔
 * @Date 2020/10/28 15:44
 */
@Data
@NoArgsConstructor
public class Result<T> {
    private Boolean success;
    private Integer code;
    private String msg;
    private T data;
    private Object errData;

    private Result(Boolean success, Integer code, String msg, T data, Object errData) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.errData = errData;
    }

    public static <D> Result<D> by(Result<?> result) {
        return new Result<>(result.getSuccess(), result.getCode(), result.getMsg(), null, result.getErrData());
    }

    public static <D> Result<D> by(Result<?> result, D data) {
        return new Result<>(result.getSuccess(), result.getCode(), result.getMsg(), data, result.getErrData());
    }

    public static <D> Result<D> success() {
        return new Result<>(true, ResultCode.OK.getCode(), ResultCode.OK.getDesc(), null, null);
    }

    public static <D> Result<D> success(D data) {
        return new Result<>(true, ResultCode.OK.getCode(), ResultCode.OK.getDesc(), data, null);
    }

    public static <D> Result<D> success(D data, String msg) {
        return new Result<>(true, ResultCode.OK.getCode(), msg, data, null);
    }

    public static <D> Result<D> error() {
        return new Result<>(false, ResultCode.FAIL.getCode(), ResultCode.FAIL.getDesc(), null, null);
    }

    public static <D> Result<D> error(String msg) {
        return new Result<>(false, ResultCode.FAIL.getCode(), msg, null, null);
    }

    public static <D> Result<D> error(ResultCode code) {
        return new Result<>(false, code.getCode(), code.getDesc(), null, null);
    }

    public static <D> Result<D> error(ResultCode code, String msg) {
        return new Result<>(false, code.getCode(), msg, null, null);
    }

    public static <D> Result<D> error(ResultCode code, Object errData) {
        return new Result<>(false, code.getCode(), code.getDesc(), null, errData);
    }

    public static <D> Result<D> error(ResultCode code, String msg, Object errData) {
        return new Result<>(false, code.getCode(), msg, null, errData);
    }

    public static <D> Result<D> error(Integer code, String msg) {
        return new Result<>(false, code, msg, null, null);
    }

    public static <D> Result<D> error(Result<?> err) {
        return new Result<>(false, err.getCode(), err.getMsg(), null, err.getErrData());
    }

}
