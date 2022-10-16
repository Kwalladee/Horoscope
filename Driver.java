import java.lang.Math;

//import SinglyLinkedList.Node;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.lang.Integer;

public class Driver {
    public static void main(String args[]){
        String fileDates = "dates.txt";
        String fileSLL = "sll.txt";
        String fileDLL = "dll.txt";
        int dates = 100;
        
        SinglyLinkedList<Node<Numerology>> sll = new SinglyLinkedList<Node<Numerology>>();
        DoublyLinkedList<NodeDLL<Numerology>> dll = new DoublyLinkedList<NodeDLL<Numerology>>();

        for(int i = 0; i < dates; i++){
            int[] dateArr = generateDates(fileDates, dates);
            int magicNumber = numberMagic(fileDates, dates, i);
            Numerology num = new Numerology(dateArr, magicNumber);

            sll.addLast(num);
            dll.addLast(num);
        }
        writeSLLReports(fileSLL, sll, dates);
        writeDLLReports(fileDLL, dll, dates);



    }

    static int[] generateDates(String fileRW, int dates){
        
        int monthMin = 1;
        int monthMax = 12;
        int dayMin = 1;
        int dayMax = 31;
        int yrMin = 1500;
        int yrMax = 2020;

            int month = (int)Math.floor(Math.random()*(monthMax - monthMin +1) + monthMin);
            int day;

            if(month == 2){
                day = (int)Math.floor(Math.random()*(dayMax - dayMin -2) + dayMin);
            } else if (month == 4 || month == 9 || month == 6 || month == 11){
                day = (int)Math.floor(Math.random()*(dayMax - dayMin) + dayMin);
            } else{
                day = (int)Math.floor(Math.random()*(dayMax - dayMin +1) + dayMin);
            }

            int year = (int)Math.floor(Math.random()*(yrMax - yrMin + 1) + yrMin);
            int[] dateArr = {month, day, year};
            writeDates(month, day, year, fileRW);
            return dateArr;
    }

    static int numberMagic(String fileName, int dates, int lineToRead){
        int crunch = 0;
        try{FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            for(int i = 0; i < lineToRead; i++){ //gets us to the correct line in the file to read
                br.readLine();
            }

            String line = br.readLine();//reads in the correct line to the buffered reader
            String[] dateStr = line.split("/");
            int[] date = new int[dateStr.length];

            for(int j = 0; j < dateStr.length; j++){
                date[j] = Integer.parseInt(dateStr[j]);
                crunch += date[j];
            }
            br.close();

        } catch (FileNotFoundException e){System.out.println("File was not found...");
        } catch (IOException f){System.out.println("IOException...");}
        int magicNumber = crunchNumbers(crunch);
        return magicNumber;
    }

    static int crunchNumbers(int number){
        int result = 0;
        String numberStr = String.valueOf(number);
        number = 0;
        while(numberStr.length() != 1){
            number = 0;
            for(int i = 0; i < numberStr.length(); i++){
                number += (numberStr.charAt(i) - 48);
            }
            numberStr = String.valueOf(number);
        }
        result = number -1;
        return result;
    }

    static void writeDates(int month, int day, int year, String fileRW){
        try{
            FileWriter fw = new FileWriter(fileRW, true);
            fw.write(month + "/" + day + "/" + year);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.flush();
            fw.close();
        } catch (IOException e){System.out.println("IOException");}
    }

    static void writeSLLReports(String fileSLL, SinglyLinkedList<Node<Numerology>> sll, int dates){
        Node<Numerology> currentNode = sll.head;
        Numerology current = currentNode.element;
        for(int i = 0; i < dates; i++){
            try{
                    FileWriter fw = new FileWriter(fileSLL, true);
                    fw.write(current.month + "/" + current.day + "/" + current.year);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.newLine();
                    bw.write(current.prediction);
                    bw.newLine();
                    bw.newLine();
                    bw.flush();
                    fw.close();
            } catch (IOException e){System.out.println("IOException");}
            if(i!=dates-1){
                currentNode = currentNode.next;
                current = currentNode.element;
            }
        }
    }
    static void writeDLLReports(String fileDLL, DoublyLinkedList<NodeDLL<Numerology>> dll, int dates){
        NodeDLL<Numerology> trailerNode = dll.trailer;
        NodeDLL<Numerology> currentNode = trailerNode.prev;
        Numerology current = currentNode.element;
        for(int i = 0; i < dates; i++){
            try{
                FileWriter fw = new FileWriter("dll.txt", true);
                fw.write(current.month + "/" + current.day + "/" + current.year);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(dll.last().prediction);
                bw.newLine();
                bw.newLine();
                bw.flush();
                fw.close();
            } catch (IOException e){System.out.println("IOException");}
            if(i != dates -1){
                currentNode = currentNode.prev;
                current = currentNode.element;
            }
        }
    }
}
