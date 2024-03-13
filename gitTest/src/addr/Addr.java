package addr;

public class Addr {
	private int num;
	private String name;
	private String tel;
	private String addr;
	public int getNum() {
		return num;
	}
	public void setNum(int seq) {
		this.num = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Mem [seq=" + num + ", name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	public Addr(int num, String name, String tel, String addr) {
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public Addr( String name, String tel, String addr) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public Addr() {
	}
}
