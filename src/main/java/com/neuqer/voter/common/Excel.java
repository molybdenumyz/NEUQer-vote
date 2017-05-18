package com.neuqer.voter.common;

import java.io.*;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.VoteRecord;
import com.neuqer.voter.dto.request.RecordRequest;
import com.neuqer.voter.dto.response.ValueRecordResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Created by yinzhe on 17/5/18.
 */


public class Excel {
    final static String SERVER_PATH = "/Library/WebServer/Documents/record/";

    public String  objListToExcel(RecordRequest records) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet(records.getTitle()+"投票结果统计");


        HSSFRow row2 = sheet.createRow(0);

        HSSFCell cell2_1 = row2.createCell((short)0);
        cell2_1.setCellValue("选项序号");

        HSSFCell cell2_2 = row2.createCell((short)1);
        cell2_2.setCellValue("选项内容");

        HSSFCell cell2_3 = row2.createCell((short)2);
        cell2_3.setCellValue("数量");

        HSSFCell cell2_4 = row2.createCell((short)3);
        cell2_4.setCellValue("占比");

        int i =1;
        int total = 0;
        for (Option option:records.getOptions()
             ) {
            total = total + option.getNum();
            HSSFRow hssfRow = sheet.createRow(i);
            i++;
            HSSFCell cell_1 = hssfRow.createCell(0);
            cell_1.setCellValue(option.getId());
            HSSFCell cell_2 = hssfRow.createCell(1);
            cell_2.setCellValue(option.getTitle());
            HSSFCell cell_3 = hssfRow.createCell(2);
            cell_3.setCellValue(option.getNum());
            HSSFCell cell_4 = hssfRow.createCell(3);
            cell_4.setCellValue(option.getValue()+"%");
        }
        System.out.println(i);
        HSSFRow hssfRow = sheet.createRow(i);

        HSSFCell cell = hssfRow.createCell(0);
        cell.setCellValue("总计");
        HSSFCell cell_2 = hssfRow.createCell(2);
        cell_2.setCellValue(total);
        HSSFCell cell_3 = hssfRow.createCell(3);
        cell_3.setCellValue("100%");
        File file = new File(SERVER_PATH+records.getId()+records.getTitle()+"票数统计.xls");

        FileOutputStream fileOutputStream = new FileOutputStream(file);


        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }


        wb.write(fileOutputStream);

        fileOutputStream.close();

        return "/record/"+records.getId()+records.getTitle()+"票数统计.xls";
    }

    public String ValueRecordExcel(ValueRecordResponse response) throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet(response.getTitle()+"投票结果统计");


        HSSFRow row2 = sheet.createRow(0);

        HSSFCell cell2_1 = row2.createCell((short)0);
        cell2_1.setCellValue("选项序号");

        HSSFCell cell2_2 = row2.createCell((short)1);
        cell2_2.setCellValue("选项内容");





        int total = 0;
        int j = 2;
        for (int i =1 ; i<=response.getOptions().size();i++){
            Option option = response.getOptions().get(i-1);
            total = total + option.getNum();
            HSSFRow hssfRow = sheet.createRow(i);
            i++;
            HSSFCell cell_1 = hssfRow.createCell(0);
            cell_1.setCellValue(option.getId());
            HSSFCell cell_2 = hssfRow.createCell(1);
            cell_2.setCellValue(option.getTitle());

            for (VoteRecord record:response.getValuelist()
                 ) {
                if (record.getOptionId() == option.getId()){
                    HSSFCell topCell = row2.createCell(j);
                    topCell.setCellValue("#"+(j-1));

                    HSSFCell cell = hssfRow.createCell(j);
                    cell.setCellValue(record.getValue());
                    j++;
                }
                else
                    continue;
            }

            HSSFCell cell_3 = hssfRow.createCell(j+1);
            cell_3.setCellValue(option.getValue());
        }

        HSSFCell cell2_3 = row2.createCell((short)j+1);
        cell2_3.setCellValue("合计");

        File file = new File(SERVER_PATH+response.getVoteId()+response.getTitle()+"票数统计.xls");

        FileOutputStream fileOutputStream = new FileOutputStream(file);


        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        wb.write(fileOutputStream);

        fileOutputStream.close();
        return "/record/"+response.getVoteId()+response.getTitle()+"票数统计.xls";
    }
}
