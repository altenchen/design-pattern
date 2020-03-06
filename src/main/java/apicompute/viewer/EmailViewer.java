package apicompute.viewer;

import apicompute.EmailSender;
import apicompute.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @create: 2020/3/3
 * @author: altenchen
 */
public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/);
    }

    public EmailViewer(List<String> toAddresses) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        // format the requestStats to HTML style.    // send it to email toAddresses.  }}
    }

}
