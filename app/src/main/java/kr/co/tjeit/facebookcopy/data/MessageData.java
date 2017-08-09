package kr.co.tjeit.facebookcopy.data;

import java.util.Calendar;

/**
 * Created by the on 2017-08-08.
 */

public class MessageData {

    private int sendUserId;
    private String contenet;
    private Calendar sendTime;

    public MessageData() {

    }

    public MessageData(int sendUserId, String contenet, Calendar sendTime) {
        this.sendUserId = sendUserId;
        this.contenet = contenet;
        this.sendTime = sendTime;
    }

    public int getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(int sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getContenet() {
        return contenet;
    }

    public void setContenet(String contenet) {
        this.contenet = contenet;
    }

    public Calendar getSendTime() {
        return sendTime;
    }

    public void setSendTime(Calendar sendTime) {
        this.sendTime = sendTime;
    }
}
