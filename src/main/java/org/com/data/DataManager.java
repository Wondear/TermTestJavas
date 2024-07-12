package org.com.data;

import org.com.dto.BookDTO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataManager {
    private String fileName = "books.txt";
    private String filePath ="src/main/java/org/com/data/";

    public DataManager() {
    }
    public void SaveStreamData(Map<String,BookDTO> books){
        File f = new File(filePath+fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath+fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String,BookDTO> LoadStreamData() throws Exception {
        File f = new File(filePath+fileName);
        FileInputStream fis = null;

        Map books = new HashMap();
        //파일이 없으면 새로 생성후 빈 Set반환
        if(!f.exists()){
            f.createNewFile();
            return new HashMap<String, BookDTO>();
        }

        //파일이 있으면 데이터 추출
        try {
            fis = new FileInputStream(filePath+fileName);
        } catch (FileNotFoundException e) {
            throw new Exception("책 정보를 가져올 수 없습니다.");
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return books;
    }
}
