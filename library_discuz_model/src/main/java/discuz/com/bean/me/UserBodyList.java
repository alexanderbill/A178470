package discuz.com.bean.me;

import java.util.ArrayList;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class UserBodyList {

    private ArrayList<Profile> profileList;
    private ArrayList<Profile> creditList;
    private ArrayList<Profile> creditShowList;

    public ArrayList<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(ArrayList<Profile> profileList) {
        this.profileList = profileList;
    }

    public ArrayList<Profile> getCreditList() {
        return creditList;
    }

    public void setCreditList(ArrayList<Profile> creditList) {
        this.creditList = creditList;
    }

    public ArrayList<Profile> getCreditShowList() {
        return creditShowList;
    }

    public void setCreditShowList(ArrayList<Profile> creditShowList) {
        this.creditShowList = creditShowList;
    }
}
