package beans;

public class UserTicket {
	 String ticketCode;  //��Ʊʶ����
     String gateLocate;       //բ���ű��
     String macAddress;  //�û��豸MAC��ַ
     int ticketType;    //�û��������Ʊ����
     String phone;
     
     public UserTicket(){
    	 
     }
     
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
	public String getGateLocate() {
		return gateLocate;
	}
	public void setGateLocate(String gateLocate) {
		this.gateLocate = gateLocate;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
     
     
}
