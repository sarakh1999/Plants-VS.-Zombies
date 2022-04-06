package Controller.Server;

//package Controller.Server;
//
//import com.gilecode.yagson.YaGson;
//
//import java.io.IOException;
//
public class ClientHandler extends Thread {
//    public boolean endOfClient = false;
//    //  private Transmitter transmitter;
//    private controller.server.SocketClass socketClass;
//
//    public ClientHandler(controller.server.SocketClass socketClass) {
//        this.socketClass = socketClass;
//        //  transmitter = socketClass.getTransmitter();
//    }
//
//    public void run() {
//
//        while (socketClass.getIn().hasNextLine()) {
//            try {
//                if (socketClass == null || socketClass.getIn() == null)
//                    break;
//
//                String line = socketClass.getIn().nextLine();
//                YaGson mapper = new YaGson();
//              //  Transmitter transmitter = mapper.fromJson(line, Transmitter.class);
//                if (transmitter != null) {
//                //    RequestEnumController.main(transmitter.requestEnum, socketClass, transmitter);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                break;
//            }
//
//
//            if (endOfClient) {
//                try {
//                    socketClass.getSocket().close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//
//    }
//
//
}