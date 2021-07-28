package com.ithujiaze.untils;

import org.json.JSONObject;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaceId {
    private final double Threshold = 0.90;

    public String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "uM15h0mcKWLvbQGGPXaFMgor";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "K9E52W4ErGIqflbiC3GHsUUZ6WHIea4o";
        return getAuth(clientId, clientSecret);
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     *
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

    public String GetImageStr(String imgPath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = imgPath;// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encode;
    }

    public boolean faceVerify(String path) {
        // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
        String accessToken = getAuth();
        if (accessToken == null) {
            return false;
        }
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceverify";
        try {
            Map<String, String> map = new HashMap<>();
            List<Object> list = new ArrayList<>();
            map.put("image", GetImageStr(path));
            map.put("image_type", "BASE64");
            map.put("option", "COMMON");
            list.add(map);
            String param = GsonUtils.toJson(list);
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JSONObject jsonObject = new JSONObject(result);
            jsonObject = (JSONObject) jsonObject.get("result");
            double face_liveness = (double) jsonObject.get("face_liveness");
            System.out.println(face_liveness);
            if (face_liveness > Threshold) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean faceMatch(String path_1, String path_2) {
        //活体检测
        if (faceVerify(path_1) == false) {
            return false;
        }
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            Map<String, String> map_photo1 = new HashMap<>();
            Map<String, String> map_photo2 = new HashMap<>();
            List<Map<String, String>> list = new ArrayList<>();
            map_photo1.put("image", GetImageStr(path_1));
            map_photo1.put("image_type", "BASE64");
            map_photo2.put("image", GetImageStr(path_2));
            map_photo2.put("image_type", "BASE64");
            list.add(map_photo1);
            list.add(map_photo2);
            String param = GsonUtils.toJson(list);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = getAuth();
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JSONObject jsonObject = new JSONObject(result);
            jsonObject = (JSONObject) jsonObject.get("result");
            int score = (int) jsonObject.get("score");
            if (score > Threshold * 100) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        FaceId faceId = new FaceId();
        boolean b = faceId.faceMatch("src/demo/9.jpeg", "src/demo/9.jpeg");
        System.out.println(b);
    }

}
