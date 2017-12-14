package homework;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Weather{
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.k780.com/?app=weather.future&weaid=1&&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");

        URLConnection coon = url.openConnection();

        InputStream is = coon.getInputStream();

        byte[] buff  = new byte[1024*1024];
        int len= is.read(buff);

        String result = new String(buff,0,len);
        System.out.println(result);

        JSONObject jsonObject=JSONObject.fromObject(result);
        Book book=(Book)JSONObject.toBean(jsonObject,Book.class);

        System.out.println("id为"+book.getClass());


    }

}
