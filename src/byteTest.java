import java.io.*;

public class byteTest {
    public void readByteFromFile(String path) throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(path));
        byte[] readByte = new byte[4800];
        File file = new File("C:/Users/hao/Desktop/audio/audioGet1-6-8.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        for (int i = 0; (i = in.read(readByte)) != -1; ) {
            for(int j = 0; j<readByte.length;j++) {
                String tmp = Integer.valueOf(readByte[j])+"\r\n";
                out.write(tmp);
            }

        }

        in.close();
        out.close();

    }

    public void changeFormatFromRaw(String path) throws  IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        String line = null;
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:/Users/hao/Desktop/gyro/gyroSensorDataGet1.txt")));
        while((line = reader.readLine()) != null)
        {
            System.out.print(line);
            String []values = line.split("[:, ]");
            String newLine = values[1] +" " + values[3] +" "+ values[5] +"\r\n";
            writer.write(newLine);
            writer.flush();
        }

        reader.close();

        writer.close();


    }
}
