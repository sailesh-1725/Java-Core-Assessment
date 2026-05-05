package com.javaCoreAssessment.MultiThread;

import com.javaCoreAssessment.CustomLinkedList.LinkedList;
import com.javaCoreAssessment.model.Task;

public class TaskProcess implements Runnable
{
    private LinkedList list;

    public TaskProcess(LinkedList list)
    {
        this.list = list;
    }

    @Override
    public void run()
    {
        while (true)
        {
            Task task = list.getNextPendingTask();

            if (task == null)
            {
                break;
            }

            System.out.println(Thread.currentThread().getName() + " processing Task ID: " + task.getTaskId());

            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            task.setStatus("COMPLETED");

            System.out.println(Thread.currentThread().getName() + " completed Task ID: " + task.getTaskId());
        }
    }
}
