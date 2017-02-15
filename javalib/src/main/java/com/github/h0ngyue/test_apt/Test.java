package com.github.h0ngyue.test_apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shuailongcheng on 14/02/2017.
 * ref: https://joyrun.github.io/2016/07/19/AptHelloWorld/
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Test {

}
