
public class Product {
	static int count;
	int serial;
	String name;
	int price;
	double point;	
	String color;
	int product_num;
	
	{
		serial = ++count;
	}
	
	Product(){}
	Product(int product_num, String name, int price, String color){
		this.product_num=product_num;
		this.name=name;
		this.price=price;
		this.color=color;
	}	
	
}

//아이폰 클래스
class Iphone extends Product{
	static int count;
	int serial;
	String size; //크기
	String capa; //용량
	
	
	{
		serial=++count;
	}
	
	Iphone(){}
	Iphone(int product_num, String name, int price, String color, String size, String capa){
		super(product_num, name, price, color);
		this.size=size;
		this.capa=capa;
	}
	
	public String toString() {
		return "상품명: "+name+"	가격: "+price+"	색상:"+color+"	사이즈:"+size+"	용량:"+capa;
	}
	
}


//갤럭시 클래스
class Galaxy extends Product{
	static int count;
	int serial;
	String fold;
	
	{
		serial=++count;
	}
	
	Galaxy(){}
	Galaxy(int product_num, String name, int price, String color, String fold){
		super(product_num, name, price, color);
		this.fold=fold;
	}
	
	public String toString() {
		return "상품명: "+name+"	가격: "+price+"	색상:"+color+"	폴드:"+fold;
	}
	
}

