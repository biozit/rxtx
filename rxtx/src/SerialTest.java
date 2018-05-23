import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.fazecast.jSerialComm.SerialPort;

public class SerialTest {

	// testes
	private static final Logger logger = LogManager.getLogger(SerialTest.class);


	public static void main(String[] args) throws Exception {
		SerialPort comPort = null;
		try {
			comPort = SerialPort.getCommPort("COM1");
			comPort.openPort();
			while (true)
			{
				while (comPort.bytesAvailable() == 0)
					Thread.sleep(20);

				byte[] readBuffer = new byte[comPort.bytesAvailable()];
				int numRead = comPort.readBytes(readBuffer, readBuffer.length);
				String dados = new String(readBuffer);
				System.out.print(dados);

			}
		} catch (Exception e) { 
			logger.error(e);
		}finally {
			comPort.closePort();	
		}
		
	}
}