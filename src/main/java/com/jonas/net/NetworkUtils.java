package com.jonas.net;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class NetworkUtils {

    private static final Cache<Integer, Boolean> portOccupiedCache =
            CacheBuilder.newBuilder().expireAfterWrite(60, TimeUnit.SECONDS).build();
    @Getter
    @Setter
    private static String host = "127.0.0.1";


    /**
     * 根据IP和端口号，查询其是否被占用
     *
     * @param host IP
     * @param port 端口号
     * @return 如果被占用，返回true；否则返回false
     * @throws UnknownHostException IP地址不通或错误，则会抛出此异常
     */
    public static boolean isPortUsing(String host, int port) {
        try {
            if (Boolean.TRUE.equals(portOccupiedCache.getIfPresent(port))) {
                return true;
            }
            InetAddress theAddress = InetAddress.getByName(host);
            Socket socket = new Socket(theAddress, port);
            return true;
        } catch (UnknownHostException | ConnectException e) {
            //如果所测试端口号没有被占用，那么会抛出异常，这里利用这个机制来判断
            //所以，这里在捕获异常后，什么也不用做
            portOccupiedCache.put(port, true);
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
