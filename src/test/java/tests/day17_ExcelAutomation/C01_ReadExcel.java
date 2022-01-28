package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class C01_ReadExcel {
    // 7. Dosya yolunu bir String degiskene atayalim
    //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //10. WorkbookFactory.create(fileInputStream)
    //11. Worksheet objesi olusturun workbook.getSheetAt(index)
    //12. Row objesi olusturun sheet.getRow(index)
    //13. Cell objesi olusturun row.getCell(index)

    @Test
    public void test() throws IOException {

        String path = "src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(2);

        Cell cell = row.getCell(3);

        System.out.println(cell);
    }
    @Test
    public void test2() throws IOException {
        //daha basit bir yontem ile deneyecegiz

        String path = "src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Cell cell = workbook.getSheet("Sayfa1").getRow(7).getCell(3);

        System.out.println(cell);

        //secilen hucredeki yazinin Buenos Aires oldugunu test edin
        //assert ile yapamayiz cunku cell in turu cell, Buenos Aires in turu ise string
        //bundan oturu equal methodunu kullanamayiz
        Assert.assertEquals(cell.toString(),"Buenos Aires");
        Assert.assertEquals(cell.getStringCellValue(),"Buenos Aires");

        //indexi 3 olan satirdaki, indexi 2 olan hucredeki yaziyi buyuk harfle yazdirin

        Cell cell1 = workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase());

        // getLastRowNum() bize son satirin index'ini verir
        // getPhysicalNumberOfRows() ise fiili olarak kullanilan satir sayisini verir
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

    }
    @Test(groups = "birinci grup")
    public void test3() throws IOException {
        //tablodaki tum hucreleri bir liste olarak yazdirin
        List<String> ikinciSutun = new ArrayList<>();

        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        for (int i = 0; i<= workbook.getSheet("Sayfa1").getLastRowNum(); i++){

            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());

        }
        System.out.println(ikinciSutun);

        //A ile baslayan sehirleri liste yapip yazdirin
        List<String> aIleBaslayanlar = new ArrayList<>();

        for (String each: ikinciSutun
             ) {
            if (each.startsWith("A")){
                aIleBaslayanlar.add(each);
            }
        }
        System.out.println(aIleBaslayanlar);
        // eger tum datayi java'da kullanilabilir bir collection'a cevirmek istesek
        // en uygun yapi map olur
        // map icin unique degerlere sahip bir sutunu key
        // geriye kalan tum sutunlari ise virgulle ayrilan string'ler olarak value yapmaliyiz
        // key=Turkey value=Ankara, Turkiye, Ankara

        Map<String,String> ulkelerMap = new HashMap<>();
        String key = "";
        String value = "";

        for (int i = 0; i<=workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + " , " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + " , " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);


    }




}
