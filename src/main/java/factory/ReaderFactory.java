package factory;

import logic.reader.EPUBReader;
import logic.reader.PDFReader;
import logic.reader.Reader;
import logic.reader.WordReader;

/**
 * Created by 82646 on 2019/1/23.
 * 创建reader的简单工厂
 */
public class ReaderFactory {

    public Reader createReader(String type){
        if(type.equals("Word")){
            return new WordReader();
        }
        else if(type.equals("PDF")){
            return new PDFReader();
        }
        else if(type.equals("EPUB")){
            return new EPUBReader();
        }

        return null;
    }
}
