package com.javaCoreAssessment.controller;

import java.util.Scanner;
import com.javaCoreAssessment.model.Task;
import com.javaCoreAssessment.CustomLinkedList.LinkedList;
import com.javaCoreAssessment.MultiThread.TaskProcess;

public class Application
{
    static void main()
    {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true)
        {
            System.out.println(" \n 1. Add Task 2. Delete Task 3. Search Task 4. Display Task 5. Reverse Task 6. Start Task Process 7. Exit");
            int choice = sc.nextInt();

            switch (choice)
            {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Priority: (HIGH - MEDIUM - LOW) - ");
                    String priority = sc.nextLine();

                    list.addTask(new Task(id, name, priority));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    list.deleteTask(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Task t = list.searchTask(sc.nextInt());
                    System.out.println(t != null ? t : "Task not found");
                    break;

                case 4:
                    list.displayTasks();
                    break;

                case 5:
                    list.reverseTasks();
                    break;

                case 6:
                    System.out.println("Starting Task Processing...");

                    Thread t1 = new Thread(new TaskProcess(list), "Worker-1");
                    Thread t2 = new Thread(new TaskProcess(list), "Worker-2");

                    t1.start();
                    t2.start();

                    try
                    {
                        t1.join();
                        t2.join();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    System.out.println("All tasks completed.");
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}
