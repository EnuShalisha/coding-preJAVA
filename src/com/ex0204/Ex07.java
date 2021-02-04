package com.ex0204;

public class Ex07 {

	public static void main(String[] args) {
		Demo7 d = new Demo7();
		Test7 t = new Test7();
		
		//d와 t의 관계 -> 아무 관계도 아님(해쉬코드도 객체 클래스도 아예 가능)
		System.out.println(d+":"+t);
		
		System.out.println(d.a+":"+d.b+":"+t.b);
		Test7 td = d; // Test7와 Demo7의 관계는 super-sub - sub 객체를 super 객체로 형변환
		//이를 up-casting이라 한다(sub를 super에 맡김)
		//언제나 가능하고 형변환 하지 않아도 됨
		
		td.print(); // 똑같은 b인데 이 때는 sub의 것을 가짐
		//td.method(); 오버라이딩하지 않은 메소드는 호출 x
		
		System.out.println(td.b); //??? super거네
		//그럼 이거도 메소드로 필드 호출은 가능하지만 직접적으로 필드 호출은 안된다는건가?
		//"매소드는 재정의되면 상의메소드에 접근할 수 없다(숨는다)" // 즉 오버라이딩한 매소드만 자식을 인스턴스로 접근 가능
		//매소드로는 상위메소드 값을 부를 수 없다. 반면 필드는 상위 자기것 값을 불러옴
		//그래서 td.c는 못불러옴
		
		//컴파일시가 아니라 실행시에 비로소 td는 데모7 인스턴스 d를 가짐
		//즉 컴파일에서는 데모7 접근 불가, 실행에 앞서 컴파일 에러
		
		td.disp(); //이건 super거를 받았으니 당연히 가능
		System.out.println(d+":"+td); // 똑같은 해쉬값의 Demo7
		
		Test7 td2 = new Demo7();
		td2.print();
		Object ob = new Demo7(); // Object와 Test7은 super-sub
		System.out.println(td2+":"+ob); // 서로 다른 해쉬값의 Demo7
		
		// Demo7 td3 = new Demo71(); 하이라키 계층의 sub 간에는 안됨
		
		//-----------------------
				//down casting: up casting 한것만 down casting 가능
				//down casting은 반드시 형변환이 필요함
				//클래스간에 캐스팅은 상하관계에서만 가능
				
				//Demo7 dt = td;  컴파일 오류. 다운은 반드시 캐스팅 필요
				Demo7 dt = (Demo7)td;
				Demo7 dt2 = (Demo7)ob;
				System.out.println(dt.b+":"+dt2.b); // 정상적으로 dt2의 값
				
				//Demo7 dt3 = (Demo7)t;
				// System.out.println(dt3.a); 캐스팅이 안됐으므로 런타임 오류
				
				//instanceof: 객체가 해당 클래스를 상속하는 하위 객체이면 true
				if(t instanceof Demo7) {
					Demo7 dt3 = (Demo7)t;
					System.out.println(dt3.a);
				} else {
					System.out.println("변환 불가");
				}
				
				//다운스케일 상태에서
				//int x=(Demo7)(ob.a); ob.a가 (demo7)보다 연산 우선순위가 더 앞서기때문에 ob.a에서 에러 발생
				int x=((Demo7)ob).a;
				System.out.println(x);
		

	}

}

class Test7{
	int a=10;
	int b=20;
	public void print() {
		System.out.println("super:"+a+","+b);
	}
	
	public void disp() {
		System.out.println("super...");
	}
}

class Demo7 extends Test7{
	int b=100;
	int c=100;
	public void print() {
		System.out.println("sub:"+a+","+b+","+c);
	}
	
	public void method() {
		System.out.println("sub...");
	}
}

class Demo71 extends Test7{
	int b=50;
	int c=20;
	public void print() {
		System.out.println("sub2:"+a+","+b+","+c);
		
	}
}