import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;
/*对照片进行舍弃一半的颜色操作压缩率大致在20%至40%，对单调矢量图效果较差*/
public class ImageTool {
	public BufferedImage mainIMG = null;

	public boolean getImage(BufferedImage img) {
		boolean ans = true;
		try {
			mainIMG = null;
			this.mainIMG = img;
		} catch (Exception e) {
			e.printStackTrace();
			ans = false;
		}
		return ans;
	}


	public boolean getImage(String url) {
		boolean ans = true;
		try {
			this.mainIMG = ImageIO.read(new File(url));
		} catch (Exception e) {
			e.printStackTrace();
			ans = false;
		}
		return ans;
	}
	
	
	/* 单双区分 */
	public void getSingle(String url,int deep){
		Graphics gg=mainIMG.getGraphics();
		for(int i=0;i<mainIMG.getWidth();i++){
			for(int j=0;j<mainIMG.getHeight();j++){
				
				int rgb=mainIMG.getRGB(i, j);
				//System.out.println(i+" "+j+" "+rgb);
				Color col= new Color(rgb);


			    col= new Color(col.getRed()/2*2,col.getGreen()/2*2,col.getBlue()/2*2);
				gg.setColor(col);
				gg.drawLine(i, j, i, j);
			}
			//System.out.println((i+0.00)/mainIMG.getWidth()*100+"/%");
		}
		try {
			ImageIO.write(mainIMG, "jpeg", new File(url));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getPointImage(String url,int deep){
		//转换尺寸至600的image
		Image bi = mainIMG.getScaledInstance(600, (int)(mainIMG.getHeight()*600.0/mainIMG.getWidth()), Image.SCALE_DEFAULT);
		//System.out.prinrln(mainIMG.getWidth()/600.0*mainIMG.getHeight());
		//转换成bufferedimage
		BufferedImage bufImg = new BufferedImage(bi.getWidth(null), bi.getHeight(null),BufferedImage.TYPE_INT_RGB);   
        Graphics g = bufImg .createGraphics();   
        g.drawImage(bi, 0, 0, null);   
        g.dispose(); 
		
        Graphics gg=bufImg.getGraphics();
		for(int i=0;i<bufImg.getWidth(null);i++){
			for(int j=0;j<bufImg.getHeight(null);j++){
				
				int rgb=bufImg.getRGB(i, j);
				//System.out.println(i+" "+j+" "+rgb);
				Color col= new Color(rgb);


			    col= new Color(col.getRed()/2*2,col.getGreen()/2*2,col.getBlue()/2*2);
				gg.setColor(col);
				gg.drawLine(i, j, i, j);
				}
			}
			//System.out.println((i+0.00)/mainIMG.getWidth()*100+"/%");
		gg.dispose();
		
		try {
			ImageIO.write(bufImg, "jpeg", new File(url));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
