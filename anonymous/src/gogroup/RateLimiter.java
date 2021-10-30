/*
package gogroup;

// FR : Generate secret token
//      Blacklist token
//      Limit on hour, day, month
//      User <-> secret_token

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class RateLimiter {

    TokenGeneratorService tokenGeneratorService;
    // Authenticated
    String generateToken(User user) {
        // Validation checks for number of tokens generated
        return tokenGeneratorService.generate();
    }

    boolean isValidUser(User user) {
        return true;
    }

    boolean validHit(UserToken userToken) {

    }
}

class TokenGeneratorService {

    private int length;
    private Algo defaultAlgo;
    public void init(int length) {
       this.length = length;
    }

    String generate() {
        // length and defaultAlgo
        //
        return "";
    }

    boolean validToken() {

    }
}

class CounterService {
    // RedisService
    DBService dbService;

    CounterService() {
        dbService = new RedisService();
    }

    void updateCounter(UserToken userToken) {
        // token
        // last_hit_time
        // total_hits
        Date last_hit = dbService.get(userToken);
        long difference = differenceTime(last_hit);
        // store only those hits which are in the difference of minute, hour or day
    }

    private Limit identifyLimit(long difference) {
        Promise.all {} // nodejs
        ExecutorService executorService;
        List<Limit> limitList = new ArrayList<>();
        limitList.add(new MinuteLimit().satifies(difference));
        limitList.add(new HourLimit().satifies(difference));
        // Multi- threading or Asynchronous checks

        Limit minuteLimit = new MinuteLimit(); // found the minute limit
        // Find last hit within a minute
        // Find last hit within an hour
        // Find last hit within a day
    }

    private long differenceTime(Date lastHit) {
        return (long) new Date() - lastHit;
    }
}

interface DBService {

}

class RedisService implements DBService {

}

class RelationService implements DBService {

}

enum Algo {

}

class User {
    String id; // uuid
    String username;
    String password; // SSO via googleauth
    String email;
}

class UserToken {
    private String userId;  // represents userId -- map or not
    private String secret; // base64 encoded
}

abstract class Limit {
    abstract void valid(UserToken userToken);
    abstract boolean satifies(Long difference);
    abstract void storeCount(UserToken userToken, long ttl);
    String errorNotification() {
       return ";";
    } // i18n
}

class MinuteLimit extends Limit {

    UserToken userToken;
    DBService dbService;

    public void init(UserToken userToken) {
       this.userToken = userToken;
       this.dbService = new RedisService('minute');
    }

    @Override
    void valid() {

    }

    @Override
    boolean satifies(Long difference) {
        return false;
    }

    String errorNotification() {

    }

    void storeCount() {
        this.dbService.put(userToken, new Date(), ttl : 60);
    }
}

class HourLimit extends Limit {

}

class DayLimit  extends Limit {

}




*/
