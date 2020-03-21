import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Integimp implements Integ {

	ArrayList<Member> member = new ArrayList<Member>(); //회원 목록
	ArrayList<Product> product = new ArrayList<Product>(); //제품 목록
	ArrayList<Buylist_for_admin> order = new ArrayList<Buylist_for_admin>();//모든 회원의 주문목록
	HashMap<String, String> login = new HashMap<String, String>(); //로그인 확인 해시맵
	Scanner scan = new Scanner(System.in);
	public static final String pattern1 = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$"; 
	// 영문, 숫자, 특수문자
	Matcher match;


	// 관리자 세팅 메소드
	void admin() {
		member.add(new Member("admin", "1234", "관리자", "010"));
	}

	@Override
	public void menu() {
		// 로그인 여부 체크, 어드민인지 여부 체크 >> 메인 노출 달라
		System.out.println("=======[쇼핑몰 메인 화면]=======");
		if(login.isEmpty()) {
			System.out.println("1. 회원가입");			
		} 
		if(login.isEmpty()) {
			System.out.println("2. 로그인");			
		} else {
			System.out.println("2. 로그아웃");
		}
		System.out.println("3. 상품구매");
		System.out.println("4. 장바구니");
		System.out.println("5. 회원정보");
		System.out.println("6. 회원검색");
	}

	@Override
	public String callMenu() {
		System.out.println("번호를 선택하세요.");
		String select = scan.next();
		return select;
	}

	@Override
	public void registor() {
		
		//로그인 상태로 회원가입 접근 시
		if(!(login.isEmpty())) {
			System.out.println("잘못된 접근입니다.");
			return;
		}
		
		//정상접근(로그인 하지 않은 상태)
		String id;
		String pw;
		String pw2;
		String nm;
		String ph;
		System.out.println("=========[회원가입]=========");
		// id 생성
		while (true) {
			System.out.println("아이디를 입력하세요. (5글자 이상 영문)");
			System.out.println("*메인화면으로 이동 : 99");
			id = scan.next();
			if(id.equals("99")) {
				return;
			}
			if (id.length() < 5) {
				System.out.println("5자 이상 입력하세요.");
				continue;
			}
			for (int i = 0; i < id.length(); i++) {
				if (!((id.charAt(i) > 'a' && id.charAt(i) < 'z') || (id.charAt(i) > 'A' && id.charAt(i) < 'Z'))) {
					System.out.println("영문자로 입력해주세요.");
					continue;
				}
			}
			System.out.println("아이디 생성이 완료되었습니다.");
			break;
		}

		// 비번 생성
		loop1:
		while (true) {		
			while (true) {
				boolean chk;
				System.out.println("비밀번호를 입력하세요. (8~10 영문 대문자+숫자+특수문자 조합)");
				pw = scan.next();
				chk = pwdRegularExpressionChk(pw);
				if(chk==false) {
					System.out.println("8~10자의 대문자, 숫자, 특수문자 조합으로 입력하세요.");
					continue;
				}
				break;
			}//pw1 while
			
			// 비번 확인
			while(true) {
				System.out.println("비밀번호를 한 번 더 입력하세요.(비밀번호 재설정 : 99)");
				pw2 = scan.next();
				if(pw2.equals("99")) {
					continue loop1;
				}
				if(!pw.equals(pw2)) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				break;
			}//pw2 while
			break;
		}//pw while

		// 이름, 전번 입력
		System.out.println("이름을 입력하세요.");
		nm = scan.next();
		
		System.out.println("전화번호를 입력하세요.(-제외)");
		ph = scan.next();

		member.add(new Member(id, pw, nm, ph));
	}

	// pw체크
	public boolean pwdRegularExpressionChk(String newPwd) {
		boolean chk = false;
		// 특수문자, 영문, 숫자 조합 (8~10 자리)
		match = Pattern.compile(pattern1).matcher(newPwd);
		if (match.find()) {
			chk = true;
		}
		return chk;
	}

	@Override
	public void loginout() {
		
		String id;
		String pw;
		boolean chk=false;

		//로그아웃 
		if(!(login.isEmpty())) {
			System.out.println("로그아웃 하시겠습니까?");
			System.out.println("1. 네     2. 아니오");
			String select = scan.next();
			switch (select) {
			case "1":
				login.clear();
				id=null;
				System.out.println("로그아웃 되었습니다.");
				break;
			case "2":
				return;
			default:
				System.out.println("잘못 입력했습니다.");
				loginout();
				break;
			}
		}
		
		//로그인
		loopLid :
		while(true) {
			System.out.println("아이디를 입력하세요.");
			id = scan.next();
			for(int i=0; i<member.size(); i++) {
				Member m = (Member)member.get(i);
				if(id.equals(m.id)) {
					while(true) {
						System.out.println("비밀번호를 입력하세요.(아이디 재입력:99)");
						pw = scan.next();
						if(pw.equals("99")) {
							continue loopLid;
						}
						if(pw.equals(m.pw)) {
							chk=true;
							System.out.println("로그인 되었습니다.");
							System.out.println(id+"님 안녕하세요.");
							break loopLid;
						} else {
							System.out.println("비밀번호가 일치하지 않습니다.");
							continue;
						}						
					}
				} else {
					chk=false;
				}	
			}
			if(chk==false) {
				System.out.println("일치하는 아이디가 없습니다.");
				continue;
			} 
		}// 아이디 비번 체크
		login.put(id, pw);
	}


	@Override
	public void product_list() {
		product.add(new Iphone(product.size()+1, "IphoneX", 160, "gold", null, "128GB"));
		product.add(new Iphone(product.size()+1, "IphoneX Plus", 160, "gold", "Plus", "256GB"));
		product.add(new Iphone(product.size()+1, "IphoneXR", 200, "silver", null, "128GB"));
		product.add(new Iphone(product.size()+1, "IphoneXR Plus", 200, "silver", "Plus", "256GB"));
		product.add(new Galaxy(product.size()+1,"GalaxyS20", 150, "black", null));
		product.add(new Galaxy(product.size()+1, "GalaxyS20", 150, "black", "fold"));
	}
	
	
	@Override
	public void buy() {
		
		if(product.size()<=0) {
			System.out.println("상품이 없습니다.");
		}
		
		//제품 리스트 노출
		while(true) {
			System.out.println("상품 리스트");
			for(int i=0; i<product.size(); i++) {
				Product p = (Product)product.get(i);
				if(p instanceof Iphone) {
					Iphone ip = (Iphone) p;
					System.out.println(ip);
				} else if(p instanceof Galaxy) {
					Galaxy g = (Galaxy) p;
					System.out.println(g);
				}
			}//for
			
			//제품 번호 선택하요 장바구니에 담기
			System.out.print("구매할 상품의 번호를 입력하세요(이전 화면: 99)>>");
			int select = scan.nextInt();
			if(select==99) {
				break;
			}
			Product p = (Product)product.get(select-1);
			System.out.println(p.name+"을(를)장바구니에 담았습니다.");
			
//			login.keySet();
			
//			order.add(login.keySet(), );
			continue;
		}//while		
	}

	
	@Override
	public void cart() {

		

	}

	@Override
	public void cart_delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cart_pay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void m_list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void m_search() {
		// TODO Auto-generated method stub

	}

	

}
