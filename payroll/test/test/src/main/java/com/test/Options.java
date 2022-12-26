package com.test;

import com.test.fileImport.CSVFileImport;
import com.test.fileImport.IFileImport;

public class Options {

    public void importFile(String fileName) throws Exception {

        IFileImport fileImport = new CSVFileImport();
        fileImport.importFile(fileName);
    }

}
