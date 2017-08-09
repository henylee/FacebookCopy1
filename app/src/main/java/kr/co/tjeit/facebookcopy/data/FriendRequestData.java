package kr.co.tjeit.facebookcopy.data;

/**
 * Created by the on 2017-08-08.
 */

public class FriendRequestData {

    private String imagePath;
    private int commonFriendCount;
    private String name;

    public FriendRequestData() {

    }

    public FriendRequestData(String imagePath, int commonFriendCount, String name) {
        this.imagePath = imagePath;
        this.commonFriendCount = commonFriendCount;
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getCommonFriendCount() {
        return commonFriendCount;
    }

    public void setCommonFriendCount(int commonFriendCount) {
        this.commonFriendCount = commonFriendCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
