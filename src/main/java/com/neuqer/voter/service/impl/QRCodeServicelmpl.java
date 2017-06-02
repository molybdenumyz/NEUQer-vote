package com.neuqer.voter.service.impl;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


import com.google.zxing.WriterException;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.Vote.FormErrorException;
import com.neuqer.voter.mapper.VoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.neuqer.voter.domain.QRCode;
import com.neuqer.voter.service.QRCodeService;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Service("QRCodeService")
public class QRCodeServicelmpl implements QRCodeService {

    private Map<EncodeHintType, Object> hints;
    private MultiFormatWriter multiFormatWriter;
    private static String rootPath = "/Library/WebServer/Documents/";

    @Autowired
    private VoteMapper voteMapper;

    public QRCodeServicelmpl() {
        this.hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        this.multiFormatWriter = new MultiFormatWriter();
    }

    @Override
    public String EnCode(long voteId, String url) throws BaseException {
        QRCode qrCode = new QRCode();

        qrCode.setContents(url);
        qrCode.setVoteId(voteId);
        BitMatrix bitMatrix = null;

        BufferedImage bufferedImageQRCode;
            try {
                bitMatrix = multiFormatWriter.encode(qrCode.getContents(), BarcodeFormat.QR_CODE, qrCode.getWidth(), qrCode.getHeight(), hints);
            }catch (Exception e){
                throw new UnknownException(e.getMessage());
            }

            bufferedImageQRCode = MatrixToImageWriter.toBufferedImage(bitMatrix);
            appendLogo(qrCode, bufferedImageQRCode);




        String path = rootPath + "QRCode" + "/" + qrCode.getVoteId() + "." + qrCode.getFormat();
        voteMapper.insertQaPath(path, voteId);

        return qrCode.getVoteId() + "." + qrCode.getFormat();

    }

    public void appendLogo(QRCode qrCode, BufferedImage image) throws BaseException {

        OutputStream logoStream = null;



            BufferedImage bufferedImage = new BufferedImage(qrCode.getWidth(), qrCode.getHeight(), BufferedImage.TYPE_INT_BGR);
            Graphics2D graphics2d = bufferedImage.createGraphics();
            graphics2d.drawImage(image, 0, 0, qrCode.getWidth(), qrCode.getHeight(), null);

            int matrixWidth = bufferedImage.getWidth();
            int matrixHeigh = bufferedImage.getHeight();
            System.out.println(qrCode.getLogo_path());
            BufferedImage logo = null;
            try {
                logo = ImageIO.read(new File(qrCode.getLogo_path()));
            }catch (Exception e){
                throw new UnknownException(e.getMessage());
            }


            graphics2d.drawImage(logo, matrixWidth / 2 - 18, matrixHeigh / 2 - 18, matrixWidth / 8, matrixHeigh / 8, null);
            BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            graphics2d.setStroke(stroke);// 设置笔画对象
            //指定弧度的圆角矩形  
            RoundRectangle2D.Float round = new RoundRectangle2D.Float(matrixWidth / 2 - 18, matrixHeigh / 2 - 18, matrixWidth / 8, matrixHeigh / 8, 20, 20);
            graphics2d.setColor(Color.white);
            graphics2d.draw(round);// 绘制圆弧矩形  

            //设置logo 有一道灰色边框  圆弧包围
            BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            graphics2d.setStroke(stroke2);// 设置笔画对象  
            RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(matrixWidth / 2 - 15, matrixHeigh / 2 - 15, matrixWidth / 8 - 4, matrixHeigh / 8 - 4, 20, 20);
            graphics2d.setColor(new Color(128, 128, 128));
            graphics2d.draw(round2);// 绘制圆弧矩形  
            graphics2d.dispose();

            bufferedImage.flush();


                try {
                    logoStream = new FileOutputStream(rootPath + "QRCode" + "/" + qrCode.getVoteId() + "." + qrCode.getFormat());
                }catch (Exception e){
                    throw new FormErrorException(e.getMessage());
                }

                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(logoStream);

               try{
                   encoder.encode(bufferedImage);
               }catch (Exception e){
                   throw new FormErrorException(e.getMessage());
               }


            if (logoStream != null) {
                try {
                    logoStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

