package com.cybertek.tests.Day10_FileUploaded;

import org.testng.annotations.Test;

public class FilePathExample {
    //C:\Users\User\IdeaProjects\EU3TestNGSelenium\src\test\resources\textfile.txt

    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir"));
        String projectPath = System.getProperty("user.dir");//textile.txt dosy uzer saga tikla once copy sonra Absolute pathi tikla
        String filePath="src/test/resources/textfile.txt";//textile.txt dosy uzer saga tikla once copy sonrapath from content root
        String fullPath=projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);
    }
}
