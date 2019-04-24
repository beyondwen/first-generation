package com.amchis.firstgeneration.common;

public class Constant
{
    /**
     * jwt
     * 
     */
    public static final String JWT_ID = "jwt";
    public static final String JWT_SECRET = "A4BkIlR8fykGI6aLRYaigjYRZ8uk2ElMSkgcT89A7AOYJUBuKSjQGLN9P6RL";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
    public static final int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond
}