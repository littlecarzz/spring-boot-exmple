package com.cjj.service;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/22 10:08
 */
public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);

    public void sendHtmlMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
