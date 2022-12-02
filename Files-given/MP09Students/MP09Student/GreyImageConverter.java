import java.awt.image.*;
//import java.awt.Image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

//import java.imageio.*;

// 흑백 영상으로 변환하는 코드
class GreyImageConverter {
    public static void main(String[] args) {
        final String HOUSE = "house.png"; // 원본 영상 파일 이름
        
        // 전체적인 이미지 파일 입출력 과정에서 IOException이 발생할 수 있어 예외 처리 코드를 넣음
        try {       
            // 이미지 파일 데이터를 메모리에 넣음
            BufferedImage image = ImageIO.read(new File(HOUSE));

            // 이미지의 각 픽셀 정보에 대해 컬러 변환을 한 후 다시 저장
            for(int y = 0; y < image.getHeight(); y++) {
               for(int x = 0; x < image.getWidth(); x++) {
                   // (x, y)에 해당되는 픽셀의 RGB 정보를 받아서 Color에 저장
                   Color color = new Color(image.getRGB(x, y));
                   // RGB 값을 각각 읽어서 컬러 변환(여기서는 흑백으로 변환)
                   int outputRed = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
                   int outputGreen = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
                   int outputBlue = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
                   // 새로 만들어진 RGB 값을 (x, y)좌표 픽셀 컬러로 저장
                   image.setRGB(x, y, new Color(outputRed, outputGreen, outputBlue).getRGB());
               }
            }
            // 이미지 파일을 png 파일 형식으로 저장
            // 파일 이름은 HOUSE(house.png)에 "g_"를 앞에 붙인 것으로 지정
            ImageIO.write(image, "png", new File("g_" + HOUSE));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}