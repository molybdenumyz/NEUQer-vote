package com.neuqer.voter.common;

import java.io.*;
import java.util.List;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.VoteRecord;
import com.neuqer.voter.dto.request.RecordRequest;
import com.neuqer.voter.dto.response.OptionValue;
import com.neuqer.voter.dto.response.ValueRecordResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Created by yinzhe on 17/5/18.
 */


public class Excel {

    public void objListToExcel(RecordRequest records,OutputStream os) throws IOException {
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
            cell_1.setCellValue(i-1);
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

        wb.write(os);

    }

    public void ValueRecordExcel(ValueRecordResponse response,OutputStream os) throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet(response.getTitle()+"投票结果统计");


        HSSFRow row2 = sheet.createRow(0);

        HSSFCell cell2_1 = row2.createCell((short)0);
        cell2_1.setCellValue("选项序号");

        HSSFCell cell2_2 = row2.createCell((short)1);
        cell2_2.setCellValue("选项内容");


        List<OptionValue> optionValueList = response.getOptionValue();
        HSSFCell cell3 =row2.createCell(response.getParticipatorNum()+2);
        cell3.setCellValue("总计");
        int i =1;
        for (OptionValue optionValue:optionValueList
                ) {
            HSSFRow row = sheet.createRow(i);
            i++;
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(optionValue.getId());
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(optionValue.getTitle());
            int j = 2;
            for (int value:optionValue.getVoteRecords()
                    ) {
                HSSFCell topCell = row2.createCell(j);
                topCell.setCellValue("#"+(j-1));

                HSSFCell hssfCell = row.createCell(j);
                hssfCell.setCellValue(value);
                j++;
            }
            HSSFCell cell2 = row.createCell(j);
            cell2.setCellValue(optionValue.getSum());
        }

        wb.write(os);

    }
}
