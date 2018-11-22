import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
/**
 * 该方法用于读取、修改配置文件
 * @author lustg
 *
 */
public class PropertyIO {

	public static void main(String[] args) {
		try {
			String name = "the properties path";
			//通过class加载器寻找配置文件路径，使用URLDecoder转义特殊字符，防止路径上有空格等特殊字符。
			File file = new File(URLDecoder.decode(PropertyIO.class.getClassLoader().getResource(name).getPath(), "UTF-8"));
			InputStream in = new FileInputStream(file);
			Properties property = new Properties();
			property.load(in);
			//及时关闭读入流，防止写入时，文件为读入状态无法写入
			in.close();
			OutputStream out = new FileOutputStream(file);
			property.setProperty("write", "value");
			property.remove("");
			//保存property到本地
			property.store(out, null);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
