import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hsbc.sapi")
public class SapiProperties {

    private int timeout;
    private int retries;
    private int backoff;
    private int delay;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public int getBackoff() {
        return backoff;
    }

    public void setBackoff(int backoff) {
        this.backoff = backoff;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
