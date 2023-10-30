package user;
import random.RandomString;


public class CreateRandomUserData {
    public static User createRandomUserData(){
        return new User(RandomString.generateRandomHexString(10) + "@mail.ru",
                RandomString.generateRandomHexString(10),
                RandomString.generateRandomHexString(10));
    }
}
