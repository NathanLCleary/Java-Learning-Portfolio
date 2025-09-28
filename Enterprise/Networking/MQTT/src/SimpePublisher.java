import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class SimpePublisher {
    public static void main(String[] args) {
        String topic        = "test";
        // String content1  = args[0]+"Pascal";
        int qos             =  1;
        String broker       = "tcp://192.168.0.102:1883";
        String PubId        = "127.0.0.1";
        MemoryPersistence persistence = new MemoryPersistence();

        String content1 = "Test";

        // long startTime = System.nanoTime();
        try {

            MqttClient sampleClient = new MqttClient(broker,MqttClient.generateClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setConnectionTimeout(60);
            connOpts.setKeepAliveInterval(60);
            connOpts.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
            System.out.println("Connecting to broker: "+ broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+ content1);
            MqttMessage message = new MqttMessage(content1.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic,message);
            System.out.println("Message published");

        } catch(MqttException me) {
            System.out.println("Reason :"+ me.getReasonCode());
            System.out.println("Message :"+ me.getMessage());
            System.out.println("Local :"+ me.getLocalizedMessage());
            System.out.println("Cause :"+ me.getCause());
            System.out.println("Exception :"+ me);
            me.printStackTrace();
        }
    }

}
