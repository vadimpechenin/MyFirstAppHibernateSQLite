package envelope;
import controller.ProfileService;
import controller.UserService;
import model.*;

import java.util.ArrayList;


public class ObjectFactory
    {
        private static volatile ObjectFactory _objectFactory;
        private static final Object _objectFactoryLock = new Object();

    private ObjectFactory() {
    }

        public static ObjectFactory getObjectFactory () {
        if (_objectFactory == null) {
            synchronized (_objectFactoryLock) {
                if (_objectFactory == null) {
                    _objectFactory = new ObjectFactory();
                }
            }
        }

        return _objectFactory;
    }

        public String CreateID () {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

        public String CreateIDUser () {
            ArrayList<User> users = new ArrayList<>();
            UserService.GetUsers(null, null, users);
            Integer item = users.size()+1;
            return item.toString();
        }

        public String CreateIDProfile () {
            ArrayList<Profile> profiles = new ArrayList<>();
            ProfileService.GetProfiles(null, profiles);
            Integer item = profiles.size()+1;
            return item.toString();
        }

        public User CreateUser() {
        User result = new User();
        result.ID = CreateIDUser();
        return result;
    }

        public Profile CreateProfile() {
            Profile result = new Profile();
            result.ID = CreateIDProfile();
            return result;
        }
}
