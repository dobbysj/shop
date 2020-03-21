
public class Mall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. 회원가입 >> 로그인 시 노출되지 않음
		//2. 로그인 >> 로그인 되어 있을 시 로그아웃
		//3. 상품구매(장바구니 담기)
		//4. 장바구니 >> 제품삭제, 결제하기 
		//5. 구매내역 **어드민 로그인 시 모든 회원의 구매내역 노출
		//어드민 로그인 시 노출 영역=====
		//5. 회원정보보기(일반인 로그인일 시 본인 정보만)   
		//6.회원정보검색
		
		
		Integimp i = new Integimp();
		i.admin();
		
		while(true) {
			i.menu();
			switch (i.callMenu()) {
			case "1":
				//로그인한 상태인데 1 선택했을경우 어떻게해 >>한번 더권한체크를 한다.
				i.registor();
				break;
			case "2":
				// 로그인, 로그아웃
				i.loginout();
				break;
			case "3":
				//상품구매(장바구니 담기)
				i.buy();
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				
				break;
			case "7":
				
				break;
				
			default:
				break;
			}//switch
		}//while
		
		

		
	}

}
