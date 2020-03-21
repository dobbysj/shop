
public class Member {

	static int count;
	int memNum = 10000;
	String id;
	String pw;
	String nm;
	String ph;
	
	{
		memNum = ++count;
	}
	
	Member(){}
	Member(String id, String pw, String nm, String ph){
		this.id = id;
		this.pw = pw;
		this.nm = nm;
		this.ph = ph;
	}
	
	public String toString() {
		return memNum + "번 " + id + " " + nm + " " + ph + " ";
	}
	
		
}
