package com.neuqer.voter.mapper;

import com.neuqer.voter.domain.Option;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface OptionMapper {

    List<Option> listOptions(@Param("voteId") long voteId);

    Option getOption(@Param("optionId") long optionId);

    Integer createOption(List<Option> options);

    Integer deleteOption(@Param("voteId") long voteId);

    Integer deleteOptionByProblemId(@Param("problemId") long problemId);

    Integer updateOptionValue(@Param("optionId") long optionId, @Param("optionValue") long optionValue);

    Integer updateOptionChooseNum(@Param("optionId") long optionId);
}
