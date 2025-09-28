import org.eclipse.paho.client.mqttv3.*;
import JavaGui.Example1.GUI;

import java.util.ArrayList;

public class SimpleCallback  /*implements MqttCallback*/ {
    static String[] tempReadings = new String[]{"temp/30/hum/40","temp/29/hum/45","temp/38/hum/30","temp/35/hum/35","temp/35/hum/35"};
    static int arrayPos = 0;
    static int temperature;
    static int humidity;
    static public ArrayList<Integer> tempArray = new ArrayList<>();
    static public ArrayList<Integer> humArray = new ArrayList<>();

    public static void main(String[] args){

    /*         String topic = "a00273290";
//Note: This broker is temporary to get you up and running. Change the topic to
// include your studentID so that your topic does not clash with someone else in the class
        String broker =  "tcp://192.168.1.100:1883"; //"tcp://mqtt.eclipse.org:1884";
        String clientId = "Java Subscriber";

       try {
            MqttClient sampleClient = new MqttClient(broker, MqttClient.generateClientId());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);

            sampleClient.setCallback(new SimpleCallback());
            sampleClient.subscribe(topic, 1);
            System.out.println("Connected");
            while(true){
                try {
                   Thread.sleep(10000);
                   System.out.println("did i get a message?" + topic);
                   sampleClient.
                   sampleClient.disconnect();
               } catch(Exception e) {
                    e.printStackTrace();
                }
            }

             System.out.println("Disconnected");
            System.exit(0);
        } catch(MqttException e){
            e.printStackTrace();
        }*/
        new GUI();
    }

    // One of the three Interface MqttCallback's methods that must be included
    //Called when the client lost the connection to the broker
    // we can override it with our own functionality but for now we do nothing

    //@Override
    public void connectionLost(Throwable cause) {
    }

    // One of the three Interface MqttCallback's methods that must be included
    // Use for when a message arrives via the broker from the publisher of
    // the topic we subscribed to  - room1/sensehat/temp.
    // We override the method with what we would like to do with the value of the
    // temp received
    // For now we get the payload (the temp) and parse it from String to double

    // using this method since mqtt doesnt run correctly
    public static void messageArrived1(){
        //take in one value from the hardcoded values
        String messageRecieved = tempReadings[arrayPos];
        System.out.println(messageRecieved);

        //split the string into an array. the temp should be at index 1, and humidity at index 3
        String[] values = messageRecieved.split("/");
        temperature = Integer.parseInt(values[1]);
        humidity = Integer.parseInt(values[3]);

        //add the values into an array list to be taken and displayed by the gui
        tempArray.add(temperature);
        humArray.add(humidity);

        // if there is still more elements in the array, call method again to take the next value
        if(arrayPos < tempReadings.length - 1){
            arrayPos++;
            messageArrived1();
        }
    }

    // use this method if mqtt does run correctly
    //@Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {

        // Print  the topic, the String message and the double value

        System.out.println("-------------------------------------------------");
        System.out.println("| Topic:" + topic);
        System.out.println("| Message: " + new String(message.getPayload()));
        System.out.println("-------------------------");

        // convert the payload recieved through mqtt into a string
        String stringValue = new String(message.getPayload());

        //split the string into an array. the temp should be at index 1, and humidity at index 3
        String[] values = stringValue.split("/");
        temperature = Integer.parseInt(values[1]);
        humidity = Integer.parseInt(values[3]);

        //add the values into an array list to be taken and displayed by the gui
        tempArray.add(temperature);
        humArray.add(humidity);

        // Create a Room object with the temp value
        //which has a getter and setter for the Temperature value and Id for the reading

        //Rooms r1= new Rooms(value);

        // Get the temp value and the Id for the
        //which has a getter and setter for the Temperature value

        //System.out.println("The temperature for reading number "+r1.getId()+ " is "+r1.getTemp());

    }

    // One of the three Interface MqttCallback's methods that must be included
    // Called when an outgoing publish is complete
    // As this client is only subscribing, this method is not used but
    // it must be included as it is one of the interface MqttCallBack Methods


    // @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    }



}
