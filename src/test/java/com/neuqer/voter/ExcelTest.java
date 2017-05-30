package com.neuqer.voter;

import com.neuqer.voter.common.Excel;
import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.dto.request.RecordRequest;
import com.neuqer.voter.dto.response.RecordsResponse;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by yinzhe on 17/5/18.
 */

public class ExcelTest {


    public static void main(String args[]) {
        try {


            List<Option> options = new ArrayList<>();
            Option option = new Option();
            option.setValue(51);
            option.setNum(10);
            option.setTitle("ti1");
            option.setId(1);
            options.add(option);

            Option option1 = new Option();
            option1.setId(2);
            option1.setNum(10);
            option1.setTitle("ti2");
            option1.setValue(49);
            options.add(option1);
            RecordRequest recordRequest = new RecordRequest();
            recordRequest.setId(1);
            recordRequest.setTitle("全场最佳");
            recordRequest.setOptions(options);
            Excel excel = new Excel();
            //excel.objListToExcel(recordRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
