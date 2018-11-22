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
 * �÷������ڶ�ȡ���޸������ļ�
 * @author lustg
 *
 */
public class PropertyIO {

	public static void main(String[] args) {
		try {
			String name = "the properties path";
			//ͨ��class������Ѱ�������ļ�·����ʹ��URLDecoderת�������ַ�����ֹ·�����пո�������ַ���
			File file = new File(URLDecoder.decode(PropertyIO.class.getClassLoader().getResource(name).getPath(), "UTF-8"));
			InputStream in = new FileInputStream(file);
			Properties property = new Properties();
			property.load(in);
			//��ʱ�رն���������ֹд��ʱ���ļ�Ϊ����״̬�޷�д��
			in.close();
			OutputStream out = new FileOutputStream(file);
			property.setProperty("write", "value");
			property.remove("");
			//����property������
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
