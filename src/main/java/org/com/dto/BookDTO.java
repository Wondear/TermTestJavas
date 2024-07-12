package org.com.dto;

public class BookDTO {
    private long isbn;
    private String title;
    private String outhor;
    private boolean canBarrow;

    private BookDTO() {
    }

    public BookDTO(long isbn, String title, String outhor, boolean isBarrow) {
        this.isbn = isbn;
        this.title = title;
        this.outhor = outhor;
        this.canBarrow = isBarrow;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getOuthor() {
        return outhor;
    }

    public boolean isCanBarrow() {
        return canBarrow;
    }

    public void setCanBarrow(boolean canBarrow) {
        this.canBarrow = canBarrow;
    }

    @Override
    public String toString() {
        return  "제목 : " + title + "\n책 정보. 저자 :"+outhor +"\nisbn :" + isbn+ "\n대출상태 : " +(canBarrow ?"가능":"대여중");
    }
}
