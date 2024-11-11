package kolektsii;

import java.util.Scanner;

/**
 * ����� �������������� � �������������.
 * � ��� ������������� ���� � �����
 * @author ktyui
 */
public class UI {
    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("���������: �������� �. ����� �.");
        System.out.println("������� 9");
        System.out.println("�������:");
        System.out.println("������� ������� � ��������� �� ������������� �������. ��������� \n" +
                            "����������� ����� ��������� � ������� ���, ����� � �� ������ ��� \n" +
                            "���������� ���������� �������. ��������� ��������� � ����. ������� \n" +
                            "�������� ��� ���������.");
        MyQueue queue = new MyQueue();
        
        System.out.println("������� ����� ������ ������: " );
        int n;
        while (true){
            if (scan.hasNextInt()) {
                n = scan.nextInt();
                break;
            } else {
                System.out.println("������: ������� ����� �����");
                scan.next(); 
            }
        }
        
        System.out.println("������� �����: " );
        queue.fillQueue(scan, n);
        
        System.out.println("�������:");
        queue.printQueue();
        
        queue.cyclicShift();
        
        System.out.println("");
        System.out.println("����� ������:");
        queue.printQueue();
        System.out.println("");
        
        String fileName = "Test1.txt"; 
        queue.saveQueueToFile(fileName);
        System.out.println("����� ��������� � ���� " + fileName);
    }
}
