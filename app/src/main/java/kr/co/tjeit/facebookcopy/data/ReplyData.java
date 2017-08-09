package kr.co.tjeit.facebookcopy.data;

import java.util.Calendar;

/**
 * Created by the on 2017-08-09.
 */

public class ReplyData {

    private int replyId;
    private int parentReplyId;

    private String replyUserName;
    private String replyContentTxt;
    private Calendar replyMinuteAgo;

    public ReplyData() {

    }

    public ReplyData(int replyId, int parentReplyId, String replyUserName, String replyContentTxt, Calendar replyMinuteAgo) {
        this.replyId = replyId;
        this.parentReplyId = parentReplyId;
        this.replyUserName = replyUserName;
        this.replyContentTxt = replyContentTxt;
        this.replyMinuteAgo = replyMinuteAgo;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getParentReplyId() {
        return parentReplyId;
    }

    public void setParentReplyId(int parentReplyId) {
        this.parentReplyId = parentReplyId;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public String getReplyContentTxt() {
        return replyContentTxt;
    }

    public void setReplyContentTxt(String replyContentTxt) {
        this.replyContentTxt = replyContentTxt;
    }

    public Calendar getReplyMinuteAgo() {
        return replyMinuteAgo;
    }

    public void setReplyMinuteAgo(Calendar replyMinuteAgo) {
        this.replyMinuteAgo = replyMinuteAgo;
    }
}
