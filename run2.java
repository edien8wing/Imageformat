import java.io.*;

public class run2 {
	File f = new File(this.getClass().getResource("").getPath()).getParentFile();
	info in_ = new info();

	public static void main(String[] args){
    	
    	run2 r= new run2();
    	r.in_.setType(true);
    	System.out.println(r.f.toString());
    	ImageTool it = new ImageTool();
    	if(r.f.isDirectory()){
    		File fs=new File(r.f.toString()+"\\cover2");
    		if(!fs.exists()){
    			System.out.println("建立文件夹："+fs.toString());
    			fs.mkdir();
    		}
    		String [] li=r.f.list();
    		for(int i=0;i<li.length;i++){
    			
    			if(
    					(
    							li[i].endsWith(".jpg")||
    					li[i].endsWith(".JPG"))
    					&&(!li[i].startsWith("cover2_"))
    					){
    				r.in_.info("处理图片:"+r.f.toString()+"//"+li[i]);//
    				try{
    				it.getImage(r.f.toString()+"//"+li[i]);
    				it.getPointImage(r.f.toString()+"//"+"cover2"+"//"+"cover2_"+li[i],2);
    			}catch(Exception e){
    				System.out.println("转换失败");
    				}
    			}
    		}
    	}
    }
}
