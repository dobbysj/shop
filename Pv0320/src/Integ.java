
public interface Integ {

	public void menu(); //메뉴출력 & 선택한 번호 넘기기 메소드
	public String callMenu(); //메뉴 호
	public void registor(); //회원가입 메소드
	public void loginout(); //로그인아웃 메소드
	public void product_list(); //제품 리스트 메소드
	public void buy(); //상품구매 메소드
	public void cart(); //장바구니 담기 메소드(구매 내역)
	public void cart_delete(); //장바구니 제품 삭제 메소드
	public int cart_pay(); //장바구니 결제 메소드
	public void m_list(); //회원 정보 보기 메소드
	public void m_search(); //회원 검색 메소드
	
}
