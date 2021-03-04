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

        // Image borders
        properties.setProperty("kaptcha.border", "no");
        // Border color
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // Font color
        properties.setProperty("kaptcha.textproducer.font.color", "black");
        // Image width
        properties.setProperty("kaptcha.image.width", "200");
        // Image height
        properties.setProperty("kaptcha.image.height", "50");
        // Font size
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        // session key
        properties.setProperty("kaptcha.session.key", "code");
        // Captcha length
        properties.setProperty("kaptcha.textproducer.char.length", "6");
        // Font
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        // Add fisheye effect
        properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.FishEyeGimpy");
        // Add water ripple effect
        properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.WaterRipple");
        // Add shadow gimpy effect
        properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
        // config
        Config config = new Config(properties);
        //Put the configuration information into the DefaultKaptcha
        dk.setConfig(config);

        for (int i = 0;i < 10000;i++){
            // Create the text in the captcha
            String text = dk.createText();
            // Create a captcha based on the text
            BufferedImage image = dk.createImage(text);
            // Convert BufferedImage into image and customize the captcha name
            // default: "{content}_{index}.jpg"
            ImageIO.write(image,"jpg",new File("E:\\Task\\Data\\"+text+"_"+i+".jpg"));
        }
    }
}