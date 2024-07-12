package org.com.data;

import org.com.dto.BookDTO;

import java.util.Map;
import java.util.Scanner;

/***
 * 책이름을 KEY값으로 가져 이로 구분합니다.
 */
public class BookManager {

    Map<String, BookDTO> bookData;
    //필요기능: 빌리기((책이름 구분)ISBN구분 할 필요는 굳이 없을 듯), 검색하기.

    public BookManager(Map<String, BookDTO> bookData) {
        this.bookData = bookData;
    }

    /***
     * 해당 BookDTO 를 리턴하는 메소드입니다
     * 책 조회후 객체를 반환합니다.
     * @return
     */
    private BookDTO searchBook(String bookName){
       return bookData.get(bookName);
    }

    public void printBookList(){
        System.out.println("전체 책 목록을 출력합니다.");
        bookData.forEach((k,v)->{
            System.out.println("==================");
            System.out.println(v);
        });
    }
    /***
     * 책 대여 메서드
     */
    public void borrowBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("대여/반납을 원하는 책의 이름을 작성해주세요 : ");
        BookDTO book = searchBook(sc.nextLine());
        if(book == null){
            System.out.println("해당 제목으로 검색된 책이 없습니다.");
            return;
        }
        System.out.println("검색된 책은 : " +book+" 입니다.");
        System.out.println("- - - - - - - - - - - - - ");
        String token = (book.isCanBarrow() ?"대여":"반납");
        System.out.print(token + "하시겠습니까? "+token+" : 1, 취소: 다른 숫자 ");
        if(sc.nextInt() == 1){
            book.setCanBarrow(!book.isCanBarrow());
            System.out.println(token+" 성공했습니다.");
        }
        else {
            System.out.println("취소했습니다.");
        }
    }

    /***
     * 책 삭제 메서드
     */
    public void deleteBook(){
        Scanner sc  = new Scanner(System.in);
        System.out.print("삭제 원하는 책의 이름을 작성해주세요 : ");
        BookDTO book= searchBook(sc.nextLine());
        if( book == null){

            System.out.println("해당 제목으로 검색된 책이 없습니다.");
            return;
        }

        System.out.print("선택된 책 은"+book + "입니다."+"\n삭제하시겠습니까? 삭제 : 1, 취소: 다른 숫자");
        if(sc.nextInt() == 1){
            bookData.remove(book.getTitle());
            System.out.println("삭제 성공했습니다. ");
        }
        else
            System.out.println("취소했습니다.");
    }

    /***
     * 책 추가 매서드
     */
    public void insertBook(){
        long isbn;
        String title,outhor;

        Scanner sc = new Scanner(System.in);
        System.out.println("책을 추가하기 위해 차례대로 입력을 해주세요.");
        System.out.print("책의 이름을 작성해주세요 :");
        title = sc.nextLine();
        System.out.print("책의 저자를 작성해주세요 :");
        outhor = sc.nextLine();
        System.out.print("책의 ISBN을 작성해주세요 ( - 생략):");
        isbn = sc.nextLong();
        System.out.println(" = ============= =" );
        System.out.print("작성하신 책의 정보는\n제목 : " +title+
                "\n저자 : " + outhor+
                "\nisbn : " +isbn+
                "\n 입니다 등록하시겠습니까? 등록: 1, 취소시 아무 숫자를 눌러주세요. ");
        if(sc.nextInt() ==1){
            bookData.put(title, new BookDTO(isbn,title,outhor,true));
            System.out.println("등록되었습니다.");            
        }
        else System.out.println("등록 취소되었습니다.");
        sc.nextLine();
    }

    public Map<String,BookDTO> getBookData() {
        return bookData;
    }

}
