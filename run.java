import java.io.*;

public class run {
	File f = new File(this.getClass().getResource("").getPath()).getParentFile();
	info in_ = new info();

	public static void main(String[] args){
    	
    	run r= new run();
    	r.in_.setType(true);
    	System.out.println(r.f.toString());
    	ImageTool it = new ImageTool();
    	if(r.f.isDirectory()){
    		File fs=new File(r.f.toString()+"\\cover");
    		if(!fs.exists()){
    			System.out.println("建立文件夹："+fs.toString());
    			fs.mkdir();
    		}
    		String [] li=r.f.list();
    		for(int i=0;i<li.length;i++){
    			
    			if(
    					(
    							li[i].endsWith(".jpg")||
    					li[i].endsWith(".JPG")||
    					li[i].endsWith(".gif")||
    					li[i].endsWith(".GIF")||
    					li[i].endsWith(".png")||
    					li[i].endsWith(".PNG"))
    					&&(!li[i].startsWith("cover_"))
    					){
    				r.in_.info("处理图片:"+r.f.toString()+"//"+li[i]);//
    				try{
    				it.getImage(r.f.toString()+"//"+li[i]);
    				it.getSingle(r.f.toString()+"//"+"cover"+"//"+"cover_"+li[i],2);
    			}catch(Exception e){
    				System.out.println("转换失败");
    				}
    			}
    		}
    	}
    }
}
