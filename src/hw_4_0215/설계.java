package hw_4_0215;

public class 설계 {
/* 0. 생성자 - 판매자 메뉴 비밀번호 치고 진입시 클래스(seller)로 이동
 * new stockVO vo 생성 
 * 
 * stockVO 목록
 * String Name
 * int Price
 * storeVO[] list
 * 
 * 1. 음료 등록
 *
 * 1) 등록: void register(String Name)
 * {2) 음료 이미 있는지 확인: storeVO checkbyName(String s)} try catch문으로 작성
 * 3) 음료 가격 입력: Interger.parseint(sc.next)
 * 4) 음료 이름, 가격 등록: setName setPrice - from VO
 * 5) VO 저장: boolean appendVO (storeVO vo)
 * 
 * 2. 음료 수정
 * 	1) 수정: void modify(String s, int switch)
 * 	{2) 음료 이미 있는지 확인: storeVO checkbyName(String s)} try catch문으로 작성
 * 	3) UI에서 정한 메소드로 이동 - 1. 이름변경 2. 가격변경
 * 	(4-1) 이름 변경: String modifyName(storeVO vo)
 *  (4-2) 변경 작업: setName - fromVO
 *  (5-1) 가격 변경: String modifyPrice(storeVO vo)
 *  (5-2) 변경 작업: setPrice - fromVO
 *  
 * 3. 음료 삭제
 * 	1) 삭제: void delete(String Name)
 * 	{2) 음료 존재하는지 확인: storeVO checkbyName(String s)} try catch문으로 작성
 * 	3) 한번더 확인하기: if(sc.next()=="Y")
 * 	4) 삭제 작업: boolean delete(storeVO vo)
 * 
 * 1. 음료 등록순으로? 배열도 따로?
 * 2. cardVO와 cashVO를 만들면, card와 cash에 해당하는 primary key를 어떤거로(사용자? 카드번호?)
 */
}
