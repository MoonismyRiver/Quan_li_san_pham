package IO;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteProduct {
    File file = new File("C:\\Users\\admin\\Desktop\\Module 2\\ThiThucHanhModule2\\src\\student.csv");

    public void write(List<Product> products) {

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,name,price,amount");
            bufferedWriter.newLine();
            for (Product s : products) {
                bufferedWriter.write(s.write());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Product> read() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                int amount = Integer.parseInt(arr[3]);

                arr.add(new Product(id, name, price,amount));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;

    }
}
