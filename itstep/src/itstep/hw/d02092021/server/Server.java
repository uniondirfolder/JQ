package itstep.hw.d02092021.server;

import hw.d22082021.abstracts.Developer;
import itstep.hw.d02092021.client.Client;
import itstep.hw.d02092021.general.ConnectException;
import itstep.hw.d02092021.general.FileManager;
import itstep.hw.d02092021.general.Message;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.TimeUnit;
@Developer
public class Server implements Serializable, Chat {
    transient private int port;
    transient private Deque<Message> messageList;
    private List<Message> messageListArc;
    transient private List<ClientSocket> clientSocketList;
    transient volatile private boolean isAlive = true;
    transient private ServerSocket serverSocket;
    transient private final String backUp = "backup.dat";

    public Server(int port) {
        File file = new File(backUp);
        this.port = port;
        if (file.exists()) {
            new FileManager<List<Message>>().readFileDeSerialize(backUp);
        }
        this.messageList = new LinkedList<>();
        this.messageListArc = new ArrayList<>();
        Long time = new Date().getTime();
        this.messageList.add(new Message("admin", "hello ysem!", time.toString()));
        this.clientSocketList = new LinkedList<>();
        new Thread(new Sender()).start();
    }

    @Override
    public void start() {
        System.out.println("start");

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("created");
            while (isAlive) {
                Socket socket = serverSocket.accept();
                System.out.println("connected " + socket.getInetAddress() + " " + socket.getPort());
                ClientSocket cs = new ClientSocket(socket);
                Thread th = new Thread(cs);
                th.start();
                clientSocketList.add(cs);
                System.out.println("New client");
                System.out.println("Active clients => " + clientSocketList.size());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        new FileManager<List<Message>>().writeFileSerialize("backup.dat", messageListArc);
        System.out.println("stop");
    }

    @Override
    public void sendMessage(String msg, Client client) {
        try {
            client.sendMessage(msg);
        } catch (ConnectException e) {
            e.printStackTrace();
        }
    }

    class Sender implements Runnable {
        private int nextSend = 0;

        @Override
        public void run() {
            Message tmp;
            String str = "";
            while (isAlive) {
                synchronized (messageList) { // if not  -> exception on operation delete
                    while (messageList.size() > 0) {
                        tmp = messageList.pop();
                        str = tmp.toString();
                        messageListArc.add(tmp);
                        for (int w = 0; w < clientSocketList.size(); w++) {
                            ClientSocket next = clientSocketList.get(w);
                            next.sendMsg(str);
                        }
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ClientSocket implements Runnable {
        private Socket socket;
        private Scanner readFromClient;
        private PrintWriter sendToClient;
        private Message msg;
        private boolean clientExit = false;


        public ClientSocket(Socket socket) {
            this.socket = socket;
            try {
                this.readFromClient = new Scanner(socket.getInputStream());
                this.sendToClient = new PrintWriter(socket.getOutputStream());
                Long time = new Date().getTime();
                this.msg = new Message("server", "WELCOME to CHAT", time.toString());
                sendMsg(msg.toString());
                for (Message msg : messageListArc) {
                    sendMsg(msg.toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendMsg(String msg) {
            sendToClient.println(msg);
            sendToClient.flush();
        }

        @Override
        public void run() {
            while (!clientExit) {
                if (readFromClient.hasNextLine()) {
                    msg = new Message(readFromClient.nextLine());
                    if (!msg.isEmpty()) {
                        messageList.add(new Message(msg));
                        System.out.println(msg.print());
                        if (("exit").equals(msg.getBody())) {
                            clientExit = true;
                        }
                        if ("kill_djo".equals(msg.getBody())) {
                            isAlive = false;
                        }
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int count = 0;
            for (Iterator<ClientSocket> iterator = clientSocketList.iterator(); iterator.hasNext(); ) {
                ClientSocket next = iterator.next();
                if (next.equals(this)) {
                    clientSocketList.remove(count);
                    break;
                }
                count++;
            }
            System.out.println("Active clients => " + clientSocketList.size());

            if (socket != null && !socket.isClosed()) {
                msg = null;
                readFromClient.close();
                sendToClient.close();
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ClientSocket)) return false;
            ClientSocket that = (ClientSocket) o;
            return socket.equals(that.socket) && readFromClient.equals(that.readFromClient) && sendToClient.equals(that.sendToClient) && msg.equals(that.msg);
        }

        @Override
        public int hashCode() {
            return Objects.hash(socket, readFromClient, sendToClient, msg);
        }
    }
}
