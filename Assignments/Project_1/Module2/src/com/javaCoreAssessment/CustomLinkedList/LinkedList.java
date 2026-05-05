package com.javaCoreAssessment.CustomLinkedList;

import com.javaCoreAssessment.model.Task;

public class LinkedList
{
    private Node head;

    // ADD TASK
    public synchronized void addTask(Task task)
    {
        Node newNode = new Node(task);

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task Added Successfully.");
    }

    // DELETE TASK
    public synchronized void deleteTask(int taskId)
    {
        if (head == null) return;

        if (head.data.getTaskId() == taskId)
        {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null)
        {
            if (temp.next.data.getTaskId() == taskId)
            {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // SEARCH
    public synchronized Task searchTask(int taskId)
    {
        Node temp = head;
        while (temp != null)
        {
            if (temp.data.getTaskId() == taskId)
            {
                return temp.data;
            }

            temp = temp.next;
        }
        return null;
    }

    // DISPLAY
    public synchronized void displayTasks()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // REVERSE
    public synchronized void reverseTasks()
    {
        Node prev = null, current = head, next;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        System.out.println("Task list reversed.");
    }


    // COUNT
    public synchronized int getTaskCount()
    {
        int count = 0;
        Node temp = head;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Thread Method For Processing Each Task
    public synchronized Task getNextPendingTask()
    {
        Node temp = head;

        while (temp != null)
        {
            if (temp.data.getStatus().equals("PENDING"))
            {
                temp.data.setStatus("IN_PROGRESS"); // (In_Progress)
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }
}

