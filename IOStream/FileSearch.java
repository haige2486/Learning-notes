import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * 文件包含字符搜索
 * @author lustg
 *
 */
public class FileSearch {

	static int m = 1;
	
	public static void main(String[] args) {
		try {
			f(new File("D:\\"), "对象");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void f(File a, String s) throws IOException {
		File[] ff = a.listFiles();
		if(ff == null) return;
		for(File it : ff) {
			if (it.isFile()) {
				search(it, s);
			} else if(it.isDirectory()) {
				f(it, s);
			}
		}
	}

	static void search(File it, String s) throws IOException {
		String name = it.getName();
		String path = it.getPath();
		File file = new File("d:\\store.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		if(it.renameTo(it)) {
			Scanner scan = new Scanner(it, "gbk");
			int k = 0;
			while(true) {
				if(scan.hasNext() == false) return;
				String line = scan.nextLine();
				k++;
				if(line.contains(s)) {
					String ss = name + " 文件：" + path + " 第（" + k +"）行，内容：" + line + "\r\n";
					bw.write(ss);
					bw.flush();
					m++;
				}
			}
			
			/*Scanner scan1 = new Scanner(it, "utf-8");
			int k1 = 0;
			while(true) {
				if(scan1.hasNext() == false) return;
				String line = scan1.nextLine();
				k1++;
				if(line.contains(s)) {
					String ss = name + " 文件：" + path + " 第（" + k1 +"）行，内容：" + line;
					System.out.println(ss);
					m++;
				}
			}*/
		} else {
			bw.write(name + "已被占用，不能读取\r\n");
			bw.flush();
		}
		bw.close();
	}
}