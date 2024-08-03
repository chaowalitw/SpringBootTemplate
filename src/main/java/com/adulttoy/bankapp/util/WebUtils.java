package com.adulttoy.bankapp.util;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
    public static boolean isActuatorEndpoints(HttpServletRequest request){
        return String.valueOf(request.getRequestURI()).contains("actuator");
    }
}
