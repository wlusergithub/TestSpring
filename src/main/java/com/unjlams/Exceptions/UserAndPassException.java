package com.unjlams.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by UnjlAms on 2017/8/29.
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户和密码不匹配")
public class UserAndPassException extends RuntimeException {

    private static final long serialVersionUID=1L;
}
