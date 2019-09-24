
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;

import java.util.List;


public class SQSRecieve {

    public static void receive(String queueUrl) {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        //String queueUrl = "https://sqs.us-west-2.amazonaws.com/074808275502/QueueA";
        List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();

        // delete messages from the queue
        for (Message m : messages) {
            sqs.deleteMessage(queueUrl, m.getReceiptHandle());
            System.out.println(m.getBody());
        }
    }
}