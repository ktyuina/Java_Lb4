
package kolektsii;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;

public class MyQueue{
    /**
     * ������� ������������ �����
     */
    private Queue<Double> queue = new LinkedList<>();

    /**
     * ��������� �������� � ������� � �������
     * @param scan 
     * @param count ���������� ����� � �������
     */
    public void fillQueue(Scanner scan, int count) {
        for(int i = 0; i < count; i++){
            while (true){
                if (scan.hasNextDouble()) {
                    queue.offer(scan.nextDouble());
                    break;
                } else {
                    System.out.println("������: ������� ������������ �����");
                    scan.next(); 
                }
            }
        }
    }

    /**
     * ��������� ����������� �����
     */
    public void cyclicShift() {
        double max = queue.peek();
        int index = 0;

        int i = 0;
        for (double num : queue) {
            if (num > max) {
                max = num;
                index = i;
            }
            i++;
        }

        for (int j = 0; j < index; j++) {
            queue.offer(queue.remove());
        }
        //double maxValue = queue.remove();

        //queue.offer(maxValue);
    }

    /**
     * ������� ������� �� �������
     */
    public void printQueue(){
        Iterator<Double> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
    
    /**
     * ���������� ������� � ����
     * @param filename ��� ����� 
     */
    public void saveQueueToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            if (!queue.isEmpty()) {
                Iterator<Double> iterator = queue.iterator();
                while (iterator.hasNext()) {
                    writer.write(iterator.next() + " ");
                }
            }
        } catch (IOException e) {
            System.out.println("������ ��� ������ � ����: " + e.getMessage());
        }
    }
}
