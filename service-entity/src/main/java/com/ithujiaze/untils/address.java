package com.ithujiaze.untils;

import com.ithujiaze.entity.Point;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

@Service
public class address {
    private final String ak = "xDp94ChRfcF7yBVY4wXUmlVAC3imEEtv";

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
            // System.out.println("同时 从这里也能看出 即便return了，仍然会执行finally的！");
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        //这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
        String ip = "115.236.55.101";
        address address = new address();
        Point point = address.getPoint(ip);
        System.out.println(point.toString());

    }

    public Point get_Address(Point point) {
        StringBuilder sb = new StringBuilder("http://api.map.baidu.com/reverse_geocoding/v3/?ak=");
        sb.append(ak);
        sb.append("&output=json&coordtype=wgs84ll&location=");
        sb.append(point.getPoint_y() + "," + point.getPoint_x());
        try {
            JSONObject json = readJsonFromUrl(sb.toString());
            String result = ((JSONObject) json.get("result")).get("formatted_address").toString();
            point.setAddress(result);
            System.out.println(result);
            return point;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Point getPoint(String ip) {
        Point point = new Point();
        StringBuilder sb = new StringBuilder("https://api.map.baidu.com/location/ip?ak=");
        sb.append(ak);
        sb.append("&ip=");
        sb.append(ip);
        sb.append("&coor=bd09ll");
        try {
            JSONObject json = readJsonFromUrl(sb.toString());
            System.out.println(json);
            json = (JSONObject) json.get("content");
            json = (JSONObject) json.get("point");
            point.setPoint_x((String) json.get("x"));
            point.setPoint_y((String) json.get("y"));
            point = get_Address(point);
            return point;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
