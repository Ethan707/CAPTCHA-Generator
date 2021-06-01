import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Generator {

    public static void main(String[] args) throws IOException {
        DefaultKaptcha dk = new DefaultKaptcha();
        Properties properties = new Properties();

        // 图片边框
        properties.setProperty("kaptcha.border", "no");
        // 边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "black");
        // 图片宽
        properties.setProperty("kaptcha.image.width", "200");
        // 图片高
        properties.setProperty("kaptcha.image.height", "50");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        // session key
        properties.setProperty("kaptcha.session.key", "code");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "6");
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        //加鱼眼效果
//        properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.FishEyeGimpy");
        //加水纹效果
        properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.WaterRipple");
        //加阴影效果
        properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
        //配置
        Config config = new Config(properties);
        //将配置信息放入DefaultKaptcha
        dk.setConfig(config);

        for (int i = 0;i < 10000;i++){
            //创建验证码中的文字
            String text = dk.createText();
            //根据文字创建一张验证码
            BufferedImage image = dk.createImage(text);
            //将BufferedImage转为图片
            ImageIO.write(image,"jpg",new File("D:\\Task\\1\\"+text+"_"+i+".jpg"));
            System.out.println(i);
        }

    }
}