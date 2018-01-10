package Server;
/**
 *
 * @author yannick
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import Server.MessageData;
import com.google.gson.Gson;

public class MessageServer {
 public static void main(String [] args)
 {
  
  int written = 0;
  Gson gson = new Gson();
  MessageData msg = new MessageData();
  msg.setApplicatie("Werknemerloket");
  msg.setTijdstip("12:40");
  msg.setLoglevel("Verbose");
  msg.setLocatie("Werknemerloket/login");
  msg.setData("Login mislukt");
  String json = gson.toJson(msg);
    
  // Create the encoder and decoder for targetEncoding
  Charset charset = Charset.forName("UTF-8");
 // CharsetDecoder decoder = charset.newDecoder();
  CharsetEncoder encoder = charset.newEncoder();
  byte [] underlyingBuffer = new byte[1024];
  ByteBuffer buffer = ByteBuffer.wrap(underlyingBuffer);
  buffer.order(ByteOrder.LITTLE_ENDIAN);
  try
  {
   Socket client = new Socket("localhost", 8080);
   
   OutputStream oStream = client.getOutputStream();

   serialize(buffer, json, encoder);
   
   buffer.flip();
   
   int dataToSend = buffer.remaining();
   System.out.println("# bytes = " + dataToSend);
   
   System.out.println("#Bytes in output buffer: " + written + " limit = " + buffer.limit() + " pos = " + buffer.position() + " remaining = " + buffer.remaining());
   
   //Get remaining data out of the stream to make sure everything gets read.
   int remaining = dataToSend;
   while(remaining > 0)
   {
    oStream.write(buffer.get());
    //Reduce remaining.
    -- remaining;
   }
   
   client.close();
   
  } catch(Exception e) {
   e.printStackTrace(System.err);
  } 
 }
 
 private static void serialize(ByteBuffer buffer, String msg, CharsetEncoder encoder)
 {
  // id
 
  
  CharBuffer nameBuffer = CharBuffer.wrap(msg.toCharArray());
  ByteBuffer nbBuffer = null;
  
  // length of content
  try
  {
    nbBuffer = encoder.encode(nameBuffer);
  } 
  catch(CharacterCodingException e)
  {
    throw new ArithmeticException();
  }

  System.out.println(String.format("String [%1$s] #bytes = %2$s", msg, nbBuffer.limit()));
  buffer.putInt(nbBuffer.limit());
  buffer.put(nbBuffer);
  
  // length of content
  try
  {
    nbBuffer = encoder.encode(nameBuffer);   
  } 
  catch(CharacterCodingException e)
  {
    throw new ArithmeticException();
  }
 }
}
