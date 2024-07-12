package org.com.run;

import org.com.data.BookManager;
import org.com.data.DataManager;
import org.com.dto.BookDTO;

import java.util.Scanner;

/***
 * 파일 입출력으로 보완하려 했으나, 시간이 없어서 다 못했습니다.
 */
public class BookManageApplication {
    //BookDTO를 통한 도서 관리
    public static void main(String[] args) {
        BookManager bookManager =null ;
        DataManager dataManager =new DataManager();

        try {
            bookManager = new BookManager(dataManager.LoadStreamData());
        }
        catch (Exception e) {
            System.out.println(e.getMessage()+"프로그램을 종료합니다. 확인 후 다시 시도해주세요.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        /*필요기능
            대여(부분 조회)
            생성  1
            제거  2
            전체 조회

            끝낸 뒤 저장.9
         */
        int num =0;
        do {
            System.out.println("= ============================================== =");
            System.out.print("도서 관리시스템입니다. 원하는 기능의 숫자를 입력해주세요\n" +
                    "0.대여/반납 1.등록 2.삭제 3.전체 책 조회 9.종료 : ");
            num =sc.nextInt();
            switch (num){
                case 0:{
                    bookManager.borrowBook();
                    break;
                }
                case 1:{
                    bookManager.insertBook();
                    break;
                }
                case 2:{
                    bookManager.deleteBook();
                    break;
                }
                case 3:{
                     bookManager.printBookList();
                    break;
                }
                case 9:{
                    dataManager.SaveStreamData(bookManager.getBookData());
                    break;
                }
            }

        }while (num!=9);

        System.out.println("프로그램을 종료합니다.");
    }
}
