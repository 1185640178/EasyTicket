package util;

import java.util.HashMap;

public class GetMsgTo{
	private static String key;
	 public static HashMap<String, String> hash(String msg){
	  	 //KeyΪ�ش�����
		 
		 //��ʽ�� ��Ϣ�ؼ���?����1=value&����2=value
	    	//ʾ����  ���û�����Ʊʹ����Ϣ
	    	//  UserTicketInfo?ticketCode=123456&mac=45:56:89:78
	       //  �򽫵õ�HashMap�е�����Ϊ[ticketCode=123456,mac=45:56:89:78]
	  		String[] data = null;
	  		String[] content = null;
	  		HashMap<String, String> requestParama = null;
	  		if(msg.contains("?")){
	  		data = msg.split("\\?");
	  		key = data[0];
	  		System.out.println(key);
	  	    content = data[1].split("\\&");
	  	    requestParama   = new HashMap<String, String>();
	  	    for(int i=0;i<content.length;i++){
	  	  	 String[] params = content[i].split("=");
	  	  	 requestParama.put(params[0],params[1]);
	  	    }
	  		}
	  	    return requestParama;
	    }
	 
	 public static String getKey(){
		 String temp = key;
		 key = null;
		 return temp;
	 }
}
