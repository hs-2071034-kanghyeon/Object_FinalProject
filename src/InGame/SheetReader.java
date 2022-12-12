package InGame;

import InGame.Schema.NodeInfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SheetReader {

    List<NodeInfo> nodes = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        new SheetReader().read();
    }

    public Queue<NodeInfo> read() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("Sheets/test3.txt")
        );

        Queue<NodeInfo> nodeInfos = new LinkedList<>();
        String str;
        while ((str = reader.readLine()) != null) {
            int time = (int)(Float.valueOf(str.split(",")[0].trim()) * 1000);
            int line = Integer.valueOf(str.split(",")[1].trim());
            int length = Integer.valueOf(str.split(",")[2].trim());
            NodeInfo nodeInfo = new NodeInfo(time,line,length);
            nodeInfos.add(nodeInfo);
            System.out.println(str);
        }
        reader.close();
        return nodeInfos;

    }
}
