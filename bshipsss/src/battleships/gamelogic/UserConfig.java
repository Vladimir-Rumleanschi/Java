package battleships.gamelogic;

/**
 * UserConfig
 *
 * Holds all the information needed to connect to the server and to identify
 * this user.
 *
 */
public class UserConfig {

    private String username;
    private String host = "127.1.0.0";
    private String port = "1234";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
