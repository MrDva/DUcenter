package com.ithujiaze.untils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public  final class NetworkUtil {
    private final static String UNKNOWN = "unknown";

    private static final String[] HEAD_INFO = {"X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR", "PROXY_FORWARDED_FOR", "X-Real-IP"};


    public static String getIpAddr(HttpServletRequest request) {
        System.out.println(request);
        for (String header : HEAD_INFO) {
            String ip = request.getHeader(header);
            System.out.println(header+":"+ip);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                if (ip.contains(",")) {
                    String[] ips = ip.split(",");
                    for (String s : ips) {
                        if (!(UNKNOWN.equalsIgnoreCase(s))) {
                            ip = s;
                            break;
                        }
                    }
                }
                return ip;
            }
        }

        return request.getRemoteAddr();


    }
}