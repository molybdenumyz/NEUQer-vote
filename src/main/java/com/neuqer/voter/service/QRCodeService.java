package com.neuqer.voter.service;

import com.google.zxing.WriterException;

import java.io.IOException;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface QRCodeService {
	
	String EnCode(long voteId,String url) throws WriterException, IOException;

}
