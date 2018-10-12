package network_programming;
///http://www.runoob.com/java/java-networking.html
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class GreetingClient {
	public static void main(String[] args) {
		String serverName = args[0];
		int port = Integer.parseInt(args[1]);
		System.out.println("Linking to the zhuji:" + serverName + "port:" + port);
		try {
			Socket client = new Socket(serverName, port);
			System.out.println("Remote zhuji address:"+client.getRemoteSocketAddress());
			OutputStream outputStream=client.getOutputStream();
			DataOutputStream out=new DataOutputStream(outputStream);
			out.writeUTF("hello form"+client.getLocalSocketAddress());
			InputStream inFromServer =client.getInputStream();
			DataInputStream in=new DataInputStream(inFromServer);
			System.out.println("Server xiangying:"+in.readUTF());
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
