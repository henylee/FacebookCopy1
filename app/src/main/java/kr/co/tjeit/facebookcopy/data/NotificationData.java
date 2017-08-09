package kr.co.tjeit.facebookcopy.data;

/**
 * Created by the on 2017-08-08.
 */

public class NotificationData {

    private String imagePath;
    private String notificationText;
    private int notificationType;
    private int minuteAgo;

    public NotificationData() {

    }

    public NotificationData(String imagePath, String notificationText, int notificationType, int minuteAgo) {
        this.imagePath = imagePath;
        this.notificationText = notificationText;
        this.notificationType = notificationType;
        this.minuteAgo = minuteAgo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public int getMinuteAgo() {
        return minuteAgo;
    }

    public void setMinuteAgo(int minuteAgo) {
        this.minuteAgo = minuteAgo;
    }
}
